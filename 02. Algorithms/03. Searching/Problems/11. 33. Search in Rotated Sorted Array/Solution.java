// https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            int num = arr[mid];
            // if arr[mid] and target are "on the same side" of arr[0], we just take arr[mid].
            if ((arr[mid] < arr[0]) == (target < arr[0])) {
                num = arr[mid];
            } else {
                num = target < arr[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
    
            if (num < target)
                start = mid + 1;
            else if (num > target)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
