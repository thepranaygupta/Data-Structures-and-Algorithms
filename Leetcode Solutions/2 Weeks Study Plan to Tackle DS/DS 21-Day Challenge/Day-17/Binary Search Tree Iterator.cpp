class BSTIterator {
public:
     stack<TreeNode*> st;
    BSTIterator(TreeNode *root) {
        Lefttree(root);
    }
    bool hasNext() {
    return st.empty() ? false : true;
    }
    int next() {
        TreeNode* top = st.top();
        st.pop();
        if (top->right += NULL)
            Lefttree(top->right);  
     return top->val;
    }
    void Lefttree(TreeNode* root)
    {
        TreeNode* p = root;
        while (p)
        {
            st.push(p);
            p = p->left;
        }
    }
};