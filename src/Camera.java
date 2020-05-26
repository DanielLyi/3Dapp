public class Camera {
    private Point3 orig;
    private double yPlane;
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
