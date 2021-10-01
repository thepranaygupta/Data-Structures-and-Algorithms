vector<int> reverseLevelOrder(Node *root)
{
    vector<int>ans;
    vector<vector<int>>ans1;
    if(!root) return ans;
    queue<Node*>q;
    q.push(root);
    while(!q.empty()){
        int s = q.size();
        vector<int>level;
        for(int i = 0 ; i < s ; i++){
            Node* curr = q.front();
            q.pop();
            if(curr->left) q.push(curr->left);
            if(curr->right) q.push(curr->right);
            level.push_back(curr->data);
        }
        ans1.push_back(level);
    }
    for(int i = ans1.size()-1 ; i >= 0 ; i--){
        for(int j = 0 ; j < ans1[i].size() ; j++){
            ans.push_back(ans1[i][j]);
        }
    }
    return ans;
}
