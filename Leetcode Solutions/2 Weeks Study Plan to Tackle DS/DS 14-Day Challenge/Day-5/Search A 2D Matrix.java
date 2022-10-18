public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix.length -1;
        int j = matrix[0].length -1;
        if(target > matrix[i][j] || target < matrix[0][0] ) return false;

        int x = 0;
        int y = j;
        while(x <= i&& y>=0){
            if(target == matrix[x][y]) return true;
            else if( target < matrix[x][y]){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }
}