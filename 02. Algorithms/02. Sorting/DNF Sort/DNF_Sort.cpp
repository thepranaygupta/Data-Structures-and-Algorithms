#include <bits/stdc++.h>
using namespace std;
// Function to sort the input array where the array is assumed to have values in {0, 1, 2}
void DNF(int arr[], int arr_size)
{
    int low = 0;
    int high = arr_size - 1;
    int mid = 0;
    // We have keep iterating till all the elements are sorted
    while (mid <= high)
    {
        switch (arr[mid])
        {
        // Here mid is 0.
        case 0:
            swap(arr[low++], arr[mid++]);
            break;
        // Here mid is 1.
        case 1:
            mid++;
            break;
        // Here mid is 2.
        case 2:
            swap(arr[mid], arr[high--]);
            break;
        }
    }
}
// Now, we write the function to print array arr[]
void printArray(int arr[], int arr_size)
{
    // To iterate and print every element, we follow these steps
    for (int i = 0; i < arr_size; i++)
        cout << arr[i] << " ";
}
//Main Code
int main()
{
    // int arr[] = {0, 1, 0, 1, 2, 0, 1, 2};
    // int n = sizeof(arr) / sizeof(arr[0]);
    int n;
    cout<<"Enter the size of array:"<<endl;
    cin>>n;
    int arr[n];
    cout<<"Enter the element of array:"<<endl;
    for (int i = 0; i < n; i++)
    {
        cin>>arr[i];
    }
    cout << "Array before executing the algorithm: ";
    printArray(arr, n);
    DNF(arr, n);
    cout << "\nArray after executing the DNFS algorithm: ";
    printArray(arr, n);
    return 0;
}