// solving with priority queue



// push  done
// pop done
// getParent done
// getLeftChild done
// getRightChild done
// swap done
// peek  done
// print done

// this is a max heap
class PriorityQueue {
    constructor() {
        this.queue = [];
        this.size = 0;
    }

    // this is for max heap 
    add(val) {
        this.queue.push(val);
        this.bubbleUp(this.queue.length - 1);
    }

    // this is for the  max heap
    poll() {
        this.swap(0, this.queue.length - 1);
        const popped = this.queue.pop();
        // console.log(popped);
        this.bubbleDown(0);
        return popped;
    }

    // this will bubble down to the max heap
    bubbleDown(index) {
        if(this.queue[index] > this.queue[this.getLeftChild(index)] &&
            this.queue[index] > this.queue[this.getRightChild(index)]) return;
            
         if(this.queue[index] < this.queue[this.getLeftChild(index)]) {
            this.swap(index, this.getLeftChild(index));
            this.bubbleDown(this.getLeftChild(index));
         }   

         if(this.queue[index] < this.queue[this.getRightChild(index)]) {
            this.swap(index, this.getRightChild(index));
            this.bubbleDown(this.getRightChild(index));
         }
    }

    // this will bubble up to the max tree.
    bubbleUp(index) {

        if(index <= 0) return;
        if(this.queue[index] < this.queue[this.getParent(index)]) return;

        if(this.queue[index] > this.queue[this.getParent(index)]) {
            this.swap(index, this.getParent(index));
            this.bubbleUp(this.getParent(index));
        }
    }

    getLeftChild(index) {
        return (index * 2) + 1;
    }
    getRightChild(index) {
        return (index * 2) + 2;
    }
    swap(topNode, bottomNode) {
        const temp = this.queue[topNode];
        this.queue[topNode] = this.queue[bottomNode];
        this.queue[bottomNode] = temp; 
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
    
    const myPriority = new PriorityQueue();
    nums.forEach((element) => {
        myPriority.add(element);
    });
    console.log(myPriority.print());
    for(let i = 0; i < k - 1; i++){
         myPriority.poll();
    }

    return myPriority.poll();
};

const nums = [3,2,3,1,2,4,5,5,6];
const k = 4;

console.log(findKthLargest(nums, k));
