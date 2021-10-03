## DFS of Graph
## Problem Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

- ### Time Complexity: O(V+E)
- ### Auxiliary Space Complexity: O(V)

## Code Snippet:
```cpp
class Solution 
{
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
```

## Running Code:
![alt text](./output.png)
