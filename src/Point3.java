public class Point3 {
    private double x;
    private double y;
    private double z;

    public Point3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y
                + ", " + z + ">";
    }
}
