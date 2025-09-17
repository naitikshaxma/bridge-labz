\\Write a Circle class with a radius attribute. Use constructor chaining to initialize radius with default and user-provided values.
public class Circle {
    double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
