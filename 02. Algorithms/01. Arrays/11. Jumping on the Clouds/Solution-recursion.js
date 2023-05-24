function jumpingOnClouds(c) {
    const cache = {};
    const dfs = (index) => {
        if(cache[index]) return cache[index];
        if(c[index] === 1) return Infinity;
        if(index === c.length) return 0;
        if(index >= c.length) return -1;
        
        cache[index] = Math.min(dfs(index+1) + 1, dfs(index+2) + 1);
        return cache[index];
    }
    const res = dfs(0);
    // console.log(cache);
    return res;
}
