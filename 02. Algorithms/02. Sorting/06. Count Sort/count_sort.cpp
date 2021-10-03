
// Counting sort in C++ 

#include <bits/stdc++.h>
using namespace std;

int getMax(int arr[], int size) {
   int max = arr[1];
   for(int i = 2; i<=size; i++) {
      if(arr[i] > max)
         max = arr[i];
   }
   return max; //the max element from the array
}

void countSort(int arr[], int size) {
  // The size of count must be at least the (max+1) 
  int output[size+1];
  int mx=getMax(arr,size);
  int count[mx];

  // Initialize count array with all zeros.
  for (int i = 0; i <= mx; ++i) {
    count[i] = 0;
  }

  // Store the count of each element
  for (int i = 0; i < size; i++) {
    count[arr[i]]++;
  }

  // Store the cummulative count of each array
  for (int i = 1; i <= mx; i++) {
    count[i] += count[i - 1];
  }

  // Find the index of each element of the original array in count array, and
  // place the elements in output array
  for (int i = size - 1; i >= 0; i--) {
    output[count[arr[i]] - 1] = arr[i];
    count[arr[i]]--;
  }

  // Copy the sorted elements into original array
  for (int i = 0; i < size; i++) {
    arr[i] = output[i];
  }
}

// Function to print an array
void printArray(int arr[], int size) {
  for (int i = 0; i < size; i++)
    cout << arr[i] << " ";
  cout << endl;
}


int main() {
  int n;
  cin>>n;
  int arr[n];
  for(int i=0;i<n;i++) cin>>arr[i];
  countSort(arr, n);
  printArray(arr, n);
}