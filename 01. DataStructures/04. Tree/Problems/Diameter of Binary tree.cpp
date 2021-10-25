Diameter of a binary tree (https://leetcode.com/problems/diameter-of-binary-tree/submissions/)

solution:

int diameteroftree(Node* root){
 int diameter = 0 ;
 height(root,diameter);
 return diameter;
}

int height(Node* root , int& diameter){
  if(!root) return 0;
  int lh = height(root->left , diameter);
  int rh = height(root->right , diameter);
  diameter = max(diameter,lh+rh);
  return 1 + max(lh , rh);
}