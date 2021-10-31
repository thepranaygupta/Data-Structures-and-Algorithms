private int maxHeight =0;
public int maxDepth(TreeNode root) {
    if (root==null)
        return 0;
        
    depth(root,0);
    return maxHeight+1;
    
}
private void depth(TreeNode root, int height)
{ if (root== null)
return;
if (height>maxHeight)
maxHeight= height;
depth(root.left, height+1);
depth(root.right, height+1);

}
}