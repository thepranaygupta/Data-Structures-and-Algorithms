/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    nums = nums.sort((a,b) => a - b);

    const result = new Set();

    for(let i = 0; i < nums.length; i++) {
        for(let j = i + 1; j < nums.length; j++) {
            const remainingTarget = target - nums[i] - nums[j];
            find4Sum(j+1, [i,j] ,nums, remainingTarget, result);
        }
    }

    const uniquePair = [];
    for(element of result.values()) {
        uniquePair.push(element.split(','));
    }

    return uniquePair;
};

var find4Sum = function(left, indecis, nums, target, result) {
    const [i,j] = indecis;
    let right = nums.length - 1;

    while(left < right) {
        if(target < nums[left] + nums[right]) {
            right--;
        } else if(target > nums[left] + nums[right]) {
            left++;
        } else {
             const quad = [nums[i], nums[j], nums[left], nums[right]].join(',');
             result.add(quad);
             left++;
        }
    }

    return false;
}
