## 53. Maximum Subarray
## https://leetcode.com/problems/maximum-subarray/

### [Video Tutorial](https://youtu.be/VMtyGnNcdPw)
![intuition](https://user-images.githubusercontent.com/64855541/132051927-8ee8b7f5-ee14-47a9-8b09-9bd4dd462bc4.jpg)
```java
class Solution {
    public int maxSubArray(int[] arr) {
        int csum = arr[0]; //current sum
        int osum = arr[0]; //overall sum
        for(int i = 1; i < arr.length; i++) {
            if(csum > 0)
                csum += arr[i];
            else
                csum = arr[i];
            
            if(csum > osum)
                osum = csum;
        }
        return osum;
    }
}
```
