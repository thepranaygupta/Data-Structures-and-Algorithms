//linked list node
/*
struct Node{
  int data;
  struct Node *next;
 }
 */ 

struct Node *reverseList(struct Node *head)
{
    struct Node *p = head;
    struct Node *q = nullptr;
    struct Node *r = nullptr;

    while (p != NULL)
    {
        r = q;
        q = p;
        p = p->next;
        q->next = r;
    }
    head = q;
    return head;
}

//time = O(n)
//space = O(1)
