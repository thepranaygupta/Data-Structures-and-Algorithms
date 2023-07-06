var climbStairs = function(n) {
    const computed = {};
    function goRecursive(ways) {
        // base cases.
        if(ways === 1) return 1;
        if(ways === 2) return 2;
        if(ways < 0) return 0;        

        if(!computed[ways]) {
            computed[ways] = goRecursive(ways-1) + goRecursive(ways-2);
        }

        return computed[ways];
    }
    
    return goRecursive(n);
};
