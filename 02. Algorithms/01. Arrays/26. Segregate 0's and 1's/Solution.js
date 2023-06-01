/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
/**
 * Linear Time
 * Time Complexity  O(N) | Space Complexity O(N);
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {

    const arr = new Array(nums.length).fill(0);

let [ left, right ] = [ 0, 0 ];

while (right < nums.length) {
	const isZero = (nums[right] === 0);
	if (!isZero) {
		arr[left] = nums[right];
		left++;
	}

	right++;
}
console.log(arr);
return arr;
};
