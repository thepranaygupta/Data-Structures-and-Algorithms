## Cyclically Rotate an Array
> Given an array, rotate the array to the right by `k` steps, where `k` is non-negative.

## https://leetcode.com/problems/rotate-array/
### [Video Tutorial](https://youtu.be/8RErc0VXAo8)

### Approach 1: Brute Force, TC = O(k×N)
```java
public void rotate(int[] a, int k) {
    int temp = a[0];
    for(int i = 1; i <= k; i++)
        for(int j = 0; j < a.length; j++) {
            if(j == 0) {
                temp = a[0];
                a[0] = a[a.length - 1];
            }
            else {
                int temp2 = a[j];
                a[j] = temp;
                temp = temp2;
            }
        }
}
```
### Approach 2: Reverse by Parts, TC = O(N)
- if `k` is greater then the length of array then use `k = k % len`
- if `k` is negative then use `k + len`, then `k`
```java
public void rotate(int[] arr, int k) {
    int len = arr.length;
    k = k % len;
    // reverse part1
    reverse(arr, 0, len - k - 1);
    
    // reverse part2
    reverse(arr, len - k, len - 1);
    
    // reverse the whole array
    reverse(arr, 0, len-1);
}
```
