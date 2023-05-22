/**
 * Time O(n) | Space O(1)
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    
    let total = Number.NEGATIVE_INFINITY;
    let currunt = 0;
        for(let i = 0; i < nums.length; i++) {
            currunt = Math.max(nums[i], currunt + nums[i]);
            total = Math.max(currunt, total);
        }
        
        return total;
};
