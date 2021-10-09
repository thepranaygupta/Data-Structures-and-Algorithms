# Merge Two Sorted Arrays Without Using Extra Space

## Problem Statement:
Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.

Here you can see the insertion sort approach.

## Algorithm:
1. Traverse the first array `a1[]` and compare the ith element to the first element of second array `a2[]`
2. If `a2[0] < a1[i]` is qual to true, then swap `a2[0] and a1[i]`
3. Sort the second array again and put `a2[0]` at its correct position
4. If `a2[0] < a1[i]` is false, continue to next element in `a1[]`

As both the arrays are sorted, the only thing that needs to be done is to put the elements in correct position. This is the same in case of insertion sort. This is done by comparing ith element of array1 `a1[]` with the first element array2 `a2[]` and if the first element of the second array is smaller than the i th element of the first array that means it will also be smaller than all the element on the right side of the i th element in the first array. Therefore, we will swap the first element of the second element with that i th element and resort the second array as after swapping second array will not be sorted anymore and that’s why we need to re-sort the array.   

![merge two sorted arrays](https://user-images.githubusercontent.com/73117995/136376828-b427b7e5-283d-4b20-8706-3a9ac1825ebb.jpeg)

## Code in Java

```java
    public static void mergeArray(int[] arr1, int[] arr2)
    {

        // length of first array
        int n = arr1.length;

        // length of second array
        int m = arr2.length;

        // Now traverse the array1 and if 
        // array2's first element
        // is less than array1 then swap
        for (int i = 0; i < n; i++) {

            if (arr1[i] > arr2[0]) {

                // swap
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

             
                int firstElement = arr2[0];

                int k;
                for (k = 1; 
                     k < m && arr2[k] < firstElement;
                     k++) 
                {
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = firstElement;
            }
        }

        // read the array 1
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        System.out.println();

        // read the array2
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[] arr1 = { 1, 3, 5, 7 };

        int[] arr2 = { 0, 2, 6, 8, 9 };
        mergeArray(arr1, arr2);
    }
```

## Time and Space Complexity

Time Complexity: O(n*m)

Space Complexity: O(1)

## Miscelleneous

Problem Statement: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1

Reference Video: https://youtu.be/NWMcj5QFW74
