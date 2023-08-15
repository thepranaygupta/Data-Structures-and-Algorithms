/**
 * Recursion
 * Time O(n) | Space O(n)
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    
    const memo = {
        [cost.length - 1]: cost[cost.length - 1]
    };
    function dfs(index) {
        if(memo[index]) return memo[index];
        if(index >= cost.length) return 0;
        const choice1 = dfs(index+1);
        const choice2 = dfs(index+2);
        memo[index] = cost[index] + Math.min(choice1, choice2);
        return memo[index];
    }
    // console.log(memo);
    // console.log(memo);
    return Math.min(dfs(0), dfs(1));
    // return dfs(0);
};
