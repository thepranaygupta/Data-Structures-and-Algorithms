#include <bits/stdc++.h>
using namespace std;
 
// A linked list node class is being created here
class Node
{
    public:
    int data;
    Node* next;
    Node* prev;
};

/* Given a reference (pointer to pointer) to the head
of a DLL and an int, appends a new node at the end */
void append(Node** head_ref, int new_data)
{
    /* 1. allocate node */
    Node* new_node = new Node();
 
    Node* last = *head_ref;
 
    /* 2. put in the data */
    new_node->data = new_data;
 
    /* 3. This new node is going to be the last node, so
        make next of it as NULL*/
    new_node->next = NULL;
 
    /* 4. If the Linked List is empty, then make the new
        node as head */
    if (*head_ref == NULL)
    {
        new_node->prev = NULL;
        *head_ref = new_node;
        return;
    }
 
    /* 5. Else traverse till the last node */
    while (last->next != NULL)
        last = last->next;
 
    /* 6. Change the next of last node */
    last->next = new_node;
 
    /* 7. Make last node as previous of new node */
    new_node->prev = last;
 
    return;
}

void printList(Node* node)
{
    Node* last;
    cout<<"\nTraversal in forward direction \n";
    while (node != NULL)
    {
        cout<<" "<<node->data<<" ";
        last = node;
        node = node->next;
    }
 
    cout<<"\nTraversal in reverse direction \n";
    while (last != NULL)
    {
        cout<<" "<<last->data<<" ";
        last = last->prev;
    }
}

int main()
{
    /* Starting with empty list */
    Node* head = NULL;
 
    // Insert 6. So linked list becomes 6->NULL
    append(&head, 6);
 
    // Insert 7 at the beginning. So
    // linked list becomes 7->6->NULL
    push(&head, 7);
 
    // Insert 1 at the beginning. So
    // linked list becomes 1->7->6->NULL
    push(&head, 1);
 
    // Insert 4 at the end. So linked
    // list becomes 1->7->6->4->NULL
    append(&head, 4);
 
    // Insert 8, after 7. So linked
    // list becomes 1->7->8->6->4->NULL
    insertAfter(head->next, 8);
 
    cout << "Created DLL is: ";
    printList(head);
 
    return 0;
}