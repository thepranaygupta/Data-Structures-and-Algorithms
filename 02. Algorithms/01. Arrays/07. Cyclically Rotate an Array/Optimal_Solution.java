// https://leetcode.com/problems/rotate-array/
class Solution {
    public void rotate(int[] arr, int k) {
        int len = arr.length;
        k = k % len;
        // reverse part1
        reverse(arr, 0, len - k - 1);
        
        // reverse part2
        reverse(arr, len - k, len - 1);
        
        // reverse the whole array
        reverse(arr, 0, len-1);
    }
    
    public void reverse(int[] arr, int li, int ri) {
        while(li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }
}
