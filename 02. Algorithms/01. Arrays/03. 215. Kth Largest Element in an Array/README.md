## 215. Kth Largest Element in an Array
## https://leetcode.com/problems/kth-largest-element-in-an-array/

### Approach 1: Sort the array, TC = O(Nlog(N))
simply sort the array and return (length-1)th element
```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
```

### Approach 2: Using a Priority Queue, TC = O(N + KlogN)
> If we want the `largest item` we need a `MinHeap`, since we don't care about the smallest items. <br>
> If we want the `smallest item` we need a `MaxHeap`, since we don't care about the largest items. <br>
> **[Video Tutorial](https://youtu.be/hGK_5n81drs)**
- We will make a MinPQ of size K and initiallise it with 1st k elements.
- This PQ will store K largest element always, so we will iterate from k to last and add elements a[i] if it is more than pq.peek()
- and in last we will return pq.peek();
```java
class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Integer> minPq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            if(i<k) 
                minPq.add(arr[i]);
            else if(arr[i]>minPq.peek()) {
                minPq.remove();
                minPq.add(arr[i]);
            }
        }
        return minPq.remove();
    }
}
```
