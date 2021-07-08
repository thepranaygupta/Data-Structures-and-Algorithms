class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int a[], int n, int k)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(i<k) {
                pq.add(a[i]);
            } else {
               if(pq.peek()<a[i]){
                   pq.remove();
                   pq.add(a[i]);
               } 
            }
        }
        ArrayList<Integer> ans =new ArrayList<>(pq);
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
}
