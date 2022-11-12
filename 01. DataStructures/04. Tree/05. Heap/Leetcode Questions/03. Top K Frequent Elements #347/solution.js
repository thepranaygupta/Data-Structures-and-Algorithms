// problem link https://leetcode.com/problems/top-k-frequent-elements/

var topKFrequent = function(nums, k) {
        const myMap = new Map();
    nums.forEach((num) => {
        if(!myMap.has(num)) {
            myMap.set(num, 1);
        } else {
            myMap.set(num,myMap.get(num) + 1);
        }
    });
    const result = [];

    for(let [key, value] of myMap) {
        if(result[value] !== undefined) {
            if(Array.isArray(result[value])) {
                result[value] = [...result[value], key];
            } else {
                // console.log(result[value], 'fjf');
                result[value] = [result[value], key];
            }
        } else {
            result[value] = key;
        }
    }
    // console.log(result);
    // console.log(myMap);
    const myResult = [];
    for(let i = result.length - 1; i > 0; i--) {

        if(myResult.length == k) return myResult;

        if(Array.isArray(result[i])) {
           result[i].forEach((j) => {
               if(myResult.length == k) return myResult;
               myResult.push(j);
           });
        } else if(result[i] !== undefined) {
            myResult.push(result[i]);
        }
    }

  return myResult;  
};
