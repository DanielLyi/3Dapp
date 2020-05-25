import java.util.Collection;
import java.util.HashSet;

/**
 * An abstract class that serves
 * as a set of Point3 objects.
 */
public abstract class PointSet {
    private HashSet<Point3> points = new HashSet<>();
    /*Check if points are set*/
    private boolean set = false;

    public HashSet<Point3> getPoints() {
        /*If no points throw an Exception*/
        if(!set) {
            throw new IllegalStateException(
                    "Points have not been set");
        }
        /*Copy the entries to a new set*/
        return new HashSet<>(points);
    }

    protected void setPoints(Collection<Point3> pos) {
        /*If points have already been set,
           throw na Exception.*/
        if (!set) {
            /*If points weren't set yet,
              copy given entries to the local set*/
            points.addAll(pos);
        } else {
            throw new IllegalStateException("Points have" +
                    " already been set");
        }
    }

}
