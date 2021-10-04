#include<iostream>
using namespace std;
 
struct Node {
    int key;
    Node *left, *right;
};

Node* newNode(int key)
{
    Node* node = new Node;
    node->key = key;
    node->left = node->right = NULL;
    return (node);
}

void flatten(struct Node* root)
{
    if (root == NULL || root->left == NULL &&
                        root->right == NULL) {
        return;
    }

    if (root->left != NULL) {

        flatten(root->left);

        struct Node* tmpRight = root->right;
        root->right = root->left;
        root->left = NULL; 
        struct Node* t = root->right;
        while (t->right != NULL) {
            t = t->right;
        }
        t->right = tmpRight;
    }
    flatten(root->right);
}
 
void inorder(struct Node* root)
{
    if (root == NULL)
        return;
    inorder(root->left);
    cout << root->key << " ";
    inorder(root->right);
}

int main()
{
    /*    1
        /   \
       2     5
      / \     \
     3   4     6 */
    Node* root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(5);
    root->left->left = newNode(3);
    root->left->right = newNode(4);
    root->right->right = newNode(6);
 
    flatten(root);
 
    cout << "The Inorder traversal after "
            "flattening binary tree ";
    inorder(root);
    return 0;
}
