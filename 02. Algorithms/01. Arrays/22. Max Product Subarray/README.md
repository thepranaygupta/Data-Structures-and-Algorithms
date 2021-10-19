## 22. Max Product Subarray
## https://www.interviewbit.com/problems/max-product-subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

Example :

Input : [2, 3, -2, 4]

Return : 6

Possible with [2, 3]

```Java
class Solution {

    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = min[0] = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]>0){
                max[i]=Math.max(nums[i], max[i-1]*nums[i]);
                min[i]=Math.min(nums[i], min[i-1]*nums[i]);
            }else{
                max[i]=Math.max(nums[i], min[i-1]*nums[i]);
                min[i]=Math.min(nums[i], max[i-1]*nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}
```