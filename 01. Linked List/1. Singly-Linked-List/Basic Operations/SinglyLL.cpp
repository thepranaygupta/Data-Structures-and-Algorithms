#include <iostream>
#include <malloc.h>
#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int val;
    Node *next;
};
Node *start = NULL, *temp, *node, *ptr;

void CreateList()
{
    temp = new Node();
    cout << "Enter value : ";
    cin >> temp->val;
    temp->next = NULL;
    if (start == NULL)
    {
        start = temp;
        node = temp;
    }
    else
    {
        node->next = temp;
        node = temp;
    }
}

void DisplayList()
{
    temp = start;
    while (temp != NULL)
    {
        cout << temp->val << " -> ";
        temp = temp->next;
    }
    cout << endl;
}

void InsertBeg()
{
    temp = new Node();
    cout << "Enter value : ";
    cin >> temp->val;
    temp->next = start;
    start = temp;
}

void InsertEnd()
{
    temp = new Node();
    cout << "Enter the value : ";
    cin >> temp->val;
    ptr = start;
    while (ptr->next != NULL)
    {
        ptr = ptr->next;
    }
    ptr->next = temp;
    temp->next = NULL;
}

void InsertAfter()
{
    int n, c = 1;
    temp = start;
    cout << "Enter position : ";
    cin >> n;
    while (c != n)
    {
        temp = temp->next;
        c++;
    }
    ptr = new Node();
    cout << "Enter value : ";
    cin >> ptr->val;
    ptr->next = temp->next;
    temp->next = ptr;
}

void InsertBefore()
{
    int n;
    cout << "Enter the Element Before You Want to Insert : ";
    cin >> n;
    temp = start;
    while (temp->next->val != n)
    {
        temp = temp->next;
    }
    ptr = new Node();
    cout << "Enter value : ";
    cin >> ptr->val;
    ptr->next = temp->next;
    temp->next = ptr;
}

void SearchNode()
{
    int n, c = 1, flag = 0;
    cout << "Enter element to search : ";
    cin >> n;
    temp = start;
    while (temp != NULL)
    {
        if (temp->val == n)
        {
            flag = 1;
            break;
        }
        temp = temp->next;
        c++;
    }
    if (flag == 1)
        cout << "Element found at " << c << " position\n";
    else
        cout << "Element not found\n";
}
void DeleteFirst()
{
    temp = start;
    start = temp->next;
}

void DeleteLast()
{
    temp = start;
    while(temp->next->next!=NULL)
    {
        temp = temp->next;
    }
    temp->next = NULL;
}
// // // // // // // // // // // // void DeleteLast()
// {
//     temp = start;
//     Node *SecondLast;
//     SecondLast = temp->next;
//     while (temp->next != NULL)
//     {
//         temp = temp->next;
//     }
//     SecondLast->next = NULL;
// }

void DeletePos()
{
    int n, c = 1;
    cout << "Enter position : ";
    cin >> n;
    temp = start;
    while (c != n - 1)
    {
        temp = temp->next;
        c++;
    }
    temp->next = temp->next->next;
}

void DeleteVal()
{
    int n;
    cout << "Enter value to delete : ";
    cin >> n;
    temp = start;
    while (temp->next->val != n)
    {
        temp = temp->next;
    }
    temp->next = temp->next->next;
}

void UpdateNode()
{
    temp = start;
    int val, count = 1,newvalue;
    cout << "Enter the value : ";
    cin >> val;
    while (temp->val != val)
    {
        temp = temp->next;
        count++;
    }
    cout<<"Enter the new value : ";
    cin>>newvalue;
    temp -> val = newvalue;
}

void ReverseList()
{
    
}

int main()
{
    int ch;
    do
    {
        cout << "\n...M.E.N.U...\n";
        cout << "1...Create List.\n";
        cout << "2...Display List.\n";
        cout << "3...Insert at beginning.\n";
        cout << "4...Insert at the end.\n";
        cout << "5...Insert after specific position.\n";
        cout << "6...Insert before a given node.\n";
        cout << "7...Search an element.\n";
        cout << "8...Delete first element.\n";
        cout << "9...Delete last element.\n";
        cout << "10...Delete any position.\n";
        cout << "11...Delete any value.\n";
        cout << "12...Update a node.\n";
        cout << "13...Reverse the List.\n";
        cout << "0...EXIT.\n";
        cout << "\nEnter your choice : ";
        cin >> ch;
        switch (ch)
        {
        case 0:
            printf("\nEnd of Program\n");
            break;
        case 1:
            CreateList();
            break;
        case 2:
            DisplayList();
            break;
        case 3:
            InsertBeg();
            break;
        case 4:
            InsertEnd();
            break;
        case 5:
            InsertAfter();
            break;
        case 6:
            InsertBefore();
            break;
        case 7:
            SearchNode();
            break;
        case 8:
            DeleteFirst();
            break;
        case 9:
            DeleteLast();
            break;
        case 10:
            DeletePos();
            break;
        case 11:
            DeleteVal();
            break;
        case 12:
            UpdateNode();
            break;
        case 13:
            ReverseList();
            break;
        default:
            cout << "\nInvalid Input!!\n";
            break;
        }
    } while (ch != 0);
    return 0;
}