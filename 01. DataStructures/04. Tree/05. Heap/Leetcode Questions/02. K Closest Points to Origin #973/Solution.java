class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return d2 - d1;
        });
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (k-- > 0) {
            ans[i++] = heap.remove();
        }
        return ans;
    }
}
