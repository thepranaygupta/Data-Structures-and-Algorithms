
// you need to print the steps you'll perform.
// Time O(2^n) | Space O(n)
const towerOfHanoi = (n, source, helper, destination) => {
    if(n === 1) {
        console.log(`move from ${source} to ${destination}`);
        return;
    }

    towerOfHanoi(n-1, source, destination, helper);
    console.log(`move from ${source} to ${destination}`);
    towerOfHanoi(n-1, helper, source, destination);
}

towerOfHanoi(4,'A','B','C');
