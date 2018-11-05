#include <stdio.h>

int guessCount = 0;
int myGuess;

int ask_in_range(int min,int max){

    while (myGuess < min || myGuess > max){
        printf("Your number is out of [%d,%d] range.  ", min, max);

        printf("Please enter a number: ");
        scanf("%d",&myGuess);


    }

    return myGuess;
}

int guessing_game(int num, int rangemin, int rangemax){

    printf("Hello and welcome to the game.\n");
    printf("You need to enter a number between %d and %d.\n", rangemin, rangemax);

    printf("Please enter a number: ");
    scanf("%d",&myGuess);

    while (myGuess != num){
        myGuess = ask_in_range(rangemin, rangemax);

        if (myGuess > num){
            printf("Too high!\n");
        }
        if (myGuess < num){
            printf("Too low!\n");
        }

        guessCount += 1;

        printf("Please enter a number: ");
        scanf("%d", &myGuess);

    }

    guessCount += 1;
    printf("Good job! You took %d guesses.", guessCount);

    return 0;
}
int main() {
    int myMin = -100;
    int myMax = 100;
    int myNum = 12;


    guessing_game(myNum, myMin, myMax);

}