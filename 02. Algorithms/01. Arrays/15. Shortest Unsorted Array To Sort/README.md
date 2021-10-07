# An Array Searching Algo

## Finding the shortest subarray that can be sorted to sort the entire array
## https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/)

Algorithm:
Let there be an array- 10 12 14 11 16 40 20 39 13 19

Initially, we tranverse through the array to find the first instance of break in ascending order from left to right (in this case, it is the 2nd index, 14) and in descending order from right to left (6th index, 13). 

Then, we traverse this subarray, and find the min and max elements (min = 11, max = 40).

For min, the sub-array that lies before its index (10, 12 ,14) is traversed until the 1st number smaller than it is found or till we reach the end of the array, i.e,

    for(int i = min-1; i>=0; i--)
       if(a[min]>a[i])
       {
          min = i;
          break;
       }   
Then, min is updated to min+1, since sorting will be carried out from the next index.
Similarly, for max index, the subarray succeeding the max index is searched till an element > a[max] is found or till we reach the end of the array. Then that index is updated to max - 1.

After following these steps, we will have found the shortest subarray to be sorted. 
