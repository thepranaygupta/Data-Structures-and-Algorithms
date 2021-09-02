## 69. Sqrt(x)
## https://leetcode.com/problems/sqrtx/

### Approach 1: Using Binary Search
Search range summary:

1. ```[1, Integer.MAX_VALUE]```, this is easy but I don't like, since you are not showing the use of your brain
2. ```[1, x/2]```, here you have to do math to prove it: x/2 should include the sqrt(x), i.e. (x/2)^2 >= x, then x >= 4. Easy.
3. ```[1, x]``` which I prefer, no math needed

```java
class Solution {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1; 
        int right = x; // here right = x/2 is also correct
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
```

### Approach 2: Find the Floor of `x` in the Array and return `floor + 1`
> [03. Floor in a Sorted Array](../03.%20Floor%20in%20a%20Sorted%20Array)

```java
class Solution{
    
    public static void main(String[] args) {
        int arr[] = {1,4,9,16,25,36,49,64,81,100};
        int N = 17;
        System.out.println(findFloor(arr, arr.length, N) + 1);
    }
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(int arr[], int n, int target){
    
        int start = 0;
        int end = n - 1;
	    while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target)
                return mid;
            else if (target > arr[mid]) {
	    		start = mid + 1;
	    	} else if (target < arr[mid]) {
	    		end = mid - 1;
	    	}
	    }
        return end;
	}
}
```
