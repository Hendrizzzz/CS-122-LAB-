public class Rectangle extends Square{
    private double side2;
    public Rectangle(String name, double side1, double side2) {
        super(name, side1);
        this.side2 = side2;
    }

    @Override
    public double area() {
        return side2 * side;
    }

    @Override
    public double perimeter() {
        return 2 * side2 + 2 * side;
    }
}
