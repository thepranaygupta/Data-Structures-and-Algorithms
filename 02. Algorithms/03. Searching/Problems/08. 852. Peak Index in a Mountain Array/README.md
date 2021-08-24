## 852. Peak Index in a Mountain Array
## https://leetcode.com/problems/peak-index-in-a-mountain-array/

### [Video Tutorial](https://youtu.be/W9QJ8HaRvJQ?t=7080)

## Approach 1: Using Linear Search <br> TC: O(n)
```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i;
        for(i = 0; i < arr.length; i++) {
            if(arr[i + 1] < arr[i])
                break;
        }
        return i;
    }
}
```

## Approach 2: Using Binary Search <br> TC: O(log n)
``` java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid + 1]) {
                // you're in decreasing part of the array
                // arr[mid] may be the answer, but look at the left of mid
                end = mid;
            } else {
                // you're in ascending part of the array
                // because we know that arr[mid+1] > arr[mid]
                start = mid + 1;
            }
        }
        // in the end start == end point to the peak of the mountain
        return start; // return start or end since both are same
    }
}
```
