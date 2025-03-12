package assignment_5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BouncingTriangle {
    int[] xPoints = new int[3];
    int[] yPoints = new int[3];
    Color color;
    int xDirection = 0;
    int yDirection = 0;
    final int SIZE = 20;

    /**
     * Initialize a new box with its center located at (startX, startY), filled
     * with startColor.
     */
    public BouncingTriangle(int startX, int startY, Color startColor) {
        xPoints[1] = startX - 20;
        xPoints[2] = startX + 20;
        xPoints[3] = startX;

        yPoints[1] = startY;
        yPoints[2] = startY + 20;
        yPoints[3] = startY;

        color = startColor;
    }

    /** Draws the box at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the object
        surface.setColor(color);
        surface.fillPolygon(xPoints, yPoints, 3);
        surface.setColor(Color.BLACK);

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
        if ((xPoints[3] - SIZE / 2 <= 0 && xDirection < 0) ||
                (xPoints[3] + SIZE / 2 >= SimpleDraw.WIDTH && xDirection > 0)) {
            xDirection = -xDirection;
        }
        if ((yPoints[3] - SIZE / 2 <= 0 && yDirection < 0) ||
                (yPoints[3] + SIZE / 2 >= SimpleDraw.HEIGHT && yDirection > 0)) {
            yDirection = -yDirection;
        }
    }

    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }
}