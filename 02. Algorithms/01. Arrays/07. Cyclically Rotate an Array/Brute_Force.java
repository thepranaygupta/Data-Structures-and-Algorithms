// https://leetcode.com/problems/rotate-array/
class Solution {
    public void rotate(int[] a, int k) {
        int temp = a[0];
        for(int i = 1; i <= k; i++) {
            for(int j = 0; j < a.length; j++) {
                if(j == 0) {
                    temp = a[0];
                    a[0] = a[a.length - 1];
                }
                else {
                    int temp2 = a[j];
                    a[j] = temp;
                    temp = temp2;
                }
            }
        }
    }
}
