/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {

let maxCurrent = 1;
let minCurrent = 1;
let Max = nums[0];

for(let i = 0; i < nums.length; i++) {
    const temp = nums[i] * maxCurrent;

    maxCurrent = Math.max(temp, nums[i] * minCurrent, nums[i]);
    minCurrent = Math.min(temp, minCurrent * nums[i], nums[i]);

    Max = Math.max(Max, maxCurrent);
}

return Max;
};

