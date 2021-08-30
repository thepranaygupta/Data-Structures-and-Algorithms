## 167. Two Sum II - Input array is sorted
## https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

### Brute force approach: TC = O(n²)
```java
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int answer[] = {0 , 0};
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if((arr[i] + arr[j]) == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
```

### Better approach using binary search which reduces the average TC: worst TC = O(n²)
First we find the largest element which is smaller than ```target```, then linearly traverse from 0 to that largest element to find the required pair
```java
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int answer[] = {0 , 0};
        int start = 0, end = arr.length - 1;
        int index = 0;
        while(true) {
            int mid = start + (end - start)/2;
            if(start == end) {
                index = start;
                break;
            }
            if(arr[mid] <= target)
                start = mid + 1;
            if(arr[mid] > target)
                end = mid;
        }
        for(int i = 0; i <= index; i++) {
            for(int j = i + 1; j <= index; j++) {
                if((arr[i] + arr[j]) == target) {
                    answer[0] = i + 1;
                    answer[1] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
```

### Best Approach using 2 pointer method: TC = O(N)
```java
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while(i<=j) {
            if(arr[i] + arr[j] > target)
                j--; // need to decrease the sum
            else if(arr[i] + arr[j] < target)
                i++; // need to increase the sum
            else
                break;
        }
        return new int[]{i + 1, j + 1};
    }
}
```
