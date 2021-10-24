## Mirror of Tree
In this, we need to find and print the `mirror` of a tree.

## Approach
- We create a recursive function that takes two arguments.
- One is the original Tree and other is the newly created Tree.
- Structure of Node is
```c++
typedef struct Node {
  int val;
  struct Node* left;
  struct Node* right;
} Node;
```
- For every passed `Node` of the original tree, create a corresponding `Node` and now recursively call the same method for the child nodes.
- But, pass the `left` child of the original tree with the `right` child tree of the mirror tree and vice-versa.

- Here is the Mirrorify Function
```c++
// Mirror Function
void mirrorify(Node* root, Node** mirror) {
  if (root == NULL) {
    mirror = NULL;
    return;
  }

  // Create new mirror node from original tree node
  *mirror = createNode(root->val);
  mirrorify(root->left, &((*mirror)->right));
  mirrorify(root->right, &((*mirror)->left));
}
```

- It uses Inorder Traversal as the default traversal function
```c++
// Inorder Traversal
void inorder(Node* root) {
  if (root == NULL) {
    return;
  }

  inorder(root->left);
  cout << " " << root->val;
  inorder(root->right);
}
```
