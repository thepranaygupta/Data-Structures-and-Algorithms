// push
// pop
// display
// count

// peek

class Node {
    constructor(val, next) {
        this.next = next;
        this.val = val;
    }
}

class LinkedListStack {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    stackSize() {
        return this.size;
    }

    Stackpeek() {
        if(this.head) {
            return this.head.val;
        } else {
            return 'stack is empty';
        }
    }
    Stackpush(data) {
        this.head = new Node(data, this.head);
        this.size++;
    }

    StackPop() {
        if(this.head) {
            this.head = this.head.next;
            this.size--;
        } else {
            return 'stack is empty';
        }
    }

    displyaStack() {
        let output = '[ \n';

        let currunt = this.head;
        while(currunt) {
            output += `${currunt.val} \n`;
            currunt = currunt.next;
        }
        output += ']';
        return output;
    }
}

const myStack = new LinkedListStack();

myStack.Stackpush(2);
myStack.Stackpush(3);
myStack.Stackpush(4);
myStack.Stackpush(5);
myStack.StackPop();
console.log(myStack.stackSize());
