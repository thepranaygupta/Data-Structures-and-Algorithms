/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * linear iteration
 * Time O(n) | Space O(n)
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    const nums1Set = new Set(nums1);
    const result = new Set();

    for(let i = 0; i < nums2.length; i++) {
        if(nums1Set.has(nums2[i])) result.add(nums2[i]);
    }

    return [...result];
};  
