## Find the Rotation Count in Rotated Sorted array

## https://practice.geeksforgeeks.org/problems/rotation4723/1#

## [Editorial Link](https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/)

### Approach 1: Linear Search

```java
// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int min = arr[0];
        int minindex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
                minindex = i;
            }
        }
        return minindex;
    }
}
```

### Approach 2: Binary Search

We find the index of minimum element using Binary Search. The idea is based on the below facts : 
 
- The minimum element is the only element whose previous is greater than it. If there is no previous element, then there is no rotation (first element is minimum). We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.
- If the minimum element is not at the middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
    1. If middle element is smaller than last element, then the minimum element lies in left half
    2. Else minimum element lies in right half.

```java
// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int start = 0, end = n - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(start == end)
                return start;
            if(mid < end && arr[mid+1] < arr[mid])
                return (mid+1);
            if(mid > start && arr[mid] < arr[mid-1])
                return mid;
            // if middle element is smaller than last element, then the minimum element lies in left half
            if(arr[end] > arr[mid])
                end = mid - 1;
            // else minimum element lies in right half
            else
                start = mid + 1;
        }
        return 0;
    }
}
```
