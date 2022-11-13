// problem link https://leetcode.com/problems/is-graph-bipartite


var isBipartite = function(graph) {
    const colors = {}

    for (let i = 0; i < graph.length; i++) {
        if (!colors.hasOwnProperty(i) && !dfs(i, true)) return false
    }
    
    return true
    
    function dfs(idx, color) {
        if (colors.hasOwnProperty(idx)) return color === colors[idx]
        colors[idx] = color
        
        for (const i of graph[idx]) {
            if (!dfs(i, !color)) return false
        }
        
        return true
    }
};
