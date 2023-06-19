/**
 * Binary Search
 * https://leetcode.com/problems/search-in-rotated-sorted-array
 * 
 * Time O(log(n)) | Space O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0;
     let right =  nums.length - 1;
 
     // find the smallest element
     while(left < right) {
 
         const mid = Math.floor((right + left) / 2);
 
         if(nums[mid] > nums[right]) {
             left = mid + 1;
         } else {
             right = mid;
         }
     }
 
     // finding the part in which we'll be performing binary search
     if(target > nums[nums.length - 1]) {
         left = 0;
         right = right  - 1;
     } else {
         right = nums.length - 1;
     }
 
     // doing the binary search on the proper portion of the array.
     while(left <= right) {
         const mid = Math.floor((left + right) /2);
         if(target === nums[mid]) {
             return mid;
         } else if(target > nums[mid])  {
             left = mid + 1;
         } else {
             right = mid - 1;
         }
     }
 
     return -1;
 };
 
