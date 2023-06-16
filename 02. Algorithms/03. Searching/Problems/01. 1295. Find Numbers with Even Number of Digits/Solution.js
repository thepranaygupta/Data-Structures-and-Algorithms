/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits
 * Time O(n) | Space O(n)
 * @param {number[]} nums
 * @return {number}
 */
var findNumbers = function(nums) {
    
    nums = nums.filter((num) => num.toString().length % 2 === 0);
    return nums.length;
};
