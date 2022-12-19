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


var dailyTemperatures = function(temperatures) {
    
   const nextWarmTemperatures = Array(temperatures.length).fill(0);
   const myStack = new Stack();

   for(let i = 0; i< temperatures.length; i++)  {

        const currunt = temperatures[i];
        while(!myStack.isEmpty() && temperatures[myStack.peek()] < currunt) {
            let index = myStack.pop();
            nextWarmTemperatures[index] = i - index;
        }

        myStack.push(i);
   }


   return nextWarmTemperatures;
};

console.log(dailyTemperatures([73,74,75,71,69,72,76,73]));
