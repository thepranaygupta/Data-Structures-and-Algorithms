// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// Using linear search

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
