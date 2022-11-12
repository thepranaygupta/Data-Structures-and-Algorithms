// problem link https://leetcode.com/problems/kth-largest-element-in-an-array

  

class PriorityQueue {
    constructor() {
        this.queue = [];
        this.size = 0;
    }

    push(data) {
        this.queue.push(data);
        let currunt_index = this.queue.length -1;
        while(this.queue[currunt_index] < this.queue[this.getParent(currunt_index)]) {
            const parentIn = this.getParent(currunt_index);
            this.swap(parentIn, currunt_index);
            currunt_index = parentIn;
        }
        this.size++;
    }

    pop() {
        this.swap(0, this.queue.length -1);
        this.queue.pop();

        let currunt_index = 0;
        while(this.queue[currunt_index] > this.queue[this.getLeftChild(currunt_index)] || this.queue[currunt_index] > this.queue[this.getRightChild(currunt_index)]) {
            if(this.queue[currunt_index] > this.queue[this.getLeftChild(currunt_index)] && this.queue[this.getLeftChild(currunt_index)] >= this.queue[this.getRightChild(currunt_index)]) {
                // swap the right child with parent
                this.swap(currunt_index, this.getRightChild(currunt_index));
                currunt_index = this.getRightChild(currunt_index);
            } else if(this.queue[currunt_index] > this.queue[this.getRightChild(currunt_index)] && this.queue[this.getRightChild(currunt_index)] >= this.queue[this.getLeftChild(currunt_index)]) {
                // swap the left child with parent
                this.swap(currunt_index, this.getLeftChild(currunt_index));
                currunt_index = this.getLeftChild(currunt_index);
            } else if(this.queue[currunt_index] > this.queue[this.getLeftChild(currunt_index)]) {
                this.swap(currunt_index, this.getLeftChild(currunt_index));
                currunt_index = this.getLeftChild(currunt_index);
            } else if(this.queue[currunt_index] > this.queue[this.getRightChild(currunt_index)]) {
                this.swap(currunt_index, this.getRightChild(currunt_index)) 
                currunt_index = this.getRightChild(currunt_index);
            } else {
                break;
            }
        }
    }
    getLeftChild(index) {
        return (index * 2) + 1;
    }
    getRightChild(index) {
        return (index * 2) + 2;
    }
    swap(parentIn, currunt_index) {
        const temp = this.queue[currunt_index];
        this.queue[currunt_index] = this.queue[parentIn];
        this.queue[parentIn] = temp;
    }
    getParent(index) {
        return Math.ceil((index - 2)/2);
    }
    peek() {
        return this.queue[0];
    }
    print() {
        return this.queue;
    }
}

var findKthLargest = function(nums, k) {
    // 4 3 2 1 
      let myqueue = new PriorityQueue();
    nums.forEach((element) => {
        myqueue.push(element);
    });

    // popping from the queue
    for(let i = 0; i  < nums.length - k; i++) {
        myqueue.pop();
    }
    return myqueue.peek();
};
