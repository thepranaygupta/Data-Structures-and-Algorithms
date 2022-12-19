var buildArray = function(target, n) {
    
    const outputArr = [];
    const mySet = new Set();
    
    for(let i = 0; i < target.length; i++) {
        mySet.add(target[i]);
    }
    j = 1;
    while(j <= n && mySet.size) {
        
        outputArr.push('Push');
        
        if(!mySet.has(j)) {
            outputArr.push('Pop');
        }
        
        if(mySet.has(j)) {
            mySet.delete(j);
        }  
        j++;
    }
    
    return outputArr;
};

console.log(buildArray([1,3], 3));
