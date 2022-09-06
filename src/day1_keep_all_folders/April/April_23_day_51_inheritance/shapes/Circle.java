package day1_keep_all_folders.April.April_23_day_51_inheritance.shapes;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super( "Circle" );
        this.radius = radius;
    }
    @Override
    public double area() {
        return radius*radius*Math.PI;
    }
    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

