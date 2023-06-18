/**
 * Binary Search 
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Time O(log(n)) | Space O(1)
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function(letters, target) {
    
    let left = 0;
    let right = letters.length - 1;
    const str = letters.join('');
    let result = letters[0];
    while(left <= right) {
        const mid = left + Math.floor((right - left)/2);
        if(str.charCodeAt(mid) > target.charCodeAt(0)) {
            result = str[mid];
            right = mid - 1;
        }
        if(str.charCodeAt(mid) <= target.charCodeAt(0)) {
            left = mid + 1;
        }
    }

    return result;
};
