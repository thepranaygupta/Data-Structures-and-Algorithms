class Stack {
    constructor(){
        this.stack = [];
    }
    
    isEmpty(){
        return this.stack.length === 0 ? true : false;
    }
    
    peek(){
        return this.stack[this.stack.length - 1];
    }
    
    push(val){
        return this.stack.push(val);
    }
    
    pop(){
        return this.stack.pop();
    }
}

var validateStackSequences = function(pushed, popped) {
    
    const myStack = new Stack();
    let j = 0;

    for(let i = 0; i < pushed.length; i++) {
        myStack.push(pushed[i]);
        while(myStack.peek() !== undefined && popped[j] !== undefined && myStack.peek() === popped[j]) {
            myStack.pop();
            j++;
        }
    }

    return myStack.isEmpty();
};


console.log(validateStackSequences([1,2,3,4,5], [4,3,5,1,2]));
