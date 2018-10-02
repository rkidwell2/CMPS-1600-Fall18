public class Rectangle extends Shape{

    protected double length;
    protected double height;


    // Default constructor
    public Rectangle() {
        length = 0;
        height = 0;
        shapeCount += 1;

    }

    public Rectangle(double l, double h) {
        length = l;
        height = h;

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
