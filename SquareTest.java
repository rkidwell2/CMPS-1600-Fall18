import junit.framework.TestCase;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.Assert;

public class SquareTest extends TestCase {

    Square testsquare = new Square(4);
    @Override
    protected void setUp(){
        Square testsqr = new Square(4);
    }

    @Test
    public void testToString() {
        System.out.println("Running toString test...");
        String stringtest = testsquare.toString();
        Assert.assertThat(stringtest, CoreMatchers.is("Square, 4.0 x 4.0"));
    }

    @Test
    public void testEquals() {
        System.out.println("Running equality test...");
        //case 1 = equal
        Square test2 = new Square(4);
        Boolean equalstest = testsquare.equals(test2);
        Assert.assertThat(equalstest, CoreMatchers.is(true));

        //case 2, not equal
        Square test3 = new Square(3);
        Boolean notequalstest = testsquare.equals(test3);
        Assert.assertThat(notequalstest, CoreMatchers.is(false));
    }

    @Test
    public void areaTest(){
        System.out.println("Running area test...");
        double myarea= 16;
        double testarea = testsquare.area();
        Assert.assertThat(myarea, CoreMatchers.is(testarea));
    }

    @Test
    public void perimeterTest(){
        System.out.println("Running perimeter test...");
        double myperim= 16;
        double testPerim = testsquare.perimeter();
        Assert.assertThat(myperim, CoreMatchers.is(testPerim));
    }

    @Override
    protected void tearDown(){
        Square test1 =null;
    }
}


