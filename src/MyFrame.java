import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
        reInitButton.addActionListener(e ->
                reinitialize(
                        Double.parseDouble(xField.getText()),
                        Double.parseDouble(yField.getText()),
                        Double.parseDouble(zField.getText()),
                        Double.parseDouble(yPlField.getText()),
                        Double.parseDouble(radField.getText())
                )
        );

        panel.add(reInitButton);
        panel.add(xField);
        panel.add(yField);
        panel.add(zField);
        panel.add(yPlField);
        panel.add(radField);

        InputMap imap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap amap = panel.getActionMap();

        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0),
                "decreaseX");
        amap.put("decreaseX", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Camera camera = space.getCam();
                    Point3 origin = camera.getOrig();
                    reinitialize(origin.getX() - 5, origin.getY(),
                            origin.getZ(), camera.getYPlane(),
                            camera.getCircleRad());
            }
        });

        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0),
                "increaseX");
        amap.put("increaseX", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Camera camera = space.getCam();
                Point3 origin = camera.getOrig();
                reinitialize(origin.getX() + 5, origin.getY(),
                        origin.getZ(), camera.getYPlane(),
                        camera.getCircleRad());
            }
        });

        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0),
                "increaseZ");
        amap.put("increaseZ", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Camera camera = space.getCam();
                Point3 origin = camera.getOrig();
                reinitialize(origin.getX(), origin.getY(),
                        origin.getZ() + 5, camera.getYPlane(),
                        camera.getCircleRad());
            }
        });

        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0),
                "decreaseZ");
        amap.put("decreaseZ", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Camera camera = space.getCam();
                Point3 origin = camera.getOrig();
                reinitialize(origin.getX(), origin.getY(),
                        origin.getZ() - 5, camera.getYPlane(),
                        camera.getCircleRad());
            }
        });

        add(panel);
    }

    private void reinitialize(double x, double y, double z,
                              double yPl, double rad) {
        space.setCam(new Camera(new Point3(x, y, z),
                yPl, rad));
    }
}
