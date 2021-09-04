// https://leetcode.com/problems/maximum-sum-circular-subarray/
class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n = arr.length;
        int allsum = 0;
        for(int ele: arr)
            allsum += ele;
        
        int sumA = maximumSumSA(arr, n);
        int sumB = allsum - minimumSumSA(arr, n);
        if(sumA > 0)
            return Math.max(sumA, sumB);
        else
            return sumA;
    }
    public int maximumSumSA(int[] arr, int n) {
        int csum = arr[0]; //current sum
        int osum = arr[0]; //overall sum
        for(int i = 1; i < n; i++) {
            if(csum > 0)
                csum += arr[i];
            else
                csum = arr[i];
            
            if(csum > osum)
                osum = csum;
        }
        return osum;
    }
    public int minimumSumSA(int[] arr, int n) {
        int csum = arr[0]; //current sum
        int osum = arr[0]; //overall sum
        for(int i = 1; i < arr.length; i++) {
            if(csum < 0)
                csum += arr[i];
            else
                csum = arr[i];
            
            if(csum < osum)
                osum = csum;
        }
        return osum;
    }
}
