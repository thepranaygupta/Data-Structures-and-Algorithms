#include <stdio.h>


void bubbleSort(int array[], int size) {
  for (int step = 0; step < size - 1; ++step) { 
    int swapped = 0;
    for (int i = 0; i < size - step - 1; ++i) {
      if (array[i] > array[i + 1]) {
        int temp = array[i];
        array[i] = array[i + 1];
        array[i + 1] = temp;
        swapped = 1;
      }
    }   
    if (swapped == 0) {
      break;
    }
  }
}


void printArray(int array[], int size) {
  for (int i = 0; i < size; ++i) {
    printf("%d  ", array[i]);
  }
  printf("\n");
}


int main() {
    int n = 0;
    printf("Enter the size of array : ");
    scanf("%d", &n);
    int data[n];
    int num = 0;
    printf("Enter elements : ");
    for(int i = 0; i < n; i++){
        scanf("%d", &num);
        data[i] = num;
    }
  int size = sizeof(data) / sizeof(data[0]);

  bubbleSort(data, size);
  printf("Sorted Array in Ascending Order:\n");
  printArray(data, size);
}