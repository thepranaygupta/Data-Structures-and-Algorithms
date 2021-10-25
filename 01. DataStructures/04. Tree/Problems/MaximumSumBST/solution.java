class Solution {

    int INF = (int) 1e8;
    int ans = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;
        int res = dfs(root, -INF, INF);
        if (res != -INF)
            res = Math.max(res, 0);
        else
            res = Math.max(res, Math.max(maxSumBST(root.right), maxSumBST(root.left)));
        return ans;
    }

    public int dfs(TreeNode root, int l, int h) {
        if (root == null)
            return 0;
        if (root.val <= l || root.val >= h)
            return -INF;
        int left = dfs(root.left, l, root.val);
        int right = dfs(root.right, root.val, h);
        if (left == -INF || right == -INF)
            return -INF;
        int res = Math.max(Math.max(left, right), root.val + left + right);
        ans = Math.max(res, ans);
        // System.out.println(ans);
        return root.val + left + right;
    }
}