/**
 * Binary Search
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * Time O(log(n)) | Space O(1)
 * @param {number[]} arr
 * @return {number}
 */
/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function(arr) {


  let left = 0;
  let right = arr.length - 1;

  while(left <= right) {
    const mid = left + Math.floor((right - left)/2);
    
    let preEl = -1;
    let nextEl = -1;
    let currEl = arr[mid];

    // this is to ensure if we go out of bound in any of the direction.
    if(arr[mid - 1] !== undefined) {
      preEl = arr[mid-1];
    }
    if(arr[mid+1] !== undefined) {
      nextEl = arr[mid+1];
    }

    if(currEl > nextEl && currEl > preEl) return mid;

    // we're in increasing half
    if(currEl < nextEl && currEl > preEl) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

};

/**
 * Linear Search
 * Time O(n) | Space O(1)
 * @param {number[]} arr
 * @return {number}
 */
/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray1 = function(arr) {
    
    for(let i = 1; i < arr.length; i++) {
      if(arr[i] < arr[i-1]) return i - 1;
    } 

};

