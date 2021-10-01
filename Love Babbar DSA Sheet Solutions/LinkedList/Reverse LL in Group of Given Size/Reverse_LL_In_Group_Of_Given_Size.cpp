/*
  Reverse a linked list
  The input list will have at least one element  
  Return the node which points to the head of the new LinkedList
  Node is defined as 
    struct node
    {
        int data;
        struct node* next;
    
        node(int x){
            data = x;
            next = NULL;
        }
    
    }*head;
    
    link of question : https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
*/

class Solution
{
    public:
    struct node *reverse (struct node *head, int k)
    { 
        // Complete this method
        stack<node *> myStack;
        struct node *current = head;
        struct node *prev = NULL;
        
        while(current){
            
            int count=0;
            while(current && count<k){
                myStack.push(current);
                current=current->next;
                count++;
            }
            
            while(myStack.size() > 0){
                
                //head Node
                if(prev == NULL){
                    prev=myStack.top();
                    head=prev;
                    myStack.pop();
                }else{
                    prev->next = myStack.top();
                    prev = prev->next;
                    myStack.pop();
                }
                
            }
        }
        
        
        prev->next = NULL;
        return head;
        
        
    }
};
