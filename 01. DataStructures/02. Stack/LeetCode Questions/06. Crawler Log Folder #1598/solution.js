var minOperations = function(logs) {

    let output = 0;
    logs.forEach((log) => {
        if(log == "../") {
            output -= 1;
        } else if(log !== "./"){
            output +=  1;
        }
        
        if(output < 0) {
            output = 0;
        }
    });
    
    
    return output;
};

console.log(minOperations(["./","wz4/","../", "../", "../", "../", "../"]));
