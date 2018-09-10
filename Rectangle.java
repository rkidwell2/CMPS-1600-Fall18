public class Rectangle {

    private double length;
    private double height;
    private double perimeter;
    private double area;

    static int instanceCounter = -1;
    int counter = -1;

    int rectangleID;

    Rectangle(double l, double h){

        instanceCounter++;
        counter = instanceCounter;

        length = l;
        height = h;
        rectangleID = counter;
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




}
