/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
   nums.sort((a, b) => {
        return a - b;
    });

    const result = [];
    for(let i = 0; i < nums.length - 2; i++) {

        // this condition is pretry important it keeps the duplicate out of our result array.
        if(nums[i] !== nums[i - 1]) {

            let low = i + 1;
            let heigh = nums.length - 1;

            while(low < heigh) {

                if(nums[low] + nums[heigh] + nums[i] === 0) {

                    result.push([nums[i],nums[low],nums[heigh]]);
                    
                    // below while loop is pretty important it keeps the duplicate out of our result array.
                    while(nums[low] === nums[low+1]) low++;
                    low++;
                } else if(nums[low] + nums[heigh] + nums[i] > 0) {
                    heigh--;
                } else {
                    low++;
                }
            }
        }
    }

    return result;
};
