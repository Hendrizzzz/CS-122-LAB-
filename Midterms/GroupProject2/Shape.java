public abstract class Shape {
    private String name;
    protected int sides;
    public Shape(String name) {
        this.name = name;
    }
    public String toString() {
        return name + "with" + sides + "sides";
    }
    public int getSides() {
        return sides;
    }
    // declaration of the abstract methods
    public abstract double area();
    public abstract double perimeter();
}
