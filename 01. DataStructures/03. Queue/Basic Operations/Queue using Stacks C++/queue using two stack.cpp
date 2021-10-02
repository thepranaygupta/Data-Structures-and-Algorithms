/* C++ Program to Implement Queue Using Two Stacks
This is a C++ Program to implement queue using stacks. n this method, in en-queue operation, the new element is entered at the top of stack1. In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
enQueue(q, x)
1) Push x to stack1 (assuming size of stacks is unlimited).
deQueue(q)
1) If both stacks are empty then error.
2) If stack2 is empty
While stack1 is not empty, push everything from satck1 to stack2.
3) Pop the element from stack2 and return it.
Here is source code of the C++ Program to Implement Queue Using Two Stacks. The C++ program is successfully compiled and run on a Linux system. */

/* Program to implement a queue using two stacks */

#include<stdio.h>
#include<stdlib.h>
#include<iostream>
 
using namespace std;
 
/* structure of a stack node */
struct sNode
{
        int data;
        struct sNode *next;
};
 
/* Function to push an item to stack*/
void push(struct sNode** top_ref, int new_data);
 
/* Function to pop an item from stack*/
int pop(struct sNode** top_ref);
 
/* structure of queue having two stacks */
struct queue
{
        struct sNode *stack1;
        struct sNode *stack2;
};
 
/* Function to enqueue an item to queue */
void enQueue(struct queue *q, int x)
{
    push(&q->stack1, x);
}
 
/* Function to dequeue an item from queue */
int deQueue(struct queue *q)
{
    int x;
 
    /* If both stacks are empty then error */
    if (q->stack1 == NULL && q->stack2 == NULL)
    {
        cout << "Queue is empty";
        exit(0);
    }
 
    /* Move elements from satck1 to stack 2 only if
     stack2 is empty */
    if (q->stack2 == NULL)
    {
        while (q->stack1 != NULL)
        {
            x = pop(&q->stack1);
            push(&q->stack2, x);
        }
    }
 
    x = pop(&q->stack2);
    return x;
}
 
/* Function to push an item to stack*/
void push(struct sNode** top_ref, int new_data)
{
    /* allocate node */
    struct sNode* new_node = (struct sNode*) malloc(sizeof(struct sNode));
 
    if (new_node == NULL)
    {
        cout << "Stack overflow \n";
        exit(0);
    }
 
    /* put in the data  */
    new_node->data = new_data;
 
    /* link the old list off the new node */
    new_node->next = (*top_ref);
 
    /* move the head to point to the new node */
    (*top_ref) = new_node;
}
 
/* Function to pop an item from stack*/
int pop(struct sNode** top_ref)
{
    int res;
    struct sNode *top;
 
    /*If stack is empty then error */
    if (*top_ref == NULL)
    {
        cout << "Stack overflow \n";
        exit(0);
    }
    else
    {
        top = *top_ref;
        res = top->data;
        *top_ref = top->next;
        free(top);
        return res;
    }
}
 
/* Driver function to test anove functions */
int main()
{
    /* Create a queue with items 1 2 3*/
    struct queue *q = (struct queue*) malloc(sizeof(struct queue));
    q->stack1 = NULL;
    q->stack2 = NULL;
    cout << "Enqueuing...";
    cout << endl;
    enQueue(q, 1);
    cout << "Enqueuing...";
    cout << endl;
    enQueue(q, 2);
    cout << "Enqueuing...";
    cout << endl;
    enQueue(q, 3);
 
    /* Dequeue items */
    cout << "Dequeuing...";
    cout << deQueue(q) << " ";
    cout << endl;
    cout << "Dequeuing...";
    cout << deQueue(q) << " ";
    cout << endl;
    cout << "Dequeuing...";
    cout << deQueue(q) << " ";
    cout << endl;
}