// problem link https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/695029270/


class Node {
    constructor(val, next) {
        this.val = val;
        this.next = next;
    }
}


// this is just queue data structure to help with the solution. 
class myQueue {
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

        return toBeReturn ? toBeReturn : null; 
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




/// this is the real solution.
var distanceK = function(root, target, k) {
  
    if(k === 0) return [target.val];
    
    const graph = new Map();
    const graphQueue = new myQueue(Number.MAX_SAFE_INTEGER);

    graphQueue.enqueue(root);

    /// making the graph.
    while(!graphQueue.isEmpty()) {
        const node = graphQueue.dequeue();
        // taking care of the left child
        if(node.val) {
            if(node.val.left) {
                // atteching child to parent
               if(graph.get(node.val)) {
                   graph.set(node.val, [...graph.get(node.val), node.val.left]);
               } else {
                   graph.set(node.val, [node.val.left]);
               }
    
               // atteching parent to child
               if(graph.get(node.val.left)) {
                   graph.set(node.val, [...graph.get(node.val.left), node.val]);
               } else {
                   graph.set(node.val.left, [node.val]);
               }
            }
        }
        

        // taking care of the right child
        if(node.val) {
            if(node.val.right) {
                // atteching child to parent
               if(graph.get(node.val)) {
                   graph.set(node.val, [...graph.get(node.val), node.val.right]);
               } else {
                   graph.set(node.val, [node.val.right]);
               }
    
               // atteching parent to child
               if(graph.get(node.val.right)) {
                   graph.set(node.val, [...graph.get(node.val.right), node.val]);
               } else {
                   graph.set(node.val.right, [node.val]);
               }
            }    
        }

     if(node.val) {
            graphQueue.enqueue(node.val.left);
            graphQueue.enqueue(node.val.right);
        }
    }


    // now check for the distance 
    const visited = new Set();
    const searchQueue = new myQueue(Number.MAX_SAFE_INTEGER);
    const result = [];
    searchQueue.enqueue([target, 0]);
    visited.add(target);
    
    while(!searchQueue.isEmpty()) {
        const curruntNode = searchQueue.dequeue();
        const distance = curruntNode.val[1];
        const reference = curruntNode.val[0];

        if(distance == k) {
            result.push(reference.val);
        } else {
            if(graph.get(reference)) {
             graph.get(reference).forEach((neigber) => {           
                if(!visited.has(neigber)) {
                    visited.add(neigber);
                    searchQueue.enqueue([neigber, distance + 1]);
                }
            });    
            }
        }
    }


    return result;
};
