class Solution {
public:
////Function to Maximum Depth of a binary tree.
    int maxDepth(TreeNode* root) {
        if(root==NULL)
            return 0;
        return (1+ max(maxDepth(root->left),maxDepth(root->right)));
    }
};