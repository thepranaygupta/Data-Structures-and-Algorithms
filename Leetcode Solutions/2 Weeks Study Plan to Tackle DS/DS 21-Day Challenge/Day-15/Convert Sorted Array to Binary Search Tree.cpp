class Solution {
public:
    TreeNode *sortedArrayToBST(vector<int> &num) {
        if(num.size() == 0) return NULL;
        if(num.size() == 1)
        {
            return new TreeNode(num[0]);
        }
        int middle = num.size()/2;
        TreeNode* root = new TreeNode(num[middle]);
        vector<int> leftInts(num.begin(), num.begin()+middle);
        vector<int> rightInts(num.begin()+middle+1, num.end());
        root->left = sortedArrayToBST(leftInts);
        root->right = sortedArrayToBST(rightInts);
        return root;
    }
};