import java.util.ArrayList;

/**
 * A class that serves as a set of Points3,
 * corresponding to a straight line.
 */
public class StraightLine extends PointSet {

    /**
     * A constructor of the straight line.
     * All the points are automatically
     * added based on the values given.
     * One must provide the point (x0, y0, z0)
     * through which this line passes, and the
     * vector (vecX, vecY, vecZ) which shows
     * the direction of the line.
     * @param x0 x coordinate of the point
     * @param y0 y coordinate of the point
     * @param z0 z coordinate of the point
     * @param vecX x coordinate of the vector
     * @param vecY y coordinate of the vector
     * @param vecZ z coordinate of the vector
     */
    public StraightLine(double x0, double y0, double z0,
                        double vecX, double vecY, double vecZ) {
        ArrayList<Point3> set = new ArrayList<>();
        /*Using the parametric equation for the line
        * to add the points*/
        for (double t = -5.0; t < 10.0; t = t + 0.1) {
            set.add(new Point3(t * vecX + x0,
                    t * vecY + y0, t * vecZ + z0));
        }
        super.setPoints(set);
    }
}
