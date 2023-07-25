//Problem Statement
//Given an even number N (greater than 2), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only the pair whose minimum value is the smallest among all the minimum values of pairs.
var sieveOfEratosthenese = (n) => {
    const NumberArr = new Array(n + 1).fill(true);
    NumberArr[0] = false;
    NumberArr[1] = false;
    for(let i = 2; i < n + 1; i++) {
        if(NumberArr[i]) {
            for(let j = i**2;  j < NumberArr.length; j += i) {
                NumberArr[j] = false;
            }
        }
    }

    // if value is true at a perticular index that means that number is prime.
    return NumberArr.map((num, i) => {
        if(num) {
            return i;
        } else {
            return false;
        }
    }).filter((isPrime) => isPrime);
}


var getTwoSum = (arr, target) => {

    let left = 0;
    let right = arr.length - 1;

    while(left < right) {
        if(arr[left] + arr[right] > target) right--;
        if(arr[left] + arr[right] < target) left++;
        if(arr[left] + arr[right] === target) return [arr[left], arr[right]];
    };
}


const twoPrime = (N) => {
    const AllPrimes = sieveOfEratosthenese(N);
    console.log(AllPrimes);
    return getTwoSum(AllPrimes, N);
}

console.log(twoPrime(74));
