#include<iostream>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
};
ListNode* solve(ListNode* A) {
    if(A==NULL||A->next==NULL){
        return A;
    }
    ListNode* count = A;
    ListNode* curr = A;
    
    while(curr!=NULL){
        if(curr->val!=1){
            swap(curr->val , count->val);
            count = count->next;
        }
        curr = curr->next;
    }
   

    return A;
}
int main(){
    int t;
    cin>>t;
    ListNode* n = NULL;
    ListNode* head = NULL;
    while(t--){
        int x;
        cin>>x;
    if(n==NULL)
    {
        
        n = new ListNode();
        head = n;
        n->val = x;
        n->next = NULL;
    }
    else{
        
        n->next = new ListNode();
        n = n->next;
        n->val = x;
        n->next = NULL;
    }
    }
    
    n = solve(head);
    while(n!=NULL){
        cout<<n->val<<" ";
        n = n->next;        
    }
    return 0;

}
