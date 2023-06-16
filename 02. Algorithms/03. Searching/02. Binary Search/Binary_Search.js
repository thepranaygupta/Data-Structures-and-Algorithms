var search = function(nums, target) {
    
    let left = 0;
    let right = nums.length - 1;

    while(left <= right) {
        const mid = Math.floor((right - left)/2) + left;
        if(nums[mid] === target) return mid;
        if(nums[mid] < target){
            left = mid+1;
        } else {
            right = mid-1;
        }   
    }
    return -1;
};
