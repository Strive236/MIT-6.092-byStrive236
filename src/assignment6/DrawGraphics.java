package assignment6;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraphics {
    ArrayList<Mover> movers = new ArrayList<>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        // add movingSprites
        Rectangle box = new Rectangle(15, 20, Color.RED);
        movers.add(new Bouncer(100, 170, box));
        movers.get(0).setMovementVector(3, 1);

        Oval oval = new Oval(30, 15, Color.BLUE);
        movers.add(new Bouncer(150, 150, oval));
        movers.get(1).setMovementVector(-1, -1);

        // add straightMovers
        Rectangle box1 = new Rectangle(15, 20, Color.RED);
        movers.add(new StraightMover(20, 20, box1));
        movers.get(2).setMovementVector(3, 1);

        Oval oval1 = new Oval(30, 15, Color.BLUE);
        movers.add(new StraightMover(200, 200, oval1));
        movers.get(3).setMovementVector(-3, -3);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        // draw movers
        for (Mover mover: movers) {
            mover.draw(surface);
        }
    }
}
