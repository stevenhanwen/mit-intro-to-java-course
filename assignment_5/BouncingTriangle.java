package assignment_5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

/**
 * BouncingTriangle is the class of a equilateral triangle.
 */

public class BouncingTriangle {

    // array of the x and y coordinates of the three vertices
    int[] xPoints = new int[3];
    int[] yPoints = new int[3];

    Color color;

    // increment of the movement, 0 means no movement
    int xDirection = 0;
    int yDirection = 0;

    // SIZE is used to define half the edge length of the triangle, for example,
    // SIZE = 10 is a triangle with a edge length of 20.
    final int SIZE = 30;

    /**
     * Initialize a new box with its center located at (startX, startY), filled
     * with startColor.
     * 
     * @param startX and StartY are the coordinates of the middle vertex.
     */
    public BouncingTriangle(int startX, int startY, Color startColor) {
        xPoints[0] = startX;
        xPoints[1] = startX - SIZE;
        xPoints[2] = startX + SIZE;

        yPoints[0] = startY - SIZE;
        yPoints[1] = startY + SIZE;
        yPoints[2] = startY + SIZE;

        System.out.println(Arrays.toString(xPoints));
        System.out.println(Arrays.toString(yPoints));

        color = startColor;
    }

    /** Draws the box at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the object
        surface.setColor(color);
        surface.fillPolygon(xPoints, yPoints, 3);

        // Set color to red and draw border of triangle
        surface.setColor(Color.RED);
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawPolygon(xPoints, yPoints, 3);

        // Move the center of the object each time we draw it
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] += xDirection;
        }

        for (int i = 0; i < yPoints.length; i++) {
            yPoints[i] += yDirection;
        }
        // If we have hit the edge and are moving in the wrong direction, reverse
        // direction
        // We check the direction because if a box is placed near the wall, we would get
        // "stuck"
        // rather than moving in the right direction

        // int leftVx = xPoints[0] - SIZE;
        // int leftVy = yPoints[0] -

        if ((xPoints[0] - SIZE <= 0 && xDirection < 0) ||
                (xPoints[0] + SIZE >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((yPoints[0] - SIZE <= 0 && yDirection < 0) ||
                (yPoints[0] + SIZE >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
}