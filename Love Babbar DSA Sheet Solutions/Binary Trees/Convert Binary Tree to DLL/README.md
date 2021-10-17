# [Binary Tree to DLL](https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1)
## Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.
### Example 1:
**Input:**
     1
    /  \
   3    2
**Output:**
3 1 2 
2 1 3 

### Example 2:
**Input:**
        10
      /   \
     20   30
   /   \
  40   60
**Output:**
40 20 60 10 30 
30 10 60 20 40

### Solution in C++:
```      
class Solution
{
    public: 
    //Function to convert binary tree to doubly linked list and return it.
    Node* dummy=new Node();
    Node* prev=NULL;
    Node* curr=dummy;
    void solve(Node* root)
    {
        if(root==NULL) return;
        solve(root->left);
        curr->right=root;
        prev=curr;
        curr=root;
        curr->left=prev;
        solve(root->right);
    }
    Node * bToDLL(Node *root)
    {
        solve(root);
        Node* ans=dummy->right;
        ans->left=NULL;
        return ans;
    }
};
```

