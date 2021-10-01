# [Trapping Rain Water Problem](https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1)
## Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
### Example:
**Input:**
N = 6

arr[] = {3, 0, 0, 2, 0, 4} 

**Output:**
10

### Solution in C++:
```      
#include <iostream>
using namespace std;

void amt(int arr[], int n)
{
    int sum = 0;
    int lMax[n], rMax[n];

    lMax[0] = arr[0];
    for (int i = 1; i < n; i++)
    {
        lMax[i] = max(arr[i], lMax[i - 1]);
    }

    rMax[n - 1] = arr[n - 1];
    for (int j = n - 2; j >= 0; j--)
    {
        rMax[j] = max(arr[j], rMax[j + 1]);
    }

    for (int k = 1; k < n - 1; k++)
    {
        sum += min(lMax[k], rMax[k]) - arr[k];
    }

    cout << "Trapped rain water is: " << sum << endl;
}
int main()
{
    int n, d;
    cout << "Enter the size of array: ";
    cin >> n;
    int arr[n];
    cout << "Enter the elements of the array: ";
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    amt(arr, n);
    return 0;
}
```
