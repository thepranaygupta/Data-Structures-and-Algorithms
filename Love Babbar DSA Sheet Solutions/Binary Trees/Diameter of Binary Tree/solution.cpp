class Solution {
  public:
    // Function to return the diameter of a Binary Tree.
    int height(Node* root , int &d){
        if(!root) return 0;
        int lh = height(root->left , d);
        int rh = height(root->right , d);
        d = max(d ,1 + lh + rh);
        return 1 + max(lh , rh);
    }
    int diameter(Node* root) {
        int d = 0;
        height(root , d);
        return d;
    }
};
