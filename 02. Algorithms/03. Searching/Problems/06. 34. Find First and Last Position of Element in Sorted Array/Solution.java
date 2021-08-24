// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = { -1, -1 };
        int start = 0;
        int end = nums.length - 1;
        
        // finding the first occurence
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans[0] = mid;
                end = mid - 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        start = 0;
        end = nums.length - 1;
        // finding the last occurence
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                ans[1] = mid;
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
