/// A hamiltonian path is simply a path that visits all the nodes exectly once.

// Backtracking | Recursion
// Time O(n) | Space O(n)
const makeGraph = (edges) => {

    const graph = {};

    for(let i = 0; i < edges.length; i++) {
        const node0 = edges[i][0];
        const node1 = edges[i][1];
        const node0Neighbor = graph[node0] || [];
        const node1Neighbor = graph[node1] || [];
        node0Neighbor.push(node1);
        node1Neighbor.push(node0);
        graph[node0] = node0Neighbor;
        graph[node1] = node1Neighbor;
    }
    return graph;
}

const hamiltonianPath = (edges, src) => {

    const graph = makeGraph(edges);
    const totalNodes = Object.keys(graph).length;

    const visited = new Set();

    const dfs = (node) => {
        const neighbors = graph[node] || [];
        if(visited.size === totalNodes) return true;

        for(let i = 0; i < neighbors.length; i++) {
            if(visited.has(neighbors[i])) continue;
            visited.add(neighbors[i]);
            if(dfs(neighbors[i])) return true;
            visited.delete(neighbors[i]);
        }

        return false;
    }
    // adding src node becase we're considering it as visited.
    visited.add(src);
    return dfs(src);
}

const edges = [[0,1],[1,2],[1,3],[1,4]];

console.log(hamiltonianPath(edges,0));
