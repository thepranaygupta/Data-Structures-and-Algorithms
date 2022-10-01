#include <iostream>
using namespace std;

struct node
{
    int data;
    node *next;
    node()
    {
        data = 0;
        next = NULL;
    }
};

// Function to print the linked list starting from head pointer
void print(node *head)
{
    while (head != NULL)
    {
        cout << head->data << " ";
        head = head->next;
    }
    cout << '\n';
}

// Function to calculate the mid point of linked list
node * tortoiseAndHareApproach(node *head)
{
    node* slow = head;
    node* fast = head->next;
    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = (fast->next)->next;
    }
    // slow must be pointing at the middle element of the list
    return slow;
}

// Function to take two sorted linked lists and merge them
// to form a sorted resultant linked list
node * merge(node *left, node *right)
{

    // creating an auxiliary head node storing the 

    // the head of the linked list to be returned and 

    // another pointer to remember where the last 

    // added node was
    node *dummyHead = new node();
    node *current = dummyHead;
    
    while (left != NULL && right != NULL)
    {
        if (left->data <= right->data)
        {
            current-> next = left;
            left = left->next;
            current = current-> next;
        }
        else if (right->data < left->data)
        {
            current->next = right;
            right = right->next;
            current = current->next;
        }
    }
    while (left != NULL)
    {
        current->next = left;
        left = left->next;
        current = current->next;
    }
    while (right != NULL)
    {
        current->next = right;
        right = right->next;
        current = current->next;
    }
    return dummyHead->next;
}

// Function to recursively  divide the linked list
node * mergeSort(node *start)
{
    if (start -> next == NULL)
    {
        // only 1 element in current list
        // so return it as it is
        return start;
    }
    // finding middle of the list using
    // the tortoise and hare approach
    node *mid = tortoiseAndHareApproach(start);
    node *start_of_right = mid->next;

    // breaking the linked list into two parts
    mid->next = NULL;

    node *left = mergeSort(start);
    node *right = mergeSort(start_of_right);

    node *new_head = merge(left, right);

    return new_head;
}


// Function to push a node at the front of linked list
void push(int val, node **ptr_to_head)
{
    // create a new node
    node *temp = new node();
    // assigning value to be inserted to the new node
    temp->data = val;
    // making the link between new node and the head of the linked list
    temp->next = *ptr_to_head;
    // making new node the head of the linked list
    *ptr_to_head = temp;
}

// Driver Code
int main()
{
    node* head = NULL;
    push(7, &head);

    push(8, &head);

    push(2, &head);

    push(3, &head);

    push(6, &head);
    push(1, &head);
    push(4, &head);
    push(5, &head);
    cout << "Linked list before sorting:" << '\n';
    print(head);
    head = mergeSort(head);
    cout << "Linked list after sorting:" << '\n';
    print(head);
}