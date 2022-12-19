var calPoints = function(ops) {
    
    const outputArr = [];
    
    ops.forEach((op) => {
        
         switch(op) {
             case 'D':
                 outputArr.push(+outputArr[outputArr.length - 1] * 2);
                 break;
             case "C":
                 outputArr.pop();
                 break;
             case "+":
                outputArr.push(+outputArr[outputArr.length - 1] + +outputArr[outputArr.length - 2]);
                 break;
             default:
                 outputArr.push(+op);
         }    
    });

    console.log(outputArr);
    
 const result = outputArr.reduce((pre, currunt) => {
        return currunt + pre;
    },0);
    
    return result;
};

console.log(calPoints(["5","-2","4","C","D","9","+","+"]));
