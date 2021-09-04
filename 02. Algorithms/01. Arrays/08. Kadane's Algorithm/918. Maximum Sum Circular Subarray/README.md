## 918. Maximum Sum Circular Subarray
## https://leetcode.com/problems/maximum-sum-circular-subarray/

<hr>

## Intuition
I guess you know how to solve max subarray sum (without circular). <br>
If not, you can have a reference here: **[53. Maximum Subarray](../53.%20Maximum%20Subarray)**


## Explanation
So there are two case. <br>
- Case 1. The first is that the subarray takes only a middle part, and we know how to find the max subarray sum.
- Case2. The second is that the subarray takes a part of head array and a part of tail array. <br>
We can transfer this case to the first one. <br>
The maximum result equals to the total sum minus the minimum subarray sum.

![image](https://user-images.githubusercontent.com/64855541/132093483-1a8200f4-41aa-4aec-970f-9de096cd06bd.png)

So the max **subarray circular sum** equals to: `max(the max subarray sum, the total sum - the min subarray sum)`


## Proof of the second case
max(prefix+suffix)  <br>
= max(total sum - subarray) <br>
= total sum + max(-subarray) <br>
= total sum - min(subarray) <br>


## Corner case
Just one edge case to pay attention: <br> 
If all numbers are _negative_, `maxSum = max(A)` and `minSum = sum(A)`. In this case, `max(maxSum, total - minSum) = 0`, which means the sum of an empty subarray. <br>
According to the description, we need to return the `max(A)`, instead of sum of am empty subarray.
So we return the `maxSum` to handle this corner case.


## Complexity
- One pass, time O(N)
- No extra space, space O(1)

```java
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
```
