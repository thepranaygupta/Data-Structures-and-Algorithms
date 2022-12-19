var makeGood = function(s) {
   
    const myStack = [];
    
    myStack.push(s[0]);
    for(let i = 1; i < s.length; i++) {
        
        if(myStack.length && Math.abs(s.charCodeAt(i) - myStack[myStack.length - 1].charCodeAt(0)) === 32 ) {
          myStack.pop();
        } else {
            myStack.push(s[i]);
        }
    }

    return myStack.join('');
};
 
console.log(makeGood('leEeetcode'));
