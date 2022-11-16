#include <stdio.h>
#include <stdlib.h>
struct Node {
int key;
struct Node *left;
struct Node *right;
int height;
};
int max(int a, int b);
int height(struct Node *N) {
if (N == NULL)
return 0;
return N->height;
}
int max(int a, int b) {
return (a > b) ? a : b;
}
struct Node *newNode(int key) {
struct Node *node = (struct Node *)
malloc(sizeof(struct Node));
node->key = key;
node->left = NULL;
node->right = NULL;

node->height = 1;
return (node);
}
struct Node *rightRotate(struct Node *y) {
struct Node *x = y->left;
struct Node *z = x->right;
x->right = y;
y->left = z;
y->height = max(height(y->left), height(y->right)) + 1;
x->height = max(height(x->left), height(x->right)) + 1;
return x;
}
struct Node *leftRotate(struct Node *x) {
struct Node *y = x->right;
struct Node *z = y->left;
y->left = x;
x->right = z;
x->height = max(height(x->left), height(x->right)) + 1;
y->height = max(height(y->left), height(y->right)) + 1;
return y;
}
int getBalance(struct Node *root) {
if (root == NULL)
return 0;
return height(root->left) - height(root->right);
}
struct Node *insertNode(struct Node *node, int key) {

if (node == NULL)
return (newNode(key));
if (key < node->key)
node->left = insertNode(node->left, key);
else if (key > node->key)
node->right = insertNode(node->right, key);
else
return node;
node->height = 1 + max(height(node->left),
height(node->right));
int balance = getBalance(node);
if (balance > 1 && key < node->left->key)
return rightRotate(node);
if (balance < -1 && key > node->right->key)
return leftRotate(node);
if (balance > 1 && key > node->left->key) {
node->left = leftRotate(node->left);
return rightRotate(node);
}
if (balance < -1 && key < node->right->key) {
node->right = rightRotate(node->right);
return leftRotate(node);
}
return node;
}
struct Node *min(struct Node *node) {
struct Node *current = node;

while (current->left != NULL)
current = current->left;
return current;
}
struct Node *deleteNode(struct Node *root, int key) {
if (root == NULL)
return root;
if (key < root->key)
root->left = deleteNode(root->left, key);
else if (key > root->key)
root->right = deleteNode(root->right, key);
else {
if ((root->left == NULL) || (root->right == NULL)) {
struct Node *temp = root->left ? root->left : root->right;
if (temp == NULL) {
temp = root;
root = NULL;
} else
*root = *temp;
free(temp);
} else {
struct Node *temp = min(root->right);
root->key = temp->key;
root->right = deleteNode(root->right, temp->key);
}
}
if (root == NULL)

return root;
root->height = 1 + max(height(root->left),
height(root->right));
int balance = getBalance(root);
if (balance > 1 && getBalance(root->left) >= 0)
return rightRotate(root);
if (balance > 1 && getBalance(root->left) < 0) {
root->left = leftRotate(root->left);
return rightRotate(root);
}
if (balance < -1 && getBalance(root->right) <= 0)
return leftRotate(root);
if (balance < -1 && getBalance(root->right) > 0) {
root->right = rightRotate(root->right);
return leftRotate(root);
}
return root;
}
void printPreOrder(struct Node *root) {
if (root != NULL) {
printf("%d->", root->key);
printPreOrder(root->left);
printPreOrder(root->right);
}
}
struct Node* search (struct Node* root, int num){
if (root != NULL) {

if (num < root->key){
root = search(root->left, num);
}
else if (num > root->key) {
root = search(root->right, num);
}
}
return root;
}int bf(struct Node *root, int num){
if(root!=NULL){
if(root->key==num){
return getBalance(root);
}bf(root->left, num);
bf(root->right, num);
}
}
int main() {
int n;
struct Node *root = NULL;
printf("enter the number of elements: ");
scanf("%d", &n);
int num;
for(int i=0; i<n; i++){
printf("enter a value for the element-%d: ", i+1);
scanf("%d", &num);
root=insertNode(root, num);
}int ch;

while(1){
printf("choose an operation:\n1.insert\n2.delete\n3.search\n4.exit\n5.find balancing factor\n");
scanf("%d", &ch);
switch(ch){
case 1:
printf("enter the element's value: ");
scanf("%d", &num);
root=insertNode(root, num);
printPreOrder(root);
break;
case 2:
printf("enter the value that you want to delete: ");
scanf("%d", &num);
root=deleteNode(root, num);
printPreOrder(root);
break;
case 3:
printf("Enter element to search: ");
int num;
scanf("%d", &num);
search(root,num) ? printf("\n%d is present!\n",num) : printf("\n%d is not present!\n",num);
printPreOrder(root);
break;
case 4:
goto end;
case 5:

printf("enter the element for which you want to find the balance factor: ");
scanf("%d", &num);
printf("\n--%d--\n", bf(root, num));
default:
printf("enter a valid number\n");
}
}end:
printf("pre-order form of the tree: ");
printPreOrder(root);
return 0;
}
