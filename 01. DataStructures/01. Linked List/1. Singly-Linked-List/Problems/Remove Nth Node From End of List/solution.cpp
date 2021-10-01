/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* p = head;
        int count = 0; 
        while(p){
            count++;
            p = p->next;
        }
        
        count = count - n;
        if(count == 0){
            return head->next;
        }
        ListNode *q = head;
        ListNode *temp = head->next;
        while(count>1){
            q = temp;
            temp = temp->next;
            count--;
        }
        q->next = temp->next;
        return head;
    }
};