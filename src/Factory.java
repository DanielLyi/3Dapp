public class Factory {
    public static void main(String[] args) {
        PointSet ps1 = new Sphere(0, 0, 0, 1);
        System.out.println(ps1.getPoints().toString());
    }
}
