// you have to run this code on leet code for testing it
// the output seems fine but it's not working I don't konw why.

var CustomStack = function(maxSize) {
    this.maxSize = maxSize;
    this.curruntSize = 0;
    this.myStack = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
CustomStack.prototype.push = function(x) {
    
    if(this.curruntSize < this.maxSize) {
        this.myStack.push(x);
        this.curruntSize++;
    }
};

/**
 * @return {number}
 */
CustomStack.prototype.pop = function() {
  this.curruntSize--;
    if(this.myStack[this.myStack.length - 1]) {
        return this.myStack.pop();
    } else {
        return -1;
    }
};
