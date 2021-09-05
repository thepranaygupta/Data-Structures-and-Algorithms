// https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1#
class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int min, max;
        int ans = arr[n - 1] - arr[0];
        
        for(int i = 1; i < n; i++){
            if(arr[i] >= k) { //if height is not negative
                max = Math.max(arr[i-1]+k, arr[n-1]-k);
                min = Math.min(arr[i]-k, arr[0]+k);
                ans = Math.min(ans, max-min);
            }
        }
        return ans;
    }
}
