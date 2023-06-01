/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    
let DpArra = new Array(nums.length).fill(1);

for(let i = nums.length - 1; i > -1; i--) {
    for(let j = i + 1; j < nums.length; j++) {
        if(nums[i] < nums[j]) {
            DpArra[i] = Math.max(DpArra[i], 1 + DpArra[j]);
        }
    }
}

return Math.max(...DpArra);
};
