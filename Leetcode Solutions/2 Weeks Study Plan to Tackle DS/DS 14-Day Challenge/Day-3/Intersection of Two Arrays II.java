class Solution {
    public int[] intersect(int[] nums1, int[] nums2) { 
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        } 
        int i = 0;
        int j = 0; 
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
         
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]){
                i++;
            }
            else {
                j++;
            }
        }
        return listToArray(result);
    }
     
    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        } 
        return result;
    }
}