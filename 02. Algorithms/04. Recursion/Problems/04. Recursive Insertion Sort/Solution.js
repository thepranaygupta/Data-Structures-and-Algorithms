//
// Insertion Sort Recursion
// Time O(n^2) | Space O(1)
const insertionSort = (arr) => {

    const swap = (i,j) => {
        const temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    const dfs = (n) => {
        if(n === 0) return;
        dfs(n-1);
        let end = n;
        while(end > 0) {
            if(arr[end-1] > arr[end]) swap(end, end-1);
            end--;
        };
    }
    dfs(arr.length - 1);
    return arr;
}

console.log(insertionSort(arr));
