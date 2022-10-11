class Solution {
public:
    void dfs(TreeNode* root, int lv, vector<int> &res){
        if(!root)   return;
        if(lv>=res.size()) res.push_back(root->val);
        dfs(root->right,lv+1,res);
        dfs(root->left,lv+1,res);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        dfs(root, 0, res);
        return res;
    }
};