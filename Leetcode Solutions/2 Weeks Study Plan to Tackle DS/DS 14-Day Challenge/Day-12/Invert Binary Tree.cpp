class Solution {
    void swap(TreeNode *curr)
    {
        if(!curr)
            return;
        swap(curr->left);
        swap(curr->right);
        TreeNode *temp;
        temp = curr->left;
        curr->left = curr->right;
        curr->right = temp;
    }
public:
    TreeNode* invertTree(TreeNode* root) {
        swap(root);
        return root;
    }
};