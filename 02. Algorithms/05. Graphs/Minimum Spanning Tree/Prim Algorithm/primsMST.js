
class MinHeap {
    constructor() {
      this.heap = [];
    }
  
    compare(a, b) {
      return a[0] - b[0];
    }
  
    getParentIndex(index) {
      return Math.floor((index - 1) / 2);
    }
  
    getLeftChildIndex(index) {
      return (index * 2) + 1;
    }
  
    getRightChildIndex(index) {
      return (index * 2) + 2;
    }
  
    insert(value) {
      this.heap.push(value);
      let currentIndex = this.heap.length - 1;
      let parentIndex = this.getParentIndex(currentIndex);
  
      while (currentIndex > 0 && this.compare(this.heap[currentIndex], this.heap[parentIndex]) < 0) {
        [this.heap[currentIndex], this.heap[parentIndex]] = [this.heap[parentIndex], this.heap[currentIndex]];
        currentIndex = parentIndex;
        parentIndex = this.getParentIndex(currentIndex);
      }
    }
  
    extractMin() {
      if (this.heap.length === 0) {
        return null;
      }
  
      if (this.heap.length === 1) {
        return this.heap.pop();
      }
  
      const min = this.heap[0];
      this.heap[0] = this.heap.pop();
      let currentIndex = 0;
      let leftChildIndex = this.getLeftChildIndex(currentIndex);
      let rightChildIndex = this.getRightChildIndex(currentIndex);
  
      while (leftChildIndex < this.heap.length) {
        let smallestChildIndex = rightChildIndex < this.heap.length && this.compare(this.heap[rightChildIndex], this.heap[leftChildIndex]) < 0
          ? rightChildIndex
          : leftChildIndex;
  
        if (this.compare(this.heap[currentIndex], this.heap[smallestChildIndex]) <= 0) {
          break;
        }
  
        [this.heap[currentIndex], this.heap[smallestChildIndex]] = [this.heap[smallestChildIndex], this.heap[currentIndex]];
        currentIndex = smallestChildIndex;
        leftChildIndex = this.getLeftChildIndex(currentIndex);
        rightChildIndex = this.getRightChildIndex(currentIndex);
      }
  
      return min;
    }
  
    peek() {
      return this.heap.length > 0 ? this.heap[0] : null;
    }
  
    isEmpty() {
      return this.heap.length === 0;
    }
}

  
const primsAlgorithm = (edges) => {

    const graph = {};
    for(let i = 0; i < edges.length;  i++) {
        const [n1,n2,w] = edges[i];
        if(!graph[n1]) graph[n1] = [];
        if(!graph[n2]) graph[n2] = [];
        graph[n1].push({node: n2, weight: w});
        graph[n2].push({node: n1, weight: w});
    }

    const MST = [];
    const startNode = edges[0][0]; 
    const visited = new Set();
    visited.add(startNode);
    const pq = new MinHeap();


    for(let i = 0; i < graph[startNode].length; i++) {
        const {node, weight} = graph[startNode][i];
        pq.insert([weight, startNode, node]);
    }

    while(!pq.isEmpty()) {
        const [w, n, n1] = pq.extractMin();

        if(!visited.has(n1)) MST.push([n, n1, w]);

        visited.add(n1);
        const neighbor = graph[n1];
        for(let i = 0; i < neighbor.length; i++) {
            const {node, weight} = neighbor[i];
            if(!visited.has(node)) {
                pq.insert([weight, n1, node]);
            }
        }
    }
    return MST;
}

const edges = [
    [1,2,1],
    [1,4,3],
    [2,4,3],
    [2,5,1],
    [2,3,6],
    [3,5,5],
    [3,6,2],
    [4,5,1],
    [5,6,4]
];

console.log(primsAlgorithm(edges));
