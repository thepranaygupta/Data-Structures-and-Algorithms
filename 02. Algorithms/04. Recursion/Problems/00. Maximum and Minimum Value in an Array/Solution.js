const maxNumber = (arr) => {

    const dfs = (i) => {
        if(i === arr.length) return -Infinity;
        return Math.max(arr[i], dfs(i+1));
    }

    return dfs(0);
}

const minNumber = (arr) => {

    const dfs = (i) => {
        if(i === arr.length) return Infinity;

        return Math.min(arr[i], dfs(i+1));
    }

    return dfs(0);
}

const arr = [72, 5, 39, 91, 17, 88, 42, 63, 23, 10];

console.log(maxNumber(arr));
console.log(minNumber(arr));

