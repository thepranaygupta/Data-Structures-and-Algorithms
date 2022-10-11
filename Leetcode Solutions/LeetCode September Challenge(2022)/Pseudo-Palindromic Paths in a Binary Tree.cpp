class Solution {
    int cnt[10] = {}, ans = 0;
    void dfs(TreeNode *root) {
        if (!root) return;
        cnt[root->val]++;
        if (!root->left && !root->right) {
            int c = 0;
            for (int i = 1; i < 10; ++i) {
                c += cnt[i] % 2;
                if (c >= 2) break;
            }
            if (c < 2) ++ans;
        }
        dfs(root->left);
        dfs(root->right);
        cnt[root->val]--;
    }
public:
    int pseudoPalindromicPaths (TreeNode* root) {
        dfs(root);
        return ans;
    }
};