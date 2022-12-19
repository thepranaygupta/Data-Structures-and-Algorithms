var maxDepth = function(s) {
    let currunt = 0;
    let max = 0;
    
    for(let i = 0; i < s.length; i++) {
        if(s[i] == "(") {
            currunt += 1;
            max = Math.max(max, currunt);
        } else if (s[i] == ")"){
            currunt -= 1;
        }
    }
    
    return max;
};
maxDepth("8*((1*(5+6))*(8/6))")
