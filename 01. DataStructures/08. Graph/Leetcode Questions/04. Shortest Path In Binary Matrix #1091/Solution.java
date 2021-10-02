class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return -1;
        int n = grid.length;
        int m = n;
        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        
        LinkedList<int[]> que = new LinkedList<>();
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        
        grid[0][0] = 1;
        que.addLast(new int[] {0, 0});
        
        int level = 1;
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int[] idx = que.removeFirst();
                int r = idx[0];
                int c = idx[1];
                
                if (r == n - 1 && c == m - 1) {
                    return level;
                }
            
                for (int d = 0; d < dir.length; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        que.addLast(new int[] {x, y});
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
}
