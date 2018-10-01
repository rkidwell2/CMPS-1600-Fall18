public abstract class Shape implements Displayable, Comparable<Shape>{

    public static int shapeCount;

    /**
     *Method returns the shape count, which keeps track of each instance of
     * a shape being created
     */
    public static int getShapeCount(){
        return shapeCount;
    }

    public Shape(){

    }

    /**
     *
     * @return area of the shape
     */
    public abstract double area();

    /**
     *
     * @return perimeter of the shape
     */
    public abstract double perimeter();

    public abstract String getShape();

    /**
     * Displays each shape's type, area, and perimeter
     */
    public void display(){
        System.out.println("Shape: " + getShape());
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter() +"\n");

    }

    @Override
    public int compareTo(Shape o) {
        int a = 0;
        if (this.area()< o.area()){
            a = -1;
        }
        if (this.area() > o.area()){
            a = 1;
        }
        if (this.area() == o.area()){
            a = 0;
        }
        return a;
    }
}
