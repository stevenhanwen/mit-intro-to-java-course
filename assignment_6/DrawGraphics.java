package assignment_6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {

    ArrayList<Bouncer> bouncers = new ArrayList<>();
    Bouncer movingSprite1;
    Bouncer movingSprite2;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box1 = new Rectangle(15, 20, Color.RED);
        movingSprite1 = new Bouncer(100, 170, box1);
        movingSprite1.setMovementVector(3, 1);
        bouncers.add(movingSprite1);

        Oval oval1 = new Oval(50, 50, Color.BLUE);
        movingSprite2 = new Bouncer(50, 50, oval1);
        movingSprite2.setMovementVector(2, 2);
        bouncers.add(movingSprite2);

    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {

        for (Bouncer bouncer : bouncers) {
            bouncer.draw(surface);
        }
    }
}
