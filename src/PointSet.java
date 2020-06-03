import java.awt.*;
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
    private Color color;

    public PointSet() {
        color = Color.BLACK;
    }

    public PointSet(Color c) {
        color = c;
    }

    public HashSet<Point3> getPoints() {
        /*If no points throw an Exception*/
        if (!set) {
            throw new IllegalStateException(
                    "Points have not been set");
        }
        /*Copy the entries to a new set*/
        return new HashSet<>(points);
    }

    protected void setPoints(Collection<Point3> pos) {
        if (pos == null) {
            throw new IllegalArgumentException(
                    "Collection should not be null");
        }
        if (pos.size() == 0) {
            throw new IllegalArgumentException(
                    "Collection shouldn't be empty");
        }
        /*If points have already been set,
           throw an Exception.*/
        if (!set) {
            /*If points weren't set yet,
              copy given entries to the local set*/
            points.addAll(pos);
            set = true;
        } else {
            throw new IllegalStateException("Points have" +
                    " already been set");
        }
    }

    public Color getColor() {
        return color;
    }
}
