// Time O(n) | Space O(n)
const factorial = (num) => {

    const dfs = (n) => {
        if(n === 1) return 1;
        return dfs(n-1) * n;
    }

    return dfs (num);
}

console.log(factorial(8));

