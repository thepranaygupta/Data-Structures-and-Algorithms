class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode m = root;
    if(m.val > p.val && m.val < q.val){
        return m;  
    }else if(m.val>p.val && m.val > q.val){
        return lowestCommonAncestor(root.left, p, q);
    }else if(m.val<p.val && m.val < q.val){
        return lowestCommonAncestor(root.right, p, q);
    }
    return root;
    }
}