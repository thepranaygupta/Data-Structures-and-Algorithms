class Solution {
    public int bfs(ArrayList<Integer> src, int[][]grid) {
        int m = grid[0].length;
        int n = grid.length;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < src.size(); i++) {
            int idx = src.get(i);
            que.add(idx);
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int time = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int idx = que.remove();
                int r = idx / m;
                int c = idx % m;
                for (int i = 0; i < dir.length; i++) {
                    int x = r + dir[i][0];
                    int y = c + dir[i][1];
                    if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        que.add(x * m + y);
                    }
                }
            }
            time++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time > 0 ? time - 1 : 0;
    }
    
    public int orangesRotting(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        ArrayList<Integer> src = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    src.add(i * m + j);
                }
            }
        }
        return bfs(src, grid);
    }
}
