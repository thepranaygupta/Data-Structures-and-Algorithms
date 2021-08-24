## 852. Peak Index in a Mountain Array
## https://leetcode.com/problems/peak-index-in-a-mountain-array/

### [Video Tutorial](https://youtu.be/W9QJ8HaRvJQ?t=7080)

## Approach 1: Using linear search <br> TC: O(n)
```java
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i;
        for(i = 0; i < arr.length; i++) {
            if(arr[i + 1] < arr[i])
                break;
        }
        return i;
    }
}
```
