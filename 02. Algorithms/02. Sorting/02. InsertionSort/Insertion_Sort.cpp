#include <iostream>

using namespace std;

int printArray(int array[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        cout<< array[i] << " ";
    }
    cout << "\n\n";

    return 0;
}

int main(){
    int arr[] = {7,98,79,-2,8,98,7,-7,4,54,87,8,45,9};


    int n = ((sizeof arr) /( sizeof arr[0]));

    cout << "before sorting: \n";
    printArray(arr, n);

    for (int i = 1; i < n-1; i++)
    {
        while (arr[i] < arr[i-1] && i-1 >= 0)
        {
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
            i--;
        }
        
    }

    cout << "after sorting: \n";
    
    printArray(arr, n);
}