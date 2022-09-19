// - Enqueue()  Add item to the queue from the REAR.
// - Dequeue()  Remove item from the queue from the FRONT.
// - isFull()  Check if queue is full or not.
// - isEmpty()  Check if queue empty or not.
// - count() Get number of items in the queue.
// - peek() return front elemenet in the queue(line).
// 1 2 3 4 5 6 7 8 9 10


class Stack {
    constructor(size){
        this.stack = [];
    }
    
    isEmpty(){
        return this.stack.length === 0 ? true : false;
    }
    push(data) {
        return this.stack.push(data);
    }
    pop(){
        return this.stack.pop();
    }
    size() {
        return this.stack.length;
    }
}

class Queue {
    constructor(size) {
        this.stackA = new Stack();
        this.stackB = new Stack();
        this.size = size;
        // [2,3,4,5,6]
        // [] []
    }

    enqueu(data) {
        // console.log(this.stackA.size(), this.stackB.size(), this.size);
        if(this.stackA.size() + this.stackB.size() < this.size) {
            this.stackA.push(data);
        }
    }

    dequeue() {
        if(this.stackB.isEmpty()) {
            while(!this.stackA.isEmpty()) {
                this.stackB.push(this.stackA.pop());
            }
        }

        this.stackB.pop();
    }

    peek() {
        if(this.stackB.isEmpty()) {
            return this.stackA.stack[0];
        } else {
            return this.stackB.stack[this.stackB.stack.length - 1];
        }
    }

    isEmpty() {
        if(this.stackA.isEmpty() && this.stackB.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    isFull() {
        if(this.stackA.isEmpty() && this.stackB.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    count() {
        return this.stackA.size() + this.stackB.size();
    }
}

// 3,10,101,52,4
const myQueue = new Queue(5);
myQueue.enqueu(1); 
myQueue.enqueu(2);
myQueue.enqueu(3);
myQueue.enqueu(4);
myQueue.dequeue();
myQueue.dequeue();
myQueue.dequeue();
myQueue.dequeue();
myQueue.enqueu(5);
myQueue.enqueu(5);
myQueue.enqueu(5);
myQueue.enqueu(5);
myQueue.enqueu(5);
myQueue.dequeue(5);
myQueue.enqueu(5);

console.log(myQueue.count());

