import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashSet;

public class EuclideanSpace extends JComponent {
    public static final double SIDE_LENGTH = 800;
    private ArrayList<PointSet> shapes;
    private Camera cam;

    public EuclideanSpace(Camera cam) {
        shapes = new ArrayList<>();
        this.cam = cam;
    }

    public Camera getCam() {
        return cam;
    }

    public void setCam(Camera cam) {
        this.cam = cam;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (PointSet shape : shapes) {
            ArrayList<Ellipse2D.Double> ells = new ArrayList<>();

            HashSet<Point3> points = shape.getPoints();
            for (Point3 point : points) {
                /*vector: /origX\     /x0\
                          |origY|  -  |y0|
                          \origZ/     \z0/

                          (vector subtraction)*/

                double vecX = cam.getOrig().getX() - point.getX();
                double vecY = cam.getOrig().getY() - point.getY();
                double vecZ = cam.getOrig().getZ() - point.getZ();

                StraightLine line = new StraightLine(
                        point.getX(), point.getY(), point.getZ(),
                        vecX, vecY, vecZ
                );

                /*Finding an intersection with the y-plane*/
                Point3 project = line.getPointWithNearestY(cam.getYPlane());

                /*"Unit" is radius of the camera project. circle*/
                double unitX = (project.getX() - cam.getOrig().getX()) /
                        cam.getCircleRad();
                double unitY = (project.getZ() - cam.getOrig().getZ()) /
                        cam.getCircleRad();

                double screenX = SIDE_LENGTH / 2 + unitX * SIDE_LENGTH / 2;
                double screenY = SIDE_LENGTH / 2 - unitY * SIDE_LENGTH / 2;

                ells.add(new Ellipse2D.Double(
                        screenX - 6, screenY - 6,
                        12, 12));
            }

            if (shape.getColor() != null) {
                g2.setPaint(shape.getColor());
            } else {
                g2.setPaint(Color.BLACK);
            }
            for (Ellipse2D.Double ell : ells) {
                g2.fill(ell);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) SIDE_LENGTH, (int) SIDE_LENGTH);
    }

    public void addShape(PointSet shape) {
        shapes.add(shape);
    }

    public ArrayList<PointSet> getShapes() {
        return new ArrayList<>(shapes);
    }
}

