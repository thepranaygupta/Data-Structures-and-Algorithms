class FreqStack {
    
    public class Pair implements Comparable<Pair> {
        int val;
        int freq;
        int idx;
        Pair(int val, int freq, int idx) {
            this.val = val;
            this.freq = freq;
            this.idx = idx;
        }
        public int compareTo(Pair other) {
            if (this.freq == other.freq) {
                return other.idx - this.idx;
            }
            return other.freq - this.freq;
        }
    }
    
    HashMap<Integer, Integer> freq;
    PriorityQueue<Pair> pq;
    int idx;
    
    public FreqStack() {
        freq = new HashMap<>();
        pq = new PriorityQueue<>();
        idx = 0;
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        pq.add(new Pair(val, freq.get(val), idx));
        idx++;
    }
    
    public int pop() {
        Pair rp = pq.remove();
        freq.put(rp.val, rp.freq - 1);
        if (rp.freq - 1 == 0) {
            freq.remove(rp.val);
        }
        return rp.val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
