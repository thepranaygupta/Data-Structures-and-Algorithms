/**
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function(nums) {

    const copyArr = [...nums].sort((a,b) => {
        return a - b
    });

    let start = 0;
    let end = nums.length;
    let i = 0;
    while(i < nums.length) {
        if(nums[i] !== copyArr[i]) {
            start = i;
            break;
        }
        i++;
    }
    i = end;
    while(i > -1) {
        if(nums[i] !== copyArr[i]) {
            end = i;
            break;
        }
        i--;
    }

    if(start === 0 && end === nums.length) return 0;
    return end - start + 1;
};
