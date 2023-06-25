/**
 * Binary Search
 * Definition for isBadVersion()
 * https://leetcode.com/problems/first-bad-version/
 * 
 * Time O(log(n)) | Space O(1)
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function(isBadVersion) {
    /**
     * @param {integer} n Total versions
     * @return {integer} The first bad version
     */
    return function(n) {
        let left = 1;
        let right = n;

        let firstBad = 0;
        while(left <= right) {
            const mid = left + Math.floor((right-left)/2);
            const isBad = isBadVersion(mid);
            if(isBad) {
                firstBad = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstBad;
    };
};
