public class Square extends Rectangle {


    public Square(double side){
        length = side;
        height = side;
        shapeCount += 1;

    }

    @Override
    public String toString() {
        return ("Square, " + length + " x " + height) ;
    }

    @Override
    public String getShape(){
        return "Square";
    }


}

