
class Solution {
    // arr: input array
    // n: size of array
    //Function to sort the array into a wave-like array.
    convertToWave(n, arr)
    {
        //your code here
        const swap = (a,b) => {
            const temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        
        for(let i = 1; i < n; i += 2) {
            swap(i-1, i);
        }

        return arr;
    }
}
