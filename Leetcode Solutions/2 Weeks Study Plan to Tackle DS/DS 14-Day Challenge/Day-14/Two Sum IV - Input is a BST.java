class Solution {
    public boolean findTarget(TreeNode root, int k) {
       List<Integer> nums = new ArrayList<>();
       inorder(root, nums);
       for(int i = 0, j = nums.size()-1; i<j;){
           if(nums.get(i) + nums.get(j) == k)return true;
           if(nums.get(i) + nums.get(j) < k)i++;
           else j--;
       }
       return false;
   }
   public void inorder(TreeNode root, List<Integer> nums){
       if(root == null)return;
       inorder(root.left, nums);
       nums.add(root.val);
       inorder(root.right, nums);
   }
}