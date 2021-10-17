class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (k-- > 0) {
            ans[i++] = heap.remove();
        }
        return ans;
    }
}