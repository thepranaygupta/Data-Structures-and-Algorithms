/**
 * @param {number[]} nums
 * @return {number}
 */
    
    
var rob = function(nums) {
    
    if(nums.length === 1) return nums[0];
    
    let includeFirst = preRob(nums.slice(1));
    let notIncludeFirst = preRob(nums.slice(0, nums.length - 1));
    return Math.max(includeFirst, notIncludeFirst);
    
};

var preRob = function(nums) {
    
    let rob1 = 0;
    let rob2 = 0;
    
    let temp = 0;
    for(let i = 0; i < nums.length; i++) {
        temp = Math.max(rob1 + nums[i], rob2);
        rob1 = rob2;
        rob2 = temp;
    }
    
    
    return rob2;
}
