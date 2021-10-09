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
    
    TreeNode a = null, b = null, prev = null;
    
    public boolean _recoverTree(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        if(!_recoverTree(root.left)) {
            return false;
        }
        
        if (prev != null && prev.val > root.val) {
            b = root;
            if (a == null) {
                a = prev;
            } else {
                return false;
            }
        }
        
        prev = root;
        
        if (!_recoverTree(root.right)) {
            return false;
        }
        
        return true;
    }
    public void recoverTree(TreeNode root) {
        _recoverTree(root);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
