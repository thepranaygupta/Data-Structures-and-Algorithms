
const checksumCalc = (data)  => {

    // adding all the bytes
    const total = data.reduce((acc, num) => {
        return acc + num;
    });

    // taking inverse of the total
    const totalInverse = total ^ ~0;

    // appending the inversed byte at the end.
    data.push(totalInverse);

    // tinkering with a byte to simulate the data change
    // data[3] = 22;
    return data;
}

const checksum = (data) => {

    let total = 0;
    for(let i = 0; i < data.length - 1; i++) {
        total += data[i];
    }

    const inverseTotal = total ^ data[data.length - 1];

    // inverseTotal should Have all bytes set to one. negeting it should give us 0. If it's 0 then the data is safe.
    return ~inverseTotal === 0;
}


// data is an array of numbers
const data = [12,34,54,66,90];
console.log(checksum(checksumCalc(data)));
