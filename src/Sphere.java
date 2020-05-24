import java.util.ArrayList;

import static java.lang.Math.*;

public class Sphere extends PointSet {
    public Sphere(double a, double b, double c, double rad) {
        ArrayList<Point3> points = new ArrayList<>();
        double s;
        double t = -0.5 * PI;
        while (t <= 0.5 * PI) {
            s = 0;
            while (s < 2 * PI) {
                points.add(new Point3(a + rad * cos(t) * cos(s)
                        , b + rad * cos(t) * sin(s), c + rad * sin(t)));
                s = s + 0.05;
            }
            t = t + 0.05;
        }

        super.setPoints(points);
    }
}
