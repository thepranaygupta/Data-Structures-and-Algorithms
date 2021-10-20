#include<iostream>
using namespace std;
struct Node
{
	Node* left;
	Node* right;
	int data;
	Node(int val)
	{
		left = NULL;
		right = NULL;
		data = val;
	}
};
void preorder(Node* rt)
{
	if(rt!=NULL)
	{
		cout<<rt->data<<" ";
		preorder(rt->left);
		preorder(rt->right);
	}
}
void Mirror(Node* rt)
{
	if(rt==NULL)
		return;
	Mirror(rt->left);
	Mirror(rt->right);
	swap(rt->left,rt->right);
}
int main()
{
	Node* root = new Node(5);
	root->left = new Node(6);
	root->right = new Node(9);
	root->left->left = new Node(7);
	root->left->right = new Node(8);
	root->right->right = new Node(10);
	cout<<"PreOrder Traversal of Original Tree is "<<endl;
	preorder(root);
	Mirror(root);
	cout<<"\nPreOrder Traversal of Mirror Tree is "<<endl;
	preorder(root);
	return 0;
}
