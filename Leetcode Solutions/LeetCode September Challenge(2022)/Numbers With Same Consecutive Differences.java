class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        LinkedList<Integer> res = new LinkedList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (int i = 1; i < N; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                int t = res.removeFirst();
                if (t == 0) 
				continue;
                int mod = t % 10;
                if (K == 0) {
                    res.add(t * 10 + mod);
                    continue;
                }
                if (mod - K >= 0) {
                    res.add(t * 10 + mod - K);
                }
                if (mod + K < 10) {
                    res.add(t * 10 + mod + K);
                }
            }
        }
        int[] arr = new int[res.size()];
        int i = 0;
        while (!res.isEmpty()) {
            arr[i++] = res.removeFirst();
        }
        return arr;
    }
}