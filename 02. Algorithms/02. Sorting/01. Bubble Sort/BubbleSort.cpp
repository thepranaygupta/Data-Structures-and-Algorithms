#include <iostream>

using namespace std;

int swap(int *x, int *y)
{
    int temp = *x;
    *x = *y;
    *y = temp;

    return 0;
}

int sort(int array[], int n)
{
    int flag = 0, loop = 0;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = 0; j < n - i - 2; j++)
        {
            if (array[j] > array[j + 1])
            {
                swap(&array[j], &array[j + 1]);
                flag++;
            }
        }
        loop++;
    }
    cout<< "\n swping done for" << flag << "|| loop ran for" << loop << "\n\n";

    return 0;
}

int printArray(int array[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        cout<< array[i] << " ";
    }
    cout << "\n\n";

    return 0;
}

int main()
{
    int array[] = {7, 4, 19, 87, 45, 90, 189, 78, -2, 334, 84, 51, 0, 251, 5, 211, 133, 9, 17, 0, 112, 11, 478, 7, 45, -18, 252, 38, 84, -25, 27, 5, 8, 42, 5};
    int n = sizeof(array) / sizeof(array[0]);
    cout << "\n before sorting: \n";
    printArray(array, n);
    int res = sort(array, n);
    cout << "sorted array is: \n";
    printArray(array, n);
}