import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class PointSet {
    private HashSet<Point3> points = new HashSet<>();
    private boolean set = false;

    public HashSet<Point3> getPoints() {
        if(!set) {
            throw new IllegalStateException(
                    "Points have not been set");
        }
        return new HashSet<>(points);
    }

    protected void setPoints(Collection<Point3> pos) {
        if (!set) {
            points.addAll(pos);
        } else {
            throw new IllegalStateException("Points have" +
                    " already been set");
        }
    }

}
