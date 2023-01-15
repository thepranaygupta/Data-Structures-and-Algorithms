class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head==NULL){
        return false;
    }
    ListNode *slow=head;
    ListNode *fast=head->next;
    while(slow!=NULL){
        if(fast==NULL || fast->next==NULL){
            return false;
        }
        slow=slow->next;
        fast=fast->next->next;
        if(fast==slow){
            return true;
        }
    }
    return false; 
    }
};