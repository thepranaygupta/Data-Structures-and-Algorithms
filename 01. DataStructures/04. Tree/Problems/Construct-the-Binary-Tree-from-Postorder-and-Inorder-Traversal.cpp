TreeNode* buildtree(vector<int>& inorder , vector<int> &postorder ){
  if(inorder.size() != postorder.size()) return NULL;
  
  map<int,int> hm;
  for(int i = 0 ; i < inorder.size() ; i++){
    hm[inorder] = i;
  }
  return mainans(inorder , 0 , inorder.size()-1 , postorder , 0 , postorder.size()-1 , hm);
}
TreeNode* mainans(vector<int>& inorder , int is , int ie , vector<int>& postorder , int ps , int pe , map<int,int>& hm){
  if(ps > pe || is > ie) return NULL;
  TreeNode* root = new TreeNode(postorder[pe]);
  int inroot = hm[postorder[pe]];
  int numsleft = inroot - is;
  root->left = mainans(inroot , is , inroot-1 , postorder , ps , ps+numsleft-1 , hm);
  root->right = mainans(inorder , inroot+1 , ie , postorder , ps + numsleft , pe-1 , hm);
  return root;
}