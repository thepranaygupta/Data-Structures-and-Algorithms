// Time O(n^2) | Space O(n)
const bubbleSort = (arr) => {

    const swap = (i, j) => {
        [arr[i],arr[j]] = [arr[j], arr[i]]; 
    }

    const dfs = (start) => {
        if(start === arr.length) return;
        for(let i = start; i < arr.length; i++) {
            if(arr[start] > arr[i]) {
                swap(start,i);
            }
        }
        dfs(start+1);
    }
    dfs(0);

    return arr;
}

const arr = [2,4,5,62,3,0,10];

console.log(bubbleSort(arr));
