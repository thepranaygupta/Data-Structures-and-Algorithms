## Find the Rotation Count in Rotated Sorted array

## https://practice.geeksforgeeks.org/problems/rotation4723/1#

## [Editorial Link](https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/)

### Approach 1: Linear Search

```java
// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        // code here
        int min = arr[0];
        int minindex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
                minindex = i;
            }
        }
        return minindex;
    }
}
```
