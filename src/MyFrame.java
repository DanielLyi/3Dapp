import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        init();
    }

    private void init() {
        EuclideanSpace space = new EuclideanSpace(new Camera(
                new Point3(1, 0, 1), 1, 1
        ));
        space.addShape(new Sphere(0, 8, 1, 1, Color.GREEN));
        space.addShape(new Sphere(-1, 30, 1, 1, Color.BLUE));
        JPanel panel = new JPanel();
        panel.add(space);
        add(panel);

        for (PointSet shape : space.getShapes()) {
            System.out.println("Spere:");
            for(Point3 poin: shape.getPoints()) {
                System.out.println(poin);
            }
        }
    }
}
