/**
 * A class from which the program starts.
 * Contains the {@code main()} method.
 */
public class Factory {
    /**
     * The main method of the program. To
     * start it, start this method.
     * @param args arguments of the main
     */
    public static void main(String[] args) {
        PointSet ps1 = new Sphere(0, 0, 0, 1);
        System.out.println(ps1.getPoints().toString());
    }
}
