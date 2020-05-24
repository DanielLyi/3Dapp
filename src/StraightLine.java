import java.util.ArrayList;

public class StraightLine extends PointSet {

    public StraightLine(double x0, double y0, double z0,
                        double vecX, double vecY, double vecZ) {
        ArrayList<Point3> set = new ArrayList<>();
        for (double t = -5.0; t < 10.0; t = t + 0.1) {
            set.add(new Point3(t * vecX + x0,
                    t * vecY + y0, t * vecZ + z0));
        }
        super.setPoints(set);
    }
}
