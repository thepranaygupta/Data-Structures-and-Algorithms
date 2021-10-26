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
    public boolean nodeToRootPath(TreeNode node, TreeNode data, ArrayList<TreeNode> ans) {
    if (node == null)
        return false;
    if (node == data) {
        ans.add(node);
        return true;
    }

    boolean res = nodeToRootPath(node.left, data, ans) || nodeToRootPath(node.right, data, ans);
    if (res)
        ans.add(node);
    
    return res;
}

public void printKDown(TreeNode node, TreeNode block, int depth, List<Integer> ans) {
    if (node == null || depth < 0 || node == block) 
        return;

    if (depth == 0) {
        ans.add(node.val);
        return;
    }

    printKDown(node.left, block, depth - 1, ans);
    printKDown(node.right, block, depth - 1, ans);
}

public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    ArrayList<TreeNode> list = new ArrayList<>();
    nodeToRootPath(root, target, list);

    List<Integer> ans = new ArrayList<>();
    TreeNode blockNode = null;

    for (int i = 0; i < list.size(); i++) {
        printKDown(list.get(i), blockNode, K - i, ans);
        blockNode = list.get(i);
    }
    return ans;
}
}
