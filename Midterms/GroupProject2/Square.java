public class Square extends Shape{
    protected double side;

    public Square(String name, double side){
        super(name);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}
