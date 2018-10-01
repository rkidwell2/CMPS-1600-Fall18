public class Rectangle extends Shape{

    protected double length;
    protected double height;
    protected double perimeter;
    protected double area;

    // Default constructor
    public Rectangle() {
        length = 0;
        height = 0;
        shapeCount += 1;

    }

    public Rectangle(double l, double h) {
        length = l;
        height = h;
        perimeter = (2 * length) + (2 * height);
        area = length * height;
    }

    public double area() {
        return length * height;
    }

    public double perimeter() {
        return (2 * length) + (2 * height);
    }

    public String getShape(){
        return "Rectangle";
    }

}
