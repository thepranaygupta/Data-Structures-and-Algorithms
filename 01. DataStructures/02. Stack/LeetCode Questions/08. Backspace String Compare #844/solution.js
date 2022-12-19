var backspaceCompare = function(s, t) {
    
    const sStack = [];
    const tStack = [];
    
  
    for(let i = 0; i < s.length; i++) {
        if(s[i] == '#') {
            sStack.pop();
        } else {
            sStack.push(s[i]);
        }
    }
    
    for(let i = 0; i < t.length; i++) {
        if(t[i] == '#') {
            tStack.pop();
        } else {
            tStack.push(t[i]);
        }
    }
    console.log(sStack, tStack);
    return sStack.join('') == tStack.join('');
};

console.log(backspaceCompare('ab#c', 'ad#c'));
