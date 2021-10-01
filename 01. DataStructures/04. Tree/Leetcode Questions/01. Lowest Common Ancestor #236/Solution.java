/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        if(node == null) {
            return new ArrayList<TreeNode>();
        }
        if(node.val == data) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }

        ArrayList<TreeNode> leftAns = nodeToRootPath(node.left, data);
        if(leftAns.size() != 0) {
            leftAns.add(node);
            return leftAns;
        }
        
        ArrayList<TreeNode> rightAns = nodeToRootPath(node.right, data);
        if(rightAns.size() != 0) {
            rightAns.add(node);
            return rightAns;
        } 
        return new ArrayList<TreeNode>();
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = null;
        ArrayList<TreeNode> pPath = nodeToRootPath(root, p.val);
        ArrayList<TreeNode> qPath = nodeToRootPath(root, q.val);
        
        int i = pPath.size() - 1;
        int j = qPath.size() - 1;
        
        while(i >= 0 && j >= 0) {
            if(pPath.get(i) != qPath.get(j)) {
                break;
            } 
            lca = pPath.get(i);
            i--;
            j--;
        }
        return lca;
    }
}
