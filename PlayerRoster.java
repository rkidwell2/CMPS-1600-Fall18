import java.util.Scanner;

public class PlayerRoster {
    public static void main(String[] args) {
        int[] jerseyNums = new int[5];
        //int[] jerseyNums = {1, 2, 3, 4, 5};
        //int[] ratings = {6, 7, 8, 4, 2};
        int[] ratings = new int[5];
        Scanner scnr = new Scanner(System.in);

        //Create the roster with user input
        for (int i = 0; i < jerseyNums.length; ++i) {
            System.out.println("" + "Enter player " + (i + 1) + "'s jersey number:");
            jerseyNums[i] = scnr.nextInt();
            System.out.println("" + "Enter player " + (i + 1) + "'s rating:");
            ratings[i] = scnr.nextInt();
            System.out.println();
        }


        //Print the roster
        System.out.println("ROSTER");
        for (int j = 0; j < jerseyNums.length; ++j) {
            System.out.println("Player " + (j + 1) + " -- Jersey number: " + jerseyNums[j] + ", Rating: " + ratings[j]);
        }
        System.out.println();
        char userChar = 'z';
        //Implement a menu of options for the user to modify the roster
        while (userChar != 'q') {
            System.out.println("MENU\nu - Update player rating\na - Output players above a rating\n" +
                    "r - Replace player\no - Output roster\nq - Quit\n");
            System.out.println("Choose an option:");
            userChar = scnr.next().charAt(0);

            //Output roster
            if (userChar == 'o') {
                System.out.println("ROSTER");
                for (int j = 0; j < jerseyNums.length; ++j) {
                    System.out.println("Player " + (j + 1) + " -- Jersey number: " + jerseyNums[j] + ", Rating: " + ratings[j]);

                }
                System.out.println();
            }

            //Change a player's rating
            if (userChar == 'u') {
                System.out.println("Enter a jersey number:");
                int num = scnr.nextInt();
                System.out.println("Enter a new rating for player:");
                int rating = scnr.nextInt();
                for (int r = 0; r < jerseyNums.length; ++r) {
                    if (jerseyNums[r] == num) {
                        ratings[r] = rating;
                    }
                }

            }

            // Output players above a rating
            if (userChar == 'a') {
                System.out.print("Enter a rating:");
                int rating = scnr.nextInt();
                System.out.println("ABOVE " + rating);
                int i = 0;
                for (i = 0; i < jerseyNums.length; ++i) {
                    if (ratings[i] > rating) {
                        System.out.println("Player " + (i + 1) + " -- Jersey number: " + jerseyNums[i] +
                                ", Rating: " + ratings[i]);
                    }
                }
                System.out.println();
            }

            //Replace player
          /*  if (userChar == 'r') {
                System.out.println("Enter a jersey number:");
                int oldnum = scnr.nextInt();
                System.out.println("Enter a new jersey number:");
                int newnum = scnr.nextInt();
                System.out.println("Enter a rating for the new player:");
                int newrat = scnr.nextInt();
                for (int i = 0; i < jerseyNums.length; ++i) {
                    if (jerseyNums[i] == oldnum) {
                        jerseyNums[i] = newnum;
                        ratings[i] = newrat;
                    } else {
                        jerseyNums[i] = jerseyNums[i];
                    }
                }


            } */
            if (userChar == 'r') {
                System.out.println("Enter a jersey number:");
                int oldnum = scnr.nextInt();
                boolean isNum = false;
                for (int j = 0; j < jerseyNums.length; ++j){
                    if (jerseyNums[j] == oldnum){
                        isNum = true;
                    }
                }
                if (isNum == true) {
                    System.out.println("Enter a new jersey number:");
                    int newnum = scnr.nextInt();
                    System.out.println("Enter a rating for the new player:");
                    int newrat = scnr.nextInt();
                    for (int i = 0; i < jerseyNums.length; ++i) {
                        if (jerseyNums[i] == oldnum) {
                            jerseyNums[i] = newnum;
                            ratings[i] = newrat;
                        } else {
                            jerseyNums[i] = jerseyNums[i];
                        }
                    }

                }
            }

        }
    }
}