#include<iostream>
using namespace std;
class node{
public:
node *next;
int data;

node(int val){
    data = val;
    next = NULL;
}

};
void insertAtTail(node* &head , int val){
        node *n = new node(val);
        if(head ==NULL){
            head = n;
            return;
        }

        node * temp = head;
        while(temp->next !=NULL){
            temp=temp->next;
        }
        temp->next=n;
  }

  void display(node * &head){
      if(head ==NULL){
          return ;
          }
          node *temp = head;
          while(temp!=NULL){
              cout<<temp->data<<endl;
              temp=temp->next;
          }
}

void insertAtHead(node *&head , int val){
    node *n = new node(val);

if(head==NULL){
    head = n;
    return ;
}
node * temp = head;
head = n;
n->next = temp;



}
node*  midOflinkedList(node * &head){
if(head==NULL || head->next==NULL){
    return head;
}
    node *fast = head;
    node *slow = head;
    while(fast->next!=NULL && fast->next->next!=NULL){
        slow = slow->next;
        fast=fast->next->next;
        }
    return slow;     
        }
signed main(){
node * head = NULL;
insertAtTail(head,1);
insertAtTail(head,2);
insertAtTail(head,2);
insertAtTail(head,1);
node* temp = midOflinkedList(head);
cout<<temp->data;
return 0;
}
