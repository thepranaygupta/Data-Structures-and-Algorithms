class Solution {
public:
    TreeNode* addOneRow(TreeNode* root, int v, int d) {
        if (!root) return root;
        if (d == 1) return new TreeNode(v, root, NULL);
        if (d == 2) {
            root->left = new TreeNode(v, root->left, NULL);
            root->right = new TreeNode(v, NULL, root->right);   
            return root;
        }
        addOneRow(root->left, v, d - 1);
        addOneRow(root->right, v, d - 1);
        return root;
    }
};