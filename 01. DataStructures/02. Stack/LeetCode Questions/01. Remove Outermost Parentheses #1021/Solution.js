var removeOuterParentheses = function(s) {
    const outputArr = [];
    const tempArr = [];
       
       for(let i = 0; i < s.length; i++) {
           if(s[i] === '(') {
               tempArr.push(s[i]);
                   if(tempArr.length > 1) outputArr.push(s[i]);
           } else {
               tempArr.pop();
                   if(tempArr.length >= 1) outputArr.push(s[i]);
           }
       }
       
       return outputArr.join("");
};

