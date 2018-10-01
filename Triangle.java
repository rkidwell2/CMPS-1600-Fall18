public class Triangle extends Shape {
    double s1;
    double s2;
    double s3;


    public Triangle(double side1, double side2, double side3){
        s1 = side1;
        s2 = side2;
        s3 = side3;
        shapeCount += 1;

    }

    public double area(){
        double p = (s1 + s2+ s3)/2;
        double ans = Math.sqrt(p * (p-s1) * (p-s2) * (p-s3));
        return ans;
    }

    public double perimeter(){
        return (s1 + s2 + s3);
    }

    @Override
    public String getShape() {
        return "Triangle";
    }


}
