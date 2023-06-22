/**
 * Two Pointers
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *  Time O(n) | Space O(1)
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
    let left = 0;
    let right = numbers.length - 1;

    const result = [];
    while(left < right) {
        if(numbers[left] + numbers[right] === target) {
            result.push(left + 1);
            result.push(right + 1);
            break;
        }
        if(numbers[left] + numbers[right] > target) {
            right--;
        } else {
            left++;
        }
    }

    return result;
};
