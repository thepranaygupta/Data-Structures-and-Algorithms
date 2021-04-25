class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap(); // hash map is use to store greatestRightSide element(as a value) for each element in nums2(as a key)
        Stack<Integer> st=new Stack();
        
        for(int ele:nums2){
            while(!st.isEmpty() && ele>st.peek()){
                map.put(st.pop(),ele);
            }
            st.push(ele);
        }
        
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        
        return nums1;
    }
}