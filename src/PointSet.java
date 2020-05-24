import java.util.ArrayList;

public abstract class PointSet {
    private ArrayList<Point3> points = new ArrayList<>();
    private boolean set = false;

    public ArrayList<Point3> getPoints() {
        if(!set) {
            throw new IllegalStateException(
                    "Points have not been set");
        }
        return new ArrayList<>(points);
    }

    protected void setPoints(ArrayList<Point3> pos) {
        if (!set) {
            points.addAll(pos);
        } else {
            throw new IllegalStateException("Points have" +
                    " already been set");
        }
    }

}
