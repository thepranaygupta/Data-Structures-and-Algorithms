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

RECURSIVE:-

    int height(TreeNode* node){
        int x=0,y=0;
        if(!node) return 0;

        x=height(node->left);
        y=height(node->right);

        return (x>y)?x+1:y+1;
    }

time complexity = 0(N)
space complexity = 0(N)


ITERATIVE:-

    int maxDepth(TreeNode* root) {
        if(!root) return 0;
        queue<TreeNode *> q;
        int height=0;
        q.push(root);
        while(!q.empty()){
            height++;
            int nodeCount = q.size();
            while(nodeCount--){
                root = q.front();
                q.pop();
                if(root->left)
                    q.push(root->left);
                if(root->right)
                    q.push(root->right);
            }
        }
        return height;
    }

time complexity = 0(N)
space complexity = 0(N)
