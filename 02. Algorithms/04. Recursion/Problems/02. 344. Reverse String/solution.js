/**
 * https://leetcode.com/problems/reverse-string/
 * Time O(n) | Space O(n)
 * @param {character[]} s
 * @return {void} Do not return anything, modify s in-place instead.
 */
var reverseString = function(s) {

    const dfs = (left, right) => {
        if(left >=  right) return;
        swap(s, left, right);
        dfs(left+1, right-1);
    }

    dfs(0, s.length - 1);
};

 function swap(s,left,right) {
     const temp = s[left];
     s[left] = s[right];
     s[right] = temp;
 }
