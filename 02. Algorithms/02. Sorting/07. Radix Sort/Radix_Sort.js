
const createZeros = (n) => {

    let zero =  '';
    for(let i = 0; i < n; i++) {
        zero += '0';
    }
    return zero;
}

// d = max digit length; n = number of elements; b = number of items in the bucket.
// Time O(d*(n+b)) | Space O(n);
const radixSort = (nums) => {

    let maxDigit = 0;
    nums = nums.map((num) => {
        return num.toString();
    });
    for(let i = 0; i < nums.length; i++) {
        maxDigit = Math.max(nums[i].length, maxDigit);
    }
    // append 0 at the bgining
    for(let i = 0; i < nums.length; i++) {
        if(nums[i].length < maxDigit) {
            let zeros = maxDigit - nums[i].length;
            zeros = createZeros(zeros);
            nums[i] = zeros + nums[i];
        }
    }
    
    //create bucket;
    // let bucket = new Array(10).fill([]);

    // main chunk of the algorithm.
    for(let i = maxDigit - 1; i > -1; i--) {
        const bucket = [];
        for(let i = 0; i < 10; i++) {
            bucket.push([]);
        }
        for(let j = 0; j < nums.length; j++) {
            const digit = +(nums[j][i]);
            // console.log(digit)
            bucket[digit].push(nums[j]);
        }
        nums = [];
        for(let j = 0;  j < bucket.length;  j++) {
            for(let k = 0; k < bucket[j].length; k++) {
                nums.push(bucket[j][k]);
            }
        }
    }

    return nums.map((num) => {
        return +num;
    });
}


// [15, 1, 321, 10, 802, 2, 123, 90, 109,  11];
// const nums = [15, 1, 321, 10, 802, 2, 123, 90, 109,  11];
const nums = [];
for(let i = 0; i < 100000; i++) {
    nums.push(Math.floor(Math.random() * 1000000));
}

// this will check if the array is sorted.
const check = (nums) => {
    for(let i = 1; i < nums.length; i++) {
        if(nums[i] < nums[i-1]) return false;
    }
    return true;
}
const res = radixSort(nums);
console.log(res);

// checking the array if it's sorted.
console.log(check(res));
