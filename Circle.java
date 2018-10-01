public class Circle extends Shape{
    protected double radius;

    public Circle(double diameter){
        shapeCount += 1;
        radius = diameter/2;

    }

    public double area(){
        return Math.PI * Math.pow(radius, 2);

    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    public String getShape(){
        return "Circle";
    }



}
