// push
// pop
// display
// peek
// 12345

class Stack_array {
    constructor() {
        this.stackArray = [];
        this.size = 0;
    }

    stackPush(data) {
        this.stackArray.push(data);
    }

    stackPop(data) {
        this.stackArray.pop();
    }

    stackDisplay(data) {
        let output = '[ \n';
        for(let i = this.stackArray.length - 1; i >= 0; i--) {
            output += `${this.stackArray[i]} \n`;
        }
        output += ']';
        return output;
    }

    stackPeek() {
        if(this.stackArray[this.stackArray.length - 1]) {
            return this.stackArray[this.stackArray.length - 1];
        } else {
            return 'empty stack';
        }
    }
}

const myStack = new Stack_array();
myStack.stackPush(3);
myStack.stackPush(2);
myStack.stackPush(5);
myStack.stackPush(9);
myStack.stackPop();
myStack.stackPop();

console.log(myStack.stackPeek());
