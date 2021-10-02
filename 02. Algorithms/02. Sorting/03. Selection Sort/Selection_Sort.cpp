#include <iostream>

using namespace std;

int printArray(int array[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        cout <<  array[i] << " ";
    }

    return 0;
}

int main()
{
    int arr[] = {7, 98, 79, -2, 8, 98, 7, -7, 4, 54, 87, 8, 45, 9};

    int n = ((sizeof arr) / (sizeof arr[0]));

    cout << "before sorting: \n";
    printArray(arr, n);


    for (int i = 0; i < n - 1; i++)
    {
        int min = i;

        // search for the smallest element
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] < arr[min])
                min = j;
        }

        // swap the smallest element with the element at i
        if (min != i)
        {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    cout << "\n\nafter sorting: \n";
    printArray(arr, n);
    cout << "\n\n";
}