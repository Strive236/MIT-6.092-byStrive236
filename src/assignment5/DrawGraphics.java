package assignment5;

import java.awt.*;
import java.util.ArrayList;

public class DrawGraphics {
    BouncingBox box;
    ArrayList<BouncingBox> boxs = new ArrayList<>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        box = new BouncingBox(200, 50, Color.RED);

        BouncingBox box1 = new BouncingBox(30, 10, Color.CYAN);
        box1.setMovementVector(5, 0);
        boxs.add(box1);

        BouncingBox box2 = new BouncingBox(10, 10, Color.YELLOW);
        box2.setMovementVector(1, 1);
        boxs.add(box2);

        BouncingBox box3 = new BouncingBox(10, 30, Color.GREEN);
        box3.setMovementVector(0, 2);
        boxs.add(box3);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(50, 50, 250, 250);
        box.draw(surface);

        // Task1
        // oval
        surface.drawOval(95, 100, 20, 10);
        surface.setColor(new Color(0x5B5BC9));
        surface.fillOval(95, 100, 20, 10);

        // string
        surface.setColor(Color.BLACK);
        surface.drawString("Strive236", 120, 50);

        // drawArc
        surface.drawArc(200, 150, 100, 100, 90, 90);
        surface.setColor(new Color(0xC04747));
        surface.fillArc(200, 150, 100, 100, 90, 90);

        // Task2
        for (BouncingBox bouncingBox : boxs) bouncingBox.draw(surface);
    }
}
