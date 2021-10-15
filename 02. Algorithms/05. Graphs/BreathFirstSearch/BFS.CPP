/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root==NULL){
            return ans;
        } 
        queue<pair<TreeNode*,int>> q;
        q.push({root,0});
        
        while(q.empty()==false){
            
            TreeNode* node = q.front().first;
            int level = q.front().second;
            
            vector<int> temp;
            
            while(q.front().second==level){
                
                temp.push_back(q.front().first->val);
                
                if(q.front().first->left!=NULL){
                    q.push({q.front().first->left,level+1});
                }
                if(q.front().first->right!=NULL){
                    q.push({q.front().first->right,level+1});
                }
                q.pop();
                
            }
            ans.push_back(temp);
        }
        return ans;
    }
};