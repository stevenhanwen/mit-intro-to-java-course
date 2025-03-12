package assignment_5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

/**
 * BouncingTriangle is the class of a isoceles triangle.
 */

public class BouncingTriangle {

    // array of the x and y coordinates of the three vertices
    // index 0 is the middle vertex, index 1 is the left vertex, index 2 is the
    // right vertex
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

        // if the left vertex or the right vertex hits the bound, change direction.
        if ((xPoints[1] <= 0 && xDirection < 0) ||
                (xPoints[2] >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }

        // if the bottom edge or the middle vertex hits the bound, change direction.
        if ((yPoints[0] <= 0 && yDirection < 0) ||
                (yPoints[1] >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
}