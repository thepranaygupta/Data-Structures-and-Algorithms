class Solution {
public:
    void helper(TreeNode*root,vector<vector<int>>&res,int level)
    {
        if(!root) return;   
        if(level>=res.size())
            res.push_back({});
        res[level].push_back(root->val);
        helper(root->left,res,level+1);
        helper(root->right,res,level+1);
    }
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>>res;
        if(!root)   return res;
        helper(root,res,0); 
        for(int i=1;i<res.size();i=i+2)
        {
            reverse(res[i].begin(),res[i].end());
        }
        return res;
    }
};