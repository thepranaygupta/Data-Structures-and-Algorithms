/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int counter = 0;
    public int kthSmallest(TreeNode root, int k) {
        return KSmallest(root, k);
    }
    
    int KSmallest(TreeNode root, int k) {
        
        if(root == null)
            return -1;
        
        
        int left = KSmallest(root.left, k);
        
        counter++;
        if(counter == k)
            return root.val;
        
        int right = KSmallest(root.right, k);
        if(left != -1)
            return left;
        return right;
    }
}
