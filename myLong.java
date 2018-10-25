/*
The myLong class is a class capable of holding and manipulating integers with size up to 100 digits.
Methods: setLong, add, subtract, multiply.

NOTE: myLongs that pass functions will NOT have the same value after the function has been passed.
You must reset the value of the myLong that passed a function if you wish to use it again.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class myLong{

    private ArrayList<Integer> myNums;
    private int length;
    boolean isNeg = false;

    public myLong() {
        myNums = new ArrayList<Integer>();
        int length = myNums.size();
    }


    @Override
    public String toString() {

        String returnString = "";
        deleteExcessZeros();
        for (int each : myNums) {
            returnString += each;
        }
        if (isNeg == true) {
            returnString = "-" + returnString;
        }
        return returnString;
    }

    public void setLong(String numbers) {

        String strNums = numbers;
        isNeg = false;
        myNums = new ArrayList<Integer>(strNums.length());

        deleteExcessZeros();

        for (char number : strNums.toCharArray()) {
            if (number == '-') {
                isNeg = true;
            } else {
                Integer addDigit = Character.getNumericValue(number);
                myNums.add(addDigit);
            }
            length++;
            //Each digit is stored as a separate entry to the array
            //Sample myLong: [1, 2] where 1 and 2 are type Integer
        }

        deleteExcessZeros();
    }

    public ArrayList<Integer> getLong() {
        //Returns numbers as an array
        return myNums;
    }

    public void deleteExcessZeros(){
        //Need to get rid of excess zeros at beginning, as they can skew computations.
        //This will alter myNums

        ArrayList<Integer> myNumsClone = (ArrayList<Integer>)myNums.clone();
        for (int i = 0; i < myNumsClone.size(); i++) {
            Integer element = myNumsClone.get(i);
            if (element != 0){
                break;
            }
            else {
                myNums.remove(0);
            }
        }
    }

    public myLong add(myLong other) {

        /*
        Parameter: a myLong that will be added to the myLong that passes it
        Returns: myLong
        This function will add the two myLongs together.

        NOTE: The myLong that passes the function will remain unaltered.
         */
        String result = "";
        int otherSize = other.myNums.size();
        int thisSize = this.myNums.size();
        myLong sum = new myLong();

        //Use clone so that myNums does not actually change.
        //ArrayList<Integer> myNumsClone = (ArrayList<Integer>)myNums.clone();

        //Makes both myLongs to be equal in size, padding with zeros at the front
        while (otherSize != thisSize) {
            if (otherSize > thisSize) {
                myNums.add(0, 0);
            }
            if (otherSize < thisSize) {
                other.myNums.add(0, 0);
            }

            thisSize = myNums.size();
            otherSize = other.myNums.size();
        }


        //for (int n = 0; n < thisSize; n++){
            //sum.myNums.add(0);
        //}

        //Make sure not adding empty array
        if (other.myNums.size() > 0) {

            for (int i = otherSize - 1; i >= 0; i--) {
                //Get last element of myLong being added
                Integer otherlastNum = other.myNums.get(i);
                Integer lastNum = myNums.get(i);
                lastNum += otherlastNum;
                myNums.set(i, lastNum);

            }


            for (int j = myNums.size() - 1; j >= 0; j--) {
                int each = myNums.get(j);
                if (each >= 10) {
                    if (j != 0) {
                        Integer secondtoLast = myNums.get(j - 1);
                        secondtoLast += 1;
                        myNums.set(j - 1, secondtoLast);
                        each = each % 10;
                    }

                    if (j == 0) {
                        myNums.set(0, 1);
                    }
                }
                result = each + result; //Adds to beginning of string
            }

        }

        setLong(result);
        return this;
    }



    boolean addNeg = false;
    public myLong[] otherIsLarger(myLong other) {
    /*Determines which myLong has larger value, so we know which to pass into the useSubtract method.
    Returns an array of 2 myLongs. The first element of the array will be whichever is larger, and the
    second will be whichever is smaller
    */
        int otherSize = other.myNums.size();
        int thisSize = this.myNums.size();

        // Check to see which of the two numbers is larger
        myLong larger = new myLong();
        myLong smaller = new myLong();
        if (otherSize > thisSize) {
            larger = other;
            smaller = this;
            addNeg = true;
        } else if (thisSize > otherSize) {
            larger = this;
            smaller = other;
        } else {
            //If size is equal, check each element until one is larger
            for (int k = 0; k < this.myNums.size(); k++) {
                if (this.myNums.get(k) != other.myNums.get(k)) {
                    if (this.myNums.get(k) > other.myNums.get(k)) {
                        larger = this;
                        smaller = other;
                    } else {
                        larger = other;
                        smaller = this;
                        addNeg = true;
                    }
                    break;
                } else {
                    larger = this;
                    smaller = other;
                    continue;
                }

            }

        }
        //Return array of two myLongs, so they can be passed through subtract function
        myLong[] ar = new myLong[2];
        ar[0] = larger;
        ar[1] = smaller;
        return ar;
    }

    public String useSubtract(myLong small){
    /*
    This function returns a string that we will then pass through our setLong operation
    in the subtract method.
     */
        String result = "";
        myLong larger = this;
        myLong smaller = small;
        int largeSize = larger.myNums.size();



        //Makes both myLongs to be equal in size, padding with zeros at the front
        while (smaller.myNums.size() != larger.myNums.size()){
            smaller.myNums.add(0,0);
        }

        //System.out.println(larger.myNums);
        //System.out.println(smaller.myNums);

        //Iterate through, sizes should be equal
        for (int i = largeSize - 1; i >= 0; i--) {
            //Get last element of myLong being added
            Integer smallerLastNum = smaller.myNums.get(i);
            Integer largerLastNum = larger.myNums.get(i);

            if (largerLastNum >= smallerLastNum) {
                largerLastNum -= smallerLastNum;
            }

            else if (largerLastNum < smallerLastNum) {
                if (i == 0) {
                    largerLastNum -= smallerLastNum;
                }
                else {
                    //Get element from next index to borrow from
                    Integer borrowFrom = larger.myNums.get(i - 1);
                    borrowFrom--;
                    //Decrement element borrowed from
                    larger.myNums.set(i - 1, borrowFrom);
                    //Add 10 to element that needs to borrow it
                    largerLastNum += 10;
                    largerLastNum -= smallerLastNum;

                }
            }
           //System.out.println(largerLastNum);
            result = largerLastNum + result;

        }

        return result;

    }

    public myLong subtract(myLong other) {
        /*
        This function will call 2 other functions.
        First, it will determine which function is larger. If myLong other is larger, we will also know
        to add a negative marker.
        Then, it will use the larger myLong to call subtraction from the smaller myLong.

        NOTE: the myLongs passed will be manipulated and will not hold the same value after the subtraction
        occurs. You will need to use setLong again if you wish to reuse any variables.
        */
        myLong answer = new myLong();
        String result = "";


        //If elements are equal, return 0
        if (other.myNums == this.myNums) {
            answer.setLong("0");
            return answer;
        }

        //If not, set the larger myLong by using the otherIsLarger function.

        myLong [] twoElements = otherIsLarger(other);
        //System.out.println(addNeg);

        //Now, subtract larger from smaller
        myLong larger = twoElements[0];
        myLong smaller = twoElements[1];

        result = larger.useSubtract(smaller);


        //Now, we'll add a negative if needed

        if (addNeg) {
            result = "-" + result;
        }

        //System.out.println(larger.myNums);

        answer.setLong(result);
        return answer;
    }

    public myLong multiply(myLong other){
        /*
        This function takes in two myLongs and multiplies them by each other.
        The return value is a new myLong.
         */

        myLong product = new myLong();
        product.setLong("0");

        //Do addition other times
        for (Integer each: other.myNums){
            //Create my long that we will add to the product each time, reset at each for loop
            myLong toAdd = new myLong();
            toAdd.setLong("0");

            //Determines how many zeros need to be accounted for as place holders
            int zerosNeeded = other.myNums.size() - 1 - other.myNums.indexOf(each);

            while (each > 0){
                toAdd.add(this);
                each --;
            }

            while (zerosNeeded > 0) {
                toAdd.myNums.add(0);
                zerosNeeded--;
            }

            product.add(toAdd);
        }


        return product;
    }

    public static void main(String args[]) {

        //Test subtraction
        myLong test = new myLong();
        test.setLong("5000");

        myLong subTest = new myLong();
        subTest.setLong("11256");

        System.out.print(test + " - " + subTest + " = " );
        myLong result = test.subtract(subTest);
        System.out.println(result);


        myLong addTest = new myLong();
        addTest.setLong("5678");
        test.setLong("45678");

        System.out.print(test + " + " + addTest + " = " );
        myLong result2 = test.add(addTest);
        System.out.println(result2);


        myLong first = new myLong();
        first.setLong("123456789");
        myLong second = new myLong();
        second.setLong("987654321");
        System.out.print(first + " x " + second + " = " );
        myLong result3 = first.multiply(second);
        System.out.println(result3);




    }





}

