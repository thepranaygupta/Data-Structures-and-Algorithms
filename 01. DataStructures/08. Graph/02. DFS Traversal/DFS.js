// you need to have valid graph to traverse it.
function dfs(graph, source) {

    let dfsStack = [];
    const explored = new Set();
    
    dfsStack.push(source);
    explored.add(source);
   
    while(dfsStack.length) {
        let curruntNode = dfsStack.pop();

        // this will print the node of graph
        console.log(curruntNode);
        curruntNode = graph.get(curruntNode);

        curruntNode && curruntNode
        .filter(node => !explored.has(node))
        .forEach(node => {
           dfsStack.push(node);
           explored.add(node); 
        });    
    }
}

