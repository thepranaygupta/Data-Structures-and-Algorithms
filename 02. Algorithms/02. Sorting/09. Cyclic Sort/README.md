
# Cycle Sort

[Video Reference](https://youtu.be/JfinxytTYFQ)

Time Complexity: O(n²)

This sorting algorithm is best suited for situations where memory write or swap operations are costly.

Consider an array of n distinct elements. An element a is given, index of a can be calculated by counting the number of elements that are smaller than a.

If the element is found to be at its correct position, simply leave it as it is.

Otherwise, find the correct position of a by counting the total number of elements that are less than a. where it must be present in the sorted array. The other element b which is replaced is to be moved to its correct position. This process continues until we got an element at the original position of a.
The illustrated process constitutes a cycle. Repeating this cycle for each element of the list. The resulting list will be sorted.
 


![Logo](https://static.javatpoint.com/ds/images/cycle-sort.png)

    
    static void sort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }