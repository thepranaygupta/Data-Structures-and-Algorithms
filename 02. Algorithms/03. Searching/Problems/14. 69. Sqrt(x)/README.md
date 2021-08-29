## 69. Sqrt(x)
## https://leetcode.com/problems/sqrtx/

### using binary search:
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
