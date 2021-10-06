/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

//First Approach by using unordered map 
//TC - O(n)
//SC- O(n)
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if(head == NULL)
            return false;
        ListNode* temp = head;
        unordered_set<ListNode*>st;
        while(temp and st.find(temp)==st.end()){
            st.insert(temp);
            temp=temp->next;
            if(temp == NULL)
                return false;
        }
        return true;
    }
};

//Second Approach two pointer approach
//TC - O(n)
//SC- O(1)
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if (!head) 
            return false;
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) 
                return true;
        }
        return false;
    }
};

