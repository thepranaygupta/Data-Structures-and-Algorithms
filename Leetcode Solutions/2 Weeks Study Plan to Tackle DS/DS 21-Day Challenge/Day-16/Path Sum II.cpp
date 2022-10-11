class Solution {
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        if (!root) return {};
        vector<vector<int>> ans;
        vector<int> path;
        dfs(root, targetSum, path, ans);
        return ans;
    }
    void dfs(TreeNode* node, int targetSum, vector<int>& path,
             vector<vector<int>>& ans) {
        path.push_back(node->val);
        targetSum -= node->val;
        if (!node->left && !node->right && !targetSum) ans.push_back(path);
        if (node->left) dfs(node->left, targetSum, path, ans);
        if (node->right) dfs(node->right, targetSum, path, ans);
        path.pop_back();
    }
};