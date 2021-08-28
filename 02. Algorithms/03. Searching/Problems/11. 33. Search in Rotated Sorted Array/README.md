## 33. Search in Rotated Sorted Array
## https://leetcode.com/problems/search-in-rotated-sorted-array/

### Explaination
Let's say ```nums``` looks like this: [12, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

Because it's not fully sorted, we can't do normal binary search. But here comes the trick:

- If ```target``` is let's say 14, then we adjust ```nums``` to this, where "inf" means infinity:
[12, 13, 14, 15, 16, 17, 18, 19, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf, inf]

- If ```target``` is let's say 7, then we adjust ```nums``` to this:
[-inf, -inf, -inf, -inf, -inf, -inf, -inf, -inf, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]

And then we can simply do ordinary binary search.

Of course we don't actually adjust the whole array but instead adjust only on the fly only the elements we look at. And the adjustment is done by comparing both the target and the actual element against nums[0].

### Code
If ```nums[mid]``` and ```target``` are _"on the same side"_ of ```nums[0]```, we just take ```nums[mid]```. Otherwise we use Integer.MIN_VALUE or Integer.MAX_VALUE as needed.

``` java
class Solution {
    public int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            int num = arr[mid];
            // if arr[mid] and target are "on the same side" of arr[0], we just take arr[mid].
            if ((arr[mid] < arr[0]) == (target < arr[0])) {
                num = arr[mid];
            } else {
                num = target < arr[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
    
            if (num < target)
                start = mid + 1;
            else if (num > target)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }
}
```
