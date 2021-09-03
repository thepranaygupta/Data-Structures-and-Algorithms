// https://leetcode.com/problems/maximum-subarray/
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
