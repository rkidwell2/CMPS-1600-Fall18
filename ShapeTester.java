import java.util.ArrayList;
import java.util.Collections;

public class ShapeTester {

    /**
     * Uses the display method to display each element of an array list of shapes
     * @param arraylist
     */
    public static void displayArray(ArrayList<Shape> arraylist) {
        for (int i = 0; i < arraylist.size(); ++i) {
            Shape element = arraylist.get(i);
            element.display();

        }
    }

    public static void main(String []args){

        ArrayList<Shape> testarray = new ArrayList<Shape>();
        Circle circtest = new Circle(7);
        Triangle tritest = new Triangle (10,12,13);
        Rectangle rectest = new Rectangle (5, 4);
        Square sqrtest = new Square(3);
        Circle anothercircle = new Circle(5.8);
        Triangle anothertri = new Triangle(3, 3, 3);

        testarray.add(circtest);
        testarray.add(tritest);
        testarray.add(rectest);
        testarray.add(anothercircle);
        testarray.add(sqrtest);
        testarray.add(anothertri);

        //Below function is no longer needed as we now have a display method
        /*for (int i = 0; i < testarray.size(); ++i) {
            Shape element = testarray.get(i);
            System.out.println(element.getShape());
        }

        System.out.println();*/

        for (int i = 0; i < testarray.size(); ++i) {
            Shape element = testarray.get(i);
            if (element instanceof Circle){
                System.out.println("Circle's position in array: " + i);

            }

        }
        System.out.println();
        System.out.println("Shape count: " + Shape.getShapeCount() + "\n");

        //Unsorted array
        System.out.println("Unsorted array:");
        displayArray(testarray);

        Collections.sort(testarray);

        //Sorted array
        System.out.println("Sorted array:");
        displayArray(testarray);
    }

}
