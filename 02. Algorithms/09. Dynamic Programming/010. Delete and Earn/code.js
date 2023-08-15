/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    const hash = new Map();
    
    nums.forEach((num) => {
        const numCache = hash.get(num);
        if(numCache) {
            hash.set(num, numCache + 1);
        } else {
            hash.set(num, 1);
        }
    });
    
    const uniqueNums = new Set();
    
    nums.forEach((num) => {
        uniqueNums.add(num);
    });
    
    nums = [...uniqueNums];
    
    nums.sort((a,b) => {
        return a-b;
    });
    
    let earn1 = 0;
    let earn2 = 0;
    
    for(let i = 0; i < nums.length; i++) {
        const currentEarn = nums[i] * hash.get(nums[i]);
    
        if(nums[i] === nums[i-1] + 1) {
            const temp = earn2;
            earn2 = Math.max(earn2, currentEarn + earn1);
            earn1 = temp;
        } else {
            const temp = earn2;
            earn2 = currentEarn + earn2;
            earn1 = temp;
        }
    }
    
    return earn2;
    
};
