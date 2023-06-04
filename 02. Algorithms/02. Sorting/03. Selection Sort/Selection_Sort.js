// Selection Sort.
// Time O(n^2) | Space O(1)
const selectionSort = (arr) => {

    const swap = (i, j) => {
        const temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    for(let i = 0; i < arr.length; i++) {
        let currMin = i;
        let currItem  = i + 1;
        while(currItem < arr.length) {
            if(arr[currItem] < arr[currMin]) {
                currMin = currItem;
            }        
            currItem++;
        }
        swap(currMin, i);
    }

    return arr;
}
