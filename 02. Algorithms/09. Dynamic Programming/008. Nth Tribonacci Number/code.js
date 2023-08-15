/**
 * Recursion | DP
 * https://leetcode.com/problems/n-th-tribonacci-number
 * 
 * Time O(n) | Space O(n)
 * @param {number} n
 * @return {number}
 */
var tribonacci = function(n) {

    const cache = new Map();
    if(n === 1 || n === 2) return 1;
    if(n === 0) return 0;
    const dfs = (n) => {
      
      if(cache.has(n)) return cache.get(n);
      if(n === 2 || n === 1) return 1;
      if(n === 0) return 0;
      
      const result = dfs(n-3) + dfs(n-2) + dfs(n-1);
      cache.set(n, result);
      return result;     
    }

    return dfs(n);
};
