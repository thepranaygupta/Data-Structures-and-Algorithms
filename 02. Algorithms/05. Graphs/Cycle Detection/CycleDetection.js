// helper function 

const makeGraph = (adjList) => {

    const graph = {};
    for(let i = 0; i < adjList.length; i++) {
        const node1 = adjList[i][0];
        const node2 = adjList[i][1];
        if(graph[node1]) {
            graph[node1] = [...graph[node1], node2];
        } else {
            graph[node1] = [node2];
        }
        if(graph[node2]) {
            graph[node2] = [...graph[node2], node1];
        } else {
            graph[node2] = [node1];
        }
    }   

    return graph;
}
// n = number of nodes in the graph.
// Time O(n) | Space O(n)
const cycleDetectDFS = (adjList, src) => {

    const graph = makeGraph(adjList);
    const visited = new Set();
    const dfs = (node, parent) => {
        visited.add(node);
        const neighbor = graph[node];
        for(let i = 0; i < neighbor.length; i++) {
            if(visited.has(neighbor[i]) && neighbor[i] !== parent) {
                return [node, neighbor[i]];
            };
            if(!visited.has(neighbor[i])) dfs(neighbor[i], node);
        }
        return 'no cycle found';
    }
    return dfs(src, -1);
}
/// detecting cycle with bfs.

class Node {
    constructor(val, next) {
        this.val = val;
        this.next = next;
    }
}

class Queue {
    constructor(size) {
        this.front = null;
        this.size = size;
        this.count = 0;
        this.back = null;
    }

    enqueue(data) {
        
        if(this.isFull()) return;
        
        if(this.back) {
            this.back.next = new Node(data);
            this.back = this.back.next;
        } else {
            this.back = new Node(data);
            this.front = this.back;
        }
        this.count++;
    }

    dequeue() {
       
        let toBeReturn;
        if(this.front && !this.front.next) {
            toBeReturn = this.front;
            this.front = this.front.next;
            this.back = this.front;
        } else {
            toBeReturn = this.front;
            if(this.front) {
                this.front = this.front.next;
            }
        }
        this.count--;

        return toBeReturn ? toBeReturn.val : null; 
    }
    reverseQueue() {
        const stack = [];
        while(this.front) {
            stack.push(this.front.val);
            this.front = this.front.next;
        }
        // setting everyting to 0 and null;
        this.front = null;
        this.back = null;
        this.count = 0;
        // pushing on to the queue in reverse
        while(stack.length) {
           
            this.enqueue(stack.pop());
        }
    }
    isFull() {
        if(this.count < this.size) {
            return false;  
        } else {
            return true;
        }
    }

    isEmpty() {

        if(this.count <= 0) {
            return true;
        } else {
            return false;
        }
    }

    count1() {
        return this.count;
    }

    peek() {
        return this.front ? this.front.val : null;
        // return this.front.val;
    }

    print() {
        let currunt = this.front;
        let linkedStr = '';
        while(currunt) {
            linkedStr += currunt.val + "->" ; 
            currunt = currunt.next;
        }
        return linkedStr + 'null';
    }
}


const cycleDetectBFS = (adjList, src) => {

    const graph = makeGraph(adjList);
    const visited = new  Set();
    const queue = new Queue(Number.MAX_SAFE_INTEGER);
    queue.enqueue([src, -1]);

    while(!queue.isEmpty()) {
        const [node, parent] = queue.dequeue(); 
        const neighbor = graph[node];
        visited.add(node);
        for(let i = 0; i < neighbor.length; i++) {
            if(visited.has(neighbor[i]) && neighbor[i] !== parent) {
                // return the cycle
                return [node, neighbor[i]];
            }
            if(!visited.has(neighbor[i])) queue.enqueue([neighbor[i], node]);
        }
    }

    return 'no cycle found.';
}

cycleDetectUnioinFind = (adjList) => {

    const rank = new Array(adjList.length + 1).fill(1);
    const parent = [];

    for(let i = 1; i < adjList.length + 1; i++) {
        parent[i] = i;
    }

    const find = (n1) => {
        // we have to traverse because we're not doing paht compression. 
        // watch the below video to know about path compression. It's just a fancy name. It's nothing hard. Belive me.
        // https://www.youtube.com/watch?v=ID00PMy0-vE&t=729s&pp=ygUKdW5pb24gZmluZA%3D%3D
        while(parent[n1] !== n1) {
            n1 = parent[n1];
        }
        return n1;
    }

    const union = (n1, n2) => {
        n1 = find(n1);
        n2 = find(n2);

        if(n1 === n2) return false;
        if(rank[n1] > rank[n2]) {
            rank[n1] += rank[n2];
            parent[n2] = n1;
        } else {
            rank[n2] += rank[n1];
            parent[n1] = n2;
        }
        return true;
    }
    for(let i = 0; i < adjList.length; i++) {
        const [n1, n2] = adjList[i];
        if(!union(n1, n2)) return [n1,n2];
    }

    return 'no cycle found.'
    
}

/// ALL VALUES OF THE NODES IN THE GRAPH MUST BE UNIQUE. AND THEY SHOULD BE BETWEEN 1 AND N
const adjList = [[1,2],[1,4],[2,3],[2,5],[3,4],[4,6],[6,7]];
// console.log(cycleDetectUnioinFind(adjList));
// console.log(cycleDetectDFS(adjList, 1));
// console.log(cycleDetectBFS(adjList, 1));
