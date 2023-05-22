/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 * Time O(n) | Space O(1)
 * @param {number[]} nums
 * @return {number}
 */
var maxSubarraySumCircular = function(nums) {
    
    let currMin  = 0;
    let globleMin = nums[0];
    let currMax   = 0;
    let globleMax = nums[0];

    let total = 0;
    for(let i = 0; i < nums.length; i++) {
        currMin = Math.min(currMin + nums[i], nums[i]);
        globleMin = Math.min(currMin, globleMin);
        currMax = Math.max(currMax + nums[i], nums[i]);
        globleMax = Math.max(currMax, globleMax);
        total += nums[i]; 
    }

    if(globleMax < 0) {
        return globleMax;
    }

    return Math.max(globleMax, total - globleMin);
};
