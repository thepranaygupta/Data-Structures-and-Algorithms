## 162. Find Peak Element

## https://leetcode.com/problems/find-peak-element/

## Same as: [852. Peak Index in a Mountain Array](../08.%20852.%20Peak%20Index%20in%20a%20Mountain%20Array/)

``` java
class Solution {
    public int findPeakElement(int[] arr) {
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
