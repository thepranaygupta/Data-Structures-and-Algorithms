#include <stdio.h>
int main (int argc, char *argv[])
{
    int arr[] = {11, 22, 33, 44, 55};
    int ArrLength = sizeof(arr)/sizeof(int);
    int temp;

    printf("Before reversing : [");
    for (int i = 0; i <ArrLength; i++) {
    printf(" %d ",arr[i]);
    }
    printf("]\n");

    // Swapping elements of the array  should stop in the middle
    for (int i = 0; i <ArrLength/2; i++) {
        temp = arr[ArrLength-i-1];
        arr[ArrLength-i-1] = arr[i];
        arr[i] = temp;
    }

    printf("After reversing : [");
    for (int i = 0; i <ArrLength; i++) {
    printf(" %d ",arr[i]);
    }
    printf("]");
    return 0;
}


