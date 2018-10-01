import java.lang.Math.*;
public abstract class Shape {

    public static int shapeCount;

    public static int getShapeCount(){
        return shapeCount;
    }

    public Shape(){

    }

    public abstract double area();

    public abstract double perimeter();

    public abstract String getShape();

}
