class Solution {
    public boolean isBipartite(int[][] graph, int[] vis, int src) {
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(src);
        
        int color = 0; 
        boolean isCycle = false;
        
        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();
                if (vis[rvtx] != -1) {
                    isCycle = true;
                    if (vis[rvtx] != color)
                        return false;
                    
                    continue;
                }
                
                vis[rvtx] = color;
                for (int v : graph[rvtx]) {
                    if (vis[v] == -1) {
                        que.addLast(v);
                    }
                }
            }
            color = (color + 1) % 2;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == -1 && !isBipartite(graph, vis, i))
                return false;
        }
        return true;
    }
}