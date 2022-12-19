// - Enqueue() – Add item to the queue from the REAR.
// - Dequeue() – Remove item from the queue from the FRONT.
// - isFull() – Check if queue is full or not.
// - isEmpty() – Check if queue empty or not.
// - count() – Get number of items in the queue.
// - peek() – return front elemenet in the queue(line).
// 1 2 3 4 5 6 7 8 9 10 
//   f     r
// [ 1,2 3,4 ]
class Queue {
    constructor(size) {
        this.queue = [];
        this.front = 0;
        this.rear = -1;
        this.size = size;
    }

    enqueue(data) {
        if(!this.isFull()) {
            this.rear++;
            this.queue.push(data);
            return this.queue;    
        }
    }

    dequeue() {
       this.queue[this.front] = null;
       this.front++;
    }

    isEmpty() {
        if(this.rear == 0) {
            return true;
        } else {
            return false;
        }
    }
    reverseQueue() {
    let left = this.front;
    let right = this.rear;

    while(left < right) {
        console.log(left, right);
        const temp = this.queue[left];
        this.queue[left] = this.queue[right];
        this.queue[right] = temp;
        left++;
        right--;
    }

    }
    count() {
        return this.queue.length - this.front;
    }

    peek()  {
        return this.queue[this.front] ? this.queue[this.front] : 'nothing is in the queue';
    }

    isFull() {
        if(this.rear < this.size - 1) {
            return false;
        }else {
            return true;
        }
    }
    print() {
        return this.queue;

    }
}


const myQueue = new Queue(5);
myQueue.enqueue(1);
myQueue.enqueue(2);
myQueue.enqueue(3);
myQueue.dequeue();
myQueue.enqueue(4);
// myQueue.enqueue(5);
// myQueue.enqueue(6);
// myQueue.enqueue(6);
myQueue.reverseQueue();
// myQueue.dequeue();
// myQueue.dequeue();

console.log(myQueue.print());
