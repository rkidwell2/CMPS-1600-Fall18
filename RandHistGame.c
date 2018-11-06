#include <stdio.h>
#include <time.h>
#include <stdlib.h>

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

int get_random(int min, int max){

    srand(time(NULL));
    int r = (rand()%(max-min+1))+min;
    return r;

}
int guessing_game(int num, int rangemin, int rangemax){

    printf("Hello and welcome to the game.\n");
    printf("What is your name? ");

    char name[30];
    scanf("%[^\n]%*c", name);


    printf("\nYou need to enter a number between %d and %d.\n", rangemin, rangemax);

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
    printf("Good job! You took %d guesses.\n", guessCount);

    FILE *fptr;
    char filename[15] = "history.txt";
    char c;

    fptr = fopen(filename, "r");
    if (fptr == NULL){
        printf ("Cannot open file.");
    }

    c = fgetc(fptr);
    printf("Previous score: \n");
    while (c!= EOF) {
        printf("%c", c);
        c = fgetc(fptr);
    }

    fclose(fptr);

    fptr = fopen(filename, "w");
    fprintf(fptr, "%s: %d guesses", name, guessCount);

    fclose(fptr);

    return 0;
}
int main() {
    int myMin = 0;
    int myMax = 10;
    int myNum = get_random(myMin, myMax);


    guessing_game(myNum, myMin, myMax);

}