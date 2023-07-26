/**
 * 
 * DP
 * https://leetcode.com/problems/ugly-number-ii/
 * 
 * Time O(n) | Space O(n)   
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    const uglyArr = [1];
    
    let twoPointer = 0;
    let threePointer = 0;
    let fivePointer = 0;
    
    for(let i = 1; i < n; i++) {
        uglyArr.push(Math.min(uglyArr[twoPointer]*2, uglyArr[threePointer]*3, uglyArr[fivePointer]*5));
        if(uglyArr[i] === uglyArr[twoPointer]*2) twoPointer++;
        if(uglyArr[i] === uglyArr[threePointer]*3) threePointer++;
        if(uglyArr[i] === uglyArr[fivePointer]*5) fivePointer++;
    }
    return uglyArr[n - 1];
    };
