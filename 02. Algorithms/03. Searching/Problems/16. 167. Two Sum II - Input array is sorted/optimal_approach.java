// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while(i<=j) {
            if(arr[i] + arr[j] > target)
                j--; // need to decrease the sum
            else if(arr[i] + arr[j] < target)
                i++; // need to increase the sum
            else
                break;
        }
        return new int[]{i + 1, j + 1};
    }
}
