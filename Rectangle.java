public class Rectangle {

    protected double length;
    protected double height;
    protected double perimeter = (2 * length) + (2 * height);
    protected double area = length * height;

    static int instanceCounter = -1;
    int counter = -1;

    int rectangleID;

// Default constructor
    public Rectangle(){

        instanceCounter++;
        counter = instanceCounter;

        length = 0;
        height = 0;
        rectangleID = counter;
    }
    public Rectangle(double l, double h){

        instanceCounter++;
        counter = instanceCounter;

        length = l;
        height = h;
        rectangleID = counter;
        perimeter = (2 * length) + (2 * height);
        area = length * height;
    }

    public double area(){
        return length * height;
    }

    public double perimeter(){
        return (2 * length) + (2 * height);
    }
    public double getLength(){
        return length;
    }

    public void setLength(double x){
        length = x;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double x){
        height = x;
    }

    public double getPerimeter(){
        return perimeter;
    }


    public double getArea(){
        return area;
    }

    public int getRectangleID(){
        return rectangleID;
    }

    @Override
    public String toString() {
        return "Rectangle, " + length + " x " + height;
    }

    public boolean equals(Object other){
        if (other instanceof Rectangle){
            Rectangle s = (Rectangle) other;
            return this.area == s.area;
        }
        return false;

    }
}
