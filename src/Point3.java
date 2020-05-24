/**
 * A class that represents a vector of a
 * form (x, y, z), where x, y and z are
 * in a subset of real numbers.
 */
public class Point3 {
    /*Cartesian coordinates of the point*/
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

    /**
     * Checks if a specified object equals to this one.
     * @param obj an object to compare with
     * @return true if and only if obj
     * is Point and the corresponding coordinates
     * are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }

        Point3 p3 = (Point3) obj;
        return p3.x == x && p3.y == y &&
                p3.z == z;

    }

    /**
     * Returns a String
     * representation of the vector
     * in the form (x, y, z).
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y
                + ", " + z + ")";
    }
}
