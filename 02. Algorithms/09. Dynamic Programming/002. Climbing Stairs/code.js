/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    
    function goRecursive(steps, memo) {

        if(memo[steps]) return memo[steps];
        if(steps === 0) return 1;
        if(steps < 0) return 0;

        memo[steps] = goRecursive(steps - 1, memo) + goRecursive(steps - 2, memo);
        return memo[steps];
    }

    return goRecursive(n,{});
};
