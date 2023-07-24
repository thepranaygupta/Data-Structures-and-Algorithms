
const sieveOfEratosthenese = (n) => {

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

console.log(sieveOfEratosthenese(100));
