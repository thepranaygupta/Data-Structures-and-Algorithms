/**
* Create a new Binary Tree which is a mirror image of the tree
*
* Approach:
- Write a recursive function that takes two nodes as arg.
- For every passed node of the original tree, create a corresponding node
  in the Mirror Tree. Just change as when passing the recursive call for the child
  nodes, pass left child of the tree with right child of the mirror node.
*/

#include <iostream>

typedef struct Node {
  int val;
  struct Node* left;
  struct Node* right;
} Node;

Node* createNode(int val) {
  Node* newNode = (Node*)malloc(sizeof(Node));
  newNode->val = val;
  newNode->left = NULL;
  newNode->right = NULL;
}

// Inorder Traversal
void inorder(Node* root) {
  if (root == NULL) {
    return;
  }

  inorder(root->left);
  cout << " " << root->val;
  inorder(root->right);
}

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

int main() {
  Node* tree = createNode(5);
  tree->left = createNode(3);
  tree->right = createNode(6);
  tree->left->left = createNode(2);
  tree->left->right = createNode(4);

  // Print inorder traversal
  cout << "InOrder of Original Tree: ";
  inorder(tree);
  Node* mirror = NULL;

  // Print Mirror Tree
  cout << "\nInorder Traversal of Mirror Tree";
  inorder(mirror);

  return 0;
}
