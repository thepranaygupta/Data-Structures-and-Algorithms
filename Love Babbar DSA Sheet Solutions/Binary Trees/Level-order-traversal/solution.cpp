class Solution
{
    public:
    //Function to return the level order traversal of a tree.
    vector<int> levelOrder(Node* node)
    {
      vector<int>ans;
        if(node == NULL) return ans;
        queue<Node*>q;
        q.push(node);
        while(!q.empty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                Node* curr = q.front();
                q.pop();
                if(curr->left!=NULL) q.push(curr->left);
                if(curr->right!=NULL) q.push(curr->right);
                ans.push_back(curr->data);
            }
        }
        return ans;
    }
};
