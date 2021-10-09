#include<iostream>
#include<vector>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
};
int lPalin(ListNode* A) {
        //ListNode* front = A;
        ListNode* rear = A;
        vector<int> v;
        while(rear!=NULL){
        v.push_back(rear->val);
        rear = rear->next;
        }
        for(int i = v.size()-1;i>=0;i--){
            if(v[i]!=A->val)
            return 0;
            A = A->next;
        }
        return 1;
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
    if(lPalin(head))
    cout<<"list is a palindrome"<<endl;
    else
    cout<<"list is not a palindrome"<<endl;
    return 0;

}
