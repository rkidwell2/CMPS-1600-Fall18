public class Square extends Rectangle {


    public Square(double side){
       length = side;
       height = side;
       area = side * side;
       perimeter = 4 * side;

    }

    @Override
    public String toString() {
        return ("Square, " + length + " x " + height) ;
    }


    public boolean equals(Object other){
        if (other instanceof Square){
            Square s = (Square) other;
            return this.area == s.area;
        }
        return false;

    }
}
