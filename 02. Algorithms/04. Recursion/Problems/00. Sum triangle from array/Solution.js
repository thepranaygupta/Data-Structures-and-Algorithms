const sumTriangle = (arr) => {
    const result = [];

    const dfs = (i) => {
        if(i === arr.length) {
            result.push(arr.slice());
            return arr.slice();
        };

        const resultArr = dfs(i+1);
        const currentTriangle = [];
        for(let i = 0; i < resultArr.length - 1; i++) {
            currentTriangle.push(resultArr[i] + resultArr[i+1]);
        } 
        result.push(currentTriangle);
        return currentTriangle;
    }
    dfs(0);
    result.pop();
    return result.reverse();
}

const arr = [1, 2, 3, 4, 5]; 

console.log(sumTriangle(arr));
