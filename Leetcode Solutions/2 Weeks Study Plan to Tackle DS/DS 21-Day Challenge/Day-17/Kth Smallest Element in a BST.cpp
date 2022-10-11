class Solution {
public:
    struct comparator {
        bool operator()(int a,int b)
            {
                return a>b;
            }
    };
    void preorder(TreeNode* root, priority_queue <int,vector<int>, comparator>& q){
        if(root==NULL) return;
        q.push(root->val);   
        preorder(root->left,q);
        preorder(root->right,q);
    }
    int kthSmallest(TreeNode* root, int k) {
        priority_queue <int,vector<int>, comparator> q;
        preorder(root,q);
        while(--k)
            q.pop();
        return q.top();
    }
};