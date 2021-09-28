## Middle Element In Linked List
## Problem Link: https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1#

- ### Time Complexity: O(N)
- ### Auxiliary Space Complexity: O(1)

## Code Snippet:
```cpp
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
```

## Running Code:
![alt text](./output.png)
