## 215. Kth Largest Element in an Array
## https://leetcode.com/problems/kth-largest-element-in-an-array/

### Approach 1: Sort the array, TC = O(nlog(n))
simply sort the array and return (length-1)th element
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```

### Approach 2: 
