// Time O(n) | Space O(n)
const dfsOfGraph = (adj) => {
        
    const printList = [];
    const visited = new Set();
    
    const dfs = (node) => {
        if(visited.has(node)) return;
        visited.add(node);
        for(let i = 0;  i < adj[node].length;  i++) {
            dfs(adj[node][i]);
        }
    }
    
    dfs(0);
    return Array.from(visited);
}

const graph =  [[2,3,1] , [0], [0,4], [0], [2]];
console.log(dfsOfGraph(graph))
