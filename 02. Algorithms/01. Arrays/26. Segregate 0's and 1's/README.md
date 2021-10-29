# Segregate 0's and 1's in an Array

## Problem Statement:
You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array [Basically you have to sort the array].

## Algorithm:
1. Here we will be using 2 indices and initilize the first index `left` as `0` and the last index `right` as `array.length-1`
2. Run a While left < right loop
3. Keep incrementing index left while there are 0s at it 
4. Keep decrementing index right while there are 1s at it 
5. If left < right then exchange arr[left] and arr[right]

![Array - 53_ Segregate 0s   1s in given Array](https://user-images.githubusercontent.com/73117995/136591484-807c7ad5-d2f0-45a6-8a35-596519f30e33.png)


## Code in Java
```java
    void segregate(int arr[], int size)
    
    {
        /* Initialize left and right*/ as 0 and size-1
        int left = 0, right = size - 1;
 
        while (left < right)
        {
            /* Increment left index while we see 0 at left */
            while (arr[left] == 0 && left < right)
               left++;
 
            /* Decrement right index while we see 1 at right */
            while (arr[right] == 1 && left < right)
                right--;
 
            /* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[left] and arr[right]*/
            if (left < right)
            {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
     
    /*main*/
    public static void main(String[] args)
    {
        Segregate obj = new Segregate();
        int arr[] = new int[]{0, 1, 0, 1, 1, 1};
        int i, arr_size = arr.length;
 
        obj.segregate(arr, arr_size);
 
        System.out.print("Array after segregation is ");
        for (i = 0; i < 6; i++)
            System.out.print(arr[i] + " ");
    }
}
```
## Complexity Analysis

Time Complexity: O(n), where n is elements of array

Space Complexity: O(1)

## Miscelleneous

Problem Statement: https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/

Reference Video: https://youtu.be/HwDiGWwp11k
