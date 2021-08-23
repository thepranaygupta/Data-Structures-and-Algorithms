class Solution {
    public int maximumWealth(int[][] arr) {
        int maxWealth = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int iwealth = 0;
            for(int j = 0; j < arr[i].length; j++){
                iwealth += arr[i][j];
            }
            if(iwealth > maxWealth)
                maxWealth = iwealth;
        }
        return maxWealth;
    }
}
