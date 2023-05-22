
// Time O(n) | Space O(1) 
const moveNegativeAtFront = (nums) => {

    const swap = (a,b) => {
        const temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    let right = nums.length - 1;
    for(let i = 0; i < nums.length; i++) {
        let current = i;
        while(nums[current] > 0 && current < right) {
            swap(current, right);
            right--;
        }
    }

    return nums;
}

const nums = [-12, 11, -13, -5, 6, -7, 5, -3, -6];
console.log(movePN(nums));
