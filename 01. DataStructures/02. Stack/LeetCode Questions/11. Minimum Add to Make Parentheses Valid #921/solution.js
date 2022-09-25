var minAddToMakeValid = function(s) {
    
    
    const myMap = new Map();
    myMap.set(')','(');
    const myStack = [];
    myStack.push(s[0]);
    
    for(let i = 1; i < s.length; i++) {
        if(myStack[myStack.length - 1] && myMap.get(s[i]) == myStack[myStack.length - 1]) {
            myStack.pop();
        } else {
            myStack.push(s[i]);
        }
    }
    console.log(myStack);
    return myStack.length
};

console.log(minAddToMakeValid("()()()"));
