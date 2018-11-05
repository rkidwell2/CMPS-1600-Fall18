#include <stdio.h>

typedef struct distance_struct{
    double inches;
    int feet;
}distance;

distance addDistance(distance x, distance y){
    distance answer;

    double newInch = x.inches + y.inches;
    if (newInch >=12){
        newInch = newInch - 12;
        answer.feet = 1;
    }
    answer.inches = newInch;
    answer.feet += x.feet + y.feet;

    return answer;
}

int main()
{
    distance first;
    distance second;

    printf("First distance\nEnter feet: ");
    scanf("%d", &first.feet);
    printf("Enter inches: ");
    scanf("%lf", &first.inches);

    printf("\nSecond distance\nEnter feet: ");
    scanf("%d", &second.feet);
    printf("Enter inches: ");
    scanf("%lf", &second.inches);

    distance myAns = addDistance(first, second);
    printf("Sum of distances: %d' %lf\"", myAns.feet, myAns.inches);

    return 0;
}
