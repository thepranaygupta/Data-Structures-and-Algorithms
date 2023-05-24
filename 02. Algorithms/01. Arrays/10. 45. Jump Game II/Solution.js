/**
 * @param {number[]} nums
 * @return {number}
 */

var jump = function(nums) {

    let left = 0;
    let right = 0;
    let result = 0;

    while(right < nums.length - 1) {
        let longest = 0;
        for(let i = left; i < right + 1; i++) {
            longest = Math.max(longest, nums[i] + i);
        }
        left = right + 1;
        right = longest;
        result++;
    }
    return result;
};















