
const linearSearch = (arr, searchElemenet) =>  {

    for(let i = 0; i < arr.length; i++) {
        if(arr[i] === searchElemenet) return i + 1;
    }

    return -1;
}

