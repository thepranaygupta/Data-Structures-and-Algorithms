#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node *next;
};
struct node* top;

void push(int d){
    struct node* temp = new node();
    temp->data=d;
    temp->next=top;
    top=temp;
}

void pop(){
    struct node* temp;

    if(top==NULL)
    cout<<"\nStack is empty";
    else{

        temp=top; 
        top=temp->next;
        temp->next=NULL;
        free(temp);
    }
}

void display(){
    struct node* temp;

    if(top==NULL)
    cout<<"\nStack is empty";
    else
    {
        temp=top;
        while (temp!=NULL)
        {
            cout<<temp->data<<"\t";
            temp=temp->next;
        }

    }
    
}
int main(){
    push(10);
    push(20);
    display();   
}