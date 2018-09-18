import java.util.ArrayList;
import java.util.Scanner;

public class myLong {
    private ArrayList<Integer> myNums;

    public myLong() {
        myNums = new ArrayList<Integer>();

    }


    public void setLong(String numbers) {
        String strNums = numbers;

        myNums = new ArrayList<Integer>(strNums.length());

        for (int i = 0; i < strNums.length(); ++i) {
            int addDigit = Character.getNumericValue(strNums.charAt(i));
            myNums.add(addDigit);
            //Each digit is stored as a separate entry to the array
        }
    }

    public ArrayList getLong(){
        return myNums;
    }



}

