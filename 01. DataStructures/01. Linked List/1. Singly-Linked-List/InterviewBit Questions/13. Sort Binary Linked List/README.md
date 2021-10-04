### Sort Binary Linked List

### https://www.interviewbit.com/problems/sort-binary-linked-list/

Problem Description

Given a Linked List A consisting of N nodes.

The Linked List is binary i.e data values in the linked list nodes consist of only 0's and 1's.

You need to sort the linked list and return the new linked list.

NOTE:

Try to do it in constant space.


```c++
ListNode* Solution::solve(ListNode* A) {
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
```
