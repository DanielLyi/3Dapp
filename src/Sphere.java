import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.*;

/**
 * A class that serves as a set of Points3,
 * corresponding to a sphere.
 */
public class Sphere extends PointSet {
    /**
     * A constructor of the sphere. All the points
     * are automatically added based on the
     * values given.
     *
     * @param x0  x coordinate of the center
     * @param y0  y coordinate of the center
     * @param z0  z coordinate of the center
     * @param rad radius of the sphere
     */
    public Sphere(double x0, double y0, double z0, double rad, Color c) {
        super(c);
        ArrayList<Point3> points = new ArrayList<>();
        /*Using parametric equation for the sphere
         * based on two parameters*/
        double s;
        double t = -0.5 * PI;
        while (t <= 0.5 * PI) {
            s = 0;
            while (s < 2 * PI) {
                points.add(new Point3(x0 + rad * cos(t) * cos(s)
                        , y0 + rad * cos(t) * sin(s), z0 + rad * sin(t)));
                s = s + 0.5;
            }
            t = t + 0.5;
        }
        //Adding all the points formed
        super.setPoints(points);
    }

    public Sphere(double x0, double y0, double z0, double rad) {
        this(x0, y0, z0, rad, Color.BLACK);
    }
}