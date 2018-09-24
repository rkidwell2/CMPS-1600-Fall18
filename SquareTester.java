public class SquareTester {

    public static void main(String[] args){
        Square tester = new Square(6);
        System.out.println(tester);
        System.out.println(tester.getArea());
        System.out.println(tester.getPerimeter());

        Square testcorrect = new Square(6);
        Square wrong = new Square(7);
        Rectangle testrect2 = new Rectangle(9,6);


        Rectangle testrect = new Rectangle(6,9);
        System.out.println(testrect);
        System.out.println(testrect.getArea());
        System.out.println(testrect.getPerimeter());

        System.out.println(tester.equals(testrect)); //False, not equal
        System.out.println(tester.equals(testcorrect)); //True, equal squares
        System.out.println(tester.equals(wrong)); //False, unequal squares
        System.out.println(testrect.equals(testrect2)); //True, equal rectangles
    }

}
