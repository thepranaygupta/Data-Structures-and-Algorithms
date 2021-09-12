RECURSIVE:-

a. preorder traversal(root - left - right)

preorder(node){
  if(node == NULL) return;
  print(node->data);
  preorder(node->left);
  preorder(node->right);
}

time complexity = O(N);
space complexity= 0(N);

b.Inorder traversal

inorder traversal(left - root - right)

inorder(node){
  if(node == NULL) return;
  inorder(node->left);
  print(node->data);
  inorder(node->right);
}

time complexity = 0(N)
space complexity = 0(N)

c. Postorder(left - right - root)

postorder(node){
  if(node == NULL) return;
  postorder(node->left);
  postorder(node->right);
  print(node->data);
}

d. Level order traversal(level by level)

 vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>>ans;
        if(root == NULL) return ans;
        queue<TreeNode*>q;
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int>level;
            for(int i = 0 ; i < size ; i++){
                TreeNode* node = q.front();
                q.pop();
                if(node->left!=NULL) q.push(node->left);
                if(node->right!=NULL) q.push(node->right);
                level.push_back(node->val);
            }
            ans.push_back(level);
        }
        return ans;
    }

ITERATIVE:-

a. Preorder traversal

vector<int> preorderTraversal(TreeNode* root) {
        vector<int>ans;
        if(root == NULL) return ans;
        stack<TreeNode*>st;
        st.push(root);
        while(!st.empty()){
            root = st.top();
            st.pop();
            ans.push_back(root->val);
            if(root->right!=NULL) st.push(root->right);
            if(root->left!=NULL) st.push(root->left);   
        }
        return ans;
    }
    
b. Inorder traversal

vector<int> inorderTraversal(TreeNode* root) {
        vector<int>ans;
        if(root == NULL) return ans;
        stack<TreeNode*>st;
        TreeNode* node = root;
        while(true){
            if(node!=NULL){
                st.push(node);
                node = node->left;
            }
            else{
                if(st.empty()) break;
                node = st.top();
                st.pop();
                ans.push_back(node->val);
                node = node->right;
            }
        }
        return ans;
    }

c.Postorder(two stacks)

vector<int>postorder(Node* root){
  
  vector<int>ans;
  
  if(root == NULL) return ans;
  
  stack<Node*>st1,st2;
  st1.push(root);
  
  while(!st1.empty()){
    
    root = st1.top();
    st1.pop();
    st2.push(root);
    if(root->left!=NULL) st1.push(root->left);
    if(root->right!=NULL) st1.push(root->right);
    
  }
  
  while(!st2.empty()){
    ans.push_back(st2.top()->val);
    st2.pop();
  }
}

d. Preorder Inorder Postorder in one traversal

vector<int>preinpost(Node* root){
  stack<pair<Node*,int>>st;
  vector<int>pre,in,post;
  
  if(root == NULL) return;
  
  st.push({root,1});
  
  while(!st.empty()){
    auto it = st.top();
    st.pop();
    
    if(it->second == 1){
      pre.push_back(it->first->val);
      it->second++;
      st.push(it);
      if(it.first->left!=NULL){
        st.push({it.first->left,1});
      }
    }
    
    if(it->second == 2){
      in.push_back(it.first->val);
      it->second++;
      st.push(it);
      if(it->second->right != NULL){
        st.push({it->second->right,1});
      }
    }
    
    else{
      post.push_back(it->first->val);
    }
  }
}
