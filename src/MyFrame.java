import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private EuclideanSpace space;
    private JPanel panel;

    public MyFrame() {
        space = new EuclideanSpace(new Camera(
                new Point3(1, 0, 1), -1, 1));
        space.addShape(new Sphere(0, 8, 1, 1, Color.GREEN));
        space.addShape(new Sphere(-1, 30, 1, 1, Color.BLUE));
        space.addShape(new Sphere(0, 8, 3, 1, Color.RED));
        panel = new JPanel();
        panel.add(space);


        JTextField xField = new JTextField("x");
        JTextField yField = new JTextField("y");
        JTextField zField = new JTextField("z");
        JTextField yPlField = new JTextField("y plane");
        JTextField radField = new JTextField("radius");

        JButton reInitButton = new JButton("ReInit");
        reInitButton.addActionListener(e -> space.setCam(
                new Camera(
                        new Point3(
                                Double.parseDouble(xField.getText()),
                                Double.parseDouble(yField.getText()),
                                Double.parseDouble(zField.getText())
                        ),
                        Double.parseDouble(yPlField.getText()),
                        Double.parseDouble(radField.getText())
                )
        ));

        panel.add(reInitButton);
        panel.add(xField);
        panel.add(yField);
        panel.add(zField);
        panel.add(yPlField);
        panel.add(radField);
        add(panel);
    }

}
