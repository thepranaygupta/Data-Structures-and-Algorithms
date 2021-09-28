//Initial template for C++
#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    struct Node* next;    
    Node(int x){
        data = x;
        next = NULL;
    }
};

void printList(Node* node) { 
    while (node != NULL) { 
        if(node->next)
            cout<< node->data <<"->";
        else
            cout<< node->data << "->NULL";
        node = node->next; 
    }  
    cout<<"\n";
} 

// } Driver Code Ends
/* 
Link list Node 
struct Node {
    int data;
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }    
}; 
*/

class Solution{
    public:
    /* Should return data of middle node. If linked list is empty, then  -1*/
    int getMiddle(Node *head){
        Node* slow = head;
        Node* fast = head;
        
        while(fast != NULL and fast->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow->data;
    }
};

// { Driver Code Starts.
int main() {
    //code
    int t;
    cout<< "Enter number of test cases you want to execute: "<< endl;
    cin>> t;
    int c = 0;
    while(t--){
        c++;
        int N;
        cout<< "\nEnter node in LL for tese case: "<< c<< endl;
        cin>> N;
        int data;
        cin>> data;
        struct Node *head = new Node(data);
        struct Node *tail = head;
        for (int i = 0; i < N-1; ++i){
            cin>> data;
            tail->next = new Node(data);
            tail = tail->next;
        }
        
        cout<< "\nLinked List for text case "<< c<< " is :"<< endl;
        printList(head);
        
        Solution ob;
        cout<< "\nMiddle element of LL is: "<< ob.getMiddle(head)<< endl;
    }
    return 0;
}
// } Driver Code Ends