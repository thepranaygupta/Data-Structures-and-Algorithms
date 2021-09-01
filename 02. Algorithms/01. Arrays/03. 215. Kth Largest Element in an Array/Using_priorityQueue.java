class Solution {
    public int findKthLargest(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<Integer> minPq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            if(i<k) 
                minPq.add(arr[i]);
            else if(arr[i]>minPq.peek()) {
                minPq.remove();
                minPq.add(arr[i]);
            }
        }
        return minPq.remove();
    }
}
