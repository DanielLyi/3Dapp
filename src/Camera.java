/**
 * A class for projecting 3D objects to 2D plane.
 */
public class Camera {
    /**
     * We make a line ("ray") starting from
     * orig to a point we want to project.
     */
    private Point3 orig;
    /**
     * We use yPlane to intersect the ray
     * with this plane (e.g. y = a; a is double).
     */
    private double yPlane;
    /**
     * If ray intersects plane inside a circle
     * with radius circleRad and the center
     * at the same x and z and the given
     * y coordinate, then we show it on
     * screen
     */
    private double circleRad;

    public Camera(Point3 orig, double yPlane,
                  double circRad) {
        this.orig = orig;
        this.yPlane = yPlane;
        this.circleRad = circRad;
    }

    public Point3 getOrig() {
        return orig;
    }

    public double getYPlane() {
        return yPlane;
    }

    public double getCircleRad() {
        return circleRad;
    }
}
