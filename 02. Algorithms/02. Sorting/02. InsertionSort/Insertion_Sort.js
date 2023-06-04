// Insertion Sort
// Time O(n^2) | Space O(1)

const insertionSort = (arr) => {

    const swap = (i,j) => {
        const temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    for(let i = 1; i < arr.length; i++) {
        let j = i;
        while(j) {
            if(arr[j] < arr[j-1]) swap(j-1,j);
            j--;
        }
    }

    return arr;
}
