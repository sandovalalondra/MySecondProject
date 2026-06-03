public class ShapeArray {
    public static void main(String[] args) {

        Shape sphere = new Sphere(5.0);
        Shape cylinder = new Cylinder(4.0, 10.0);
        Shape cone = new Cone(3.0, 7.0);

        Shape[] shapeArray = { sphere, cylinder, cone };

        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println("----------------------");
        }
    }
}