var scoreOfParentheses = function(s) {

    let score = 0;
    const myStack = [];
    
    for(let i = 0; i < s.length; i++) {
        if(s[i] == "(") {
            myStack.push(score);
            score = 0;
        } else {
            score = myStack.pop() + Math.max(score*2, 1);
        }
    }
    
    return score;
};

console.log(score("(())"));
