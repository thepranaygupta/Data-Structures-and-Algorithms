
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


const shortestPath = (edges, src, target) => {

    // creating a graph.
    const graph = {};
    for(let i = 0; i < edges.length; i++) {
        const [node1, node2, weight] = edges[i];

        if(graph[node1]) {
            graph[node1] = [...graph[node1], [node2 , weight]];
        } else {
            graph[node1] = [[node2, weight]];
        }

        if(graph[node2]) {
            graph[node2] = [...graph[node2], [node1, weight]];
        } else {
            graph[node2] = [[node1, weight]];
        }
    }

    const pQeue = new MinHeap();
    pQeue.insert([0, src, src.toString()]);
    const visited = new Set();
    visited.add(src);

    while(!pQeue.isEmpty()) {
        const [weight, node, path] = pQeue.extractMin();
        if(node === target) {
            return [weight, path];
        }
        visited.add(node);
        const neighbor = graph[node];
        for(let i = 0; i < neighbor.length; i++) {
            const [nextNode, nextWeight] = neighbor[i];
            if(visited.has(nextNode)) continue;
            pQeue.insert([weight + nextWeight, nextNode, `${path}->${nextNode}`]);
        }
        
    }
}

const edges = [
 [0,1,3],
 [1,4,7],
 [1,2,9],
 [4,2,5],
 [0,3,10],
 [0,5,1],
 [5,3,3],
 [2,6,4]
]

console.log(shortestPath(edges, 0, 6));
