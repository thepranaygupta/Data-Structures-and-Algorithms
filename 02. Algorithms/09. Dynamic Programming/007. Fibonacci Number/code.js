/**
 * @param {number} n
 * @return {number}
 */
var fib = function(n) {
    
    const hash = {};
    const dfs = (n) => {
        if(hash[n]) return hash[n];
        if(n <= 0) {
            return 0;
        }
        if(n === 1) {
            return 1;
        }
        const result =  dfs(n-1) + dfs(n-2);
        hash[n] = result;
        return result;
    }

    return dfs(n);
};
