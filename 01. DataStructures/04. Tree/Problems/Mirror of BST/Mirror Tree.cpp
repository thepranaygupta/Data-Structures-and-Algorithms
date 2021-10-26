#include<bits/stdc++.h>
using namespace std;

class Node
{
    public :
    int data ;
    Node *left, *right ;
    Node(int input)
    {
        data = input ;
        left = right = NULL ;
    }
}*root = NULL , *temp ;

int maxDepth=0;
void create(int input)
{
    Node *new_node = new Node(input) ; 
    
    if(root == NULL) root = new_node ;
    
    else
    {
        temp = root ;
        while(true)
        {
            if(input<temp->data && temp->left == NULL)
            {
                temp->left = new_node ;
                break ;
            }
            else if(input>temp->data && temp->right == NULL)
            {
                temp->right = new_node ;
                break ;
            }
            else if(input<temp->data)
                temp = temp->left ;
            
            else if(input>temp->data)
                temp = temp->right ;
        }
    }
}

void inorder(Node *temp)
{
    if(temp == NULL) return ;
    
    inorder(temp->left) ;
    cout << temp->data << ' ' ;
    inorder(temp->right) ;
}

void postorder(Node *temp)
{
    if(temp == NULL) return ;
    
    postorder(temp->left) ;
    postorder(temp->right) ;
    cout << temp->data << ' ' ;
}

void preorder(Node *temp)
{
    if(temp == NULL) return ;
    
    cout << temp->data << ' ' ;
    preorder(temp->left) ;
    preorder(temp->right) ;
}

void mirror(Node *temp){
	if(temp==NULL) return;
	
	Node *swap=temp->left;
	temp->left=temp->right;
	temp->right=swap;
	mirror(temp->left);
	mirror(temp->right);
}

int main()
{
    int n ;
    
    while(true)
    {
        cin >> n ; 
        if(n<1) break ;
        create(n) ;
    }
    
    cout << "\n\nOriginal Preorder : " ;
    preorder(root) ;
    
    mirror(root);
    
    cout << "\n\nMirrored Preorder : " ;
    preorder(root) ;
    
    return 0 ;
}
