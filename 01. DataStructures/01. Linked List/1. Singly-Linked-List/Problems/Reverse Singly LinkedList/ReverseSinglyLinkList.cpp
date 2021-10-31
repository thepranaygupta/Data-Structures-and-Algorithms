#include <iostream>
using namespace std;

struct node
{
     int data;
     struct node *link;
};

struct node *start;

void insertBegin(int item)
{
     node *t = new node;
     t->data = item;

     // allocate memory for 1 node variable and t will be pointer to that node
     if (start == NULL)
     {
          start = t;
          t->link = NULL;
     }
     else
     {
          t->link = start;
          start = t;
     }
     cout << " inserted at begin " << item << endl;
}

void insertLast(int item)
{
     node *t = new node;
     t->data = item;
     t->link = NULL;
     if (start == NULL)
     {
          start = t;
     }
     else
     {

          node *p = start;
          while (p->link != NULL)
          {
               p = p->link;
          }
          p->link = t; // p stores adress of current last node
     }
     cout << "inserted at last " << item << endl;
}
void traverse()
{
     node *p = start;
     while (p != NULL)
     {
          cout << p->data << "-> ";
          p = p->link;
     }
     cout << "NULL" << endl;
}

void searchItem(int item)
{
     node *p = start;
     while (p != NULL)
     {
          if (item == p->data)
          {
               cout << " found " << item << endl;
               return;
          }
          else
          {
               p = p->link;
          }
     }
     cout << " not found " << endl;
}

void insertAfter(int val, int item)
{
     node *t = new node;
     t->data = item;
     if (start == NULL)
     {
          start = t;
          t->link = NULL;
     }
     else
     {
          node *p = start;
          while (p != NULL)
          {
               if (val == p->data)
               {
                    t->link = p->link;
                    p->link = t;
                    return;
               }
               else
               {
                    p = p->link;
               }
          }
     }
}

void deleteBegin()
{
     if (start == NULL)
     {
          cout << "List is empty " << endl;
          return;
     }
     else if (start->link == NULL)
     {
          node *p = start;
          start = NULL;
          delete p;
     }
     else
     {
          node *p = start;
          start = start->link;
          delete p;
     }
}
void deleteLast()
{
     if (start == NULL)
     {
          cout << "List is empty " << endl;
          return;
     }
     else if (start->link == NULL)
     {
          node *p = start;
          start = NULL;
          delete p;
     }
     else
     {
          node *p, *t;
          p = start;
          while (p->link != NULL)
          {
               t = p;
               p = p->link;
          }
          t->link = NULL;
          delete p;
     }
}

node *getMaxNode()
{
     node *t, *p;

     if (start == NULL)
     {
          return NULL;
     }
     else
     {
          p = start;
          int mx = p->data;
          t = p;
          while (p != NULL)
          {
               if (mx < p->data)
               {
                    mx = p->data;
                    t = p;
               }

               p = p->link;
          }
     }
     return t;
}

void reverseList()
{
     node *pre;
     node *curr;
     node *next;
     pre = NULL;
     curr = start;
     next = NULL;
     while (curr != NULL)

     {
          next = curr->link;
          curr->link = pre;
          pre = curr;
          curr = next;
     }
     start = pre;

     return;
}
int main()
{
     insertLast(11);
     insertBegin(20);
     insertBegin(25);
     insertBegin(30);

     traverse();
     /*searchItem(25);
     searchItem(40);
     insertLast(22);
     traverse();
     insertAfter(20,70);
     traverse();
     deleteBegin();
     traverse();
     deleteLast();
     traverse();*/
     reverseList();
     traverse();
}