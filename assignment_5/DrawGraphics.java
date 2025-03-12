package assignment_5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    BouncingBox box1;
    BouncingBox box2;
    BouncingBox box3;

    BouncingTriangle triangle;

    ArrayList<BouncingBox> boxes = new ArrayList<>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {

        triangle = new BouncingTriangle(200, 200, Color.BLUE);
        triangle.setMovementVector(1, 2);

        box1 = new BouncingBox(200, 50, Color.RED);
        box1.setMovementVector(1, 0);
        boxes.add(box1);

        box2 = new BouncingBox(200, 50, Color.BLUE);
        box2.setMovementVector(0, -2);
        boxes.add(box2);

        box3 = new BouncingBox(200, 50, Color.MAGENTA);
        box3.setMovementVector(1, 3);
        boxes.add(box3);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);

        triangle.draw(surface);

        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).draw(surface);
        }

        // Draw a rectangle
        surface.setColor(Color.BLUE);
        surface.fillRect(100, 100, 100, 50);

        surface.fillOval(250, 100, 100, 50);

        // Draw a circle
        surface.setColor(Color.RED);
        surface.fillOval(400, 100, 50, 50);

        // Draw a rounded rectangle
        surface.setColor(Color.MAGENTA);
        surface.fillRoundRect(100, 200, 100, 50, 20, 20);

        // Draw a polygon (triangle)
        surface.setColor(Color.ORANGE);
        int[] xPoints = { 200, 250, 225 };
        int[] yPoints = { 200, 200, 150 };
        surface.fillPolygon(xPoints, yPoints, 3);

    }

}