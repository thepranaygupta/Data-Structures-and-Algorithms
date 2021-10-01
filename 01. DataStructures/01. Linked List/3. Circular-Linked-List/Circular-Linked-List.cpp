#include <iostream>
using namespace std;

class CircularLinkedList
{
public:
    class Node
    {
    public:
        int data;
        Node *next;

        Node(int d)
        {
            data = d;
            next = NULL;
        }
    };

    int size;
    Node *head;
    Node *tail;

    CircularLinkedList()
    {
        size = 0;
        head=NULL;
        tail =NULL;
    }

//1.Insert node at beginning
    public:
    void InsertNodeFirst(int val)
    {
        Node *newNode = new Node(val);
        if (tail == NULL) //is my LL empty?
        {      
           tail=newNode;
        }
        else
        {
        newNode->next = tail->next;
        }     
       tail->next=newNode;
       size++;
     }

    //2.Insert node at end
    void InsertNodeLast(int val)
    {
        Node *newNode = new Node(val);
        if (tail == NULL)
        {
            tail=newNode;
            tail->next=tail;
        }
        else
        {
           newNode->next=tail->next;
           tail->next=newNode;
           tail=newNode;
        }
        size++;
}

//3. Insert node at pos
    void InsertAtPos(int pos, int val)
    {
        Node *newNode = new Node(val);
        if (tail == NULL)
        {
            cout << "LL is already empty";
            return;
        }
        else if (pos == 1)
        {
            InsertNodeFirst(val);
        }
        else if (pos == size + 1)
        {
            InsertNodeLast(val);
        }
        else
        {
            Node *ptr =tail->next;
            for (int i = 0; i < pos - 2; i++)
            {
                ptr = ptr->next;
            }
            newNode->next = ptr->next;
            ptr->next = newNode;
            size++;
        }
    }

    // 4. Delete node first
    void DeleteNodeFirst()
    {
        if (tail == NULL)
        {
            cout << "LL is empty";
        }
        else
        {
            Node *ptr = tail->next;
            tail->next=ptr->next;
            ptr=ptr->next;
            size--;
        }
    }

    //5. Delete node last
    void DeleteNodeLast()
    {
        if (tail == NULL)
        {
            cout << "LL is empty";
            return;
        }
        else
        {
            Node *ptr = tail->next;
            while (ptr->next != tail)
            {
                ptr = ptr->next;
            }
            ptr->next=tail->next;
            tail=ptr;
            size--;
        }
    }

    //6. Delete node at pos
    void DeleteNodeAtPosition(int pos)
    {
        if (tail == NULL || pos > size || pos < 1)
        {
            cout << "Delete not possible";
            return;
        }
        else if (pos == 1)
        {
            DeleteNodeFirst();
        }
        else if (pos == size)
        {
            DeleteNodeLast();
        }
        else
        {
            Node *ptr = tail->next;
            for (int i = 0; i < pos - 2; i++)
            {
                ptr = ptr->next;
            }
            Node *temp = ptr->next;
            ptr->next = ptr->next->next;
            size--;
        }
    }

    //7. Reverse  list
    void ReverseList()
    {       
            Node* last = tail->next;
            Node *curr = tail->next;
            Node *pre = tail;
            Node* next=NULL;

            while (curr != tail)
            {
                next = curr->next;
                curr->next = pre;
                pre = curr;
                curr = next;
            }
            tail->next=pre;
            tail=last;
    }

//8. Update list
    void UpdateList(int pos, int val)
    {
        if (tail == NULL || pos >size || pos < 1)
        {
            cout << "Update not possible";
            return;
        }
        else
        {
            Node *ptr=tail->next;
            for (int i = 0; i < pos-1; i++)
            {
                ptr = ptr->next;
            }
            ptr->data = val;
        }
    }

    //9. Count/Find list size
    int CountList()
    {
        return size;
    }

    //10. Display list
    void DisplayList()
    {
        if (tail == NULL)
        {
            cout << "No list to Display";
            return;
        }
        Node *ptr = tail->next;
        while (ptr != tail)
        {
            cout << ptr->data << " ---->";
            ptr = ptr->next;
        }
        cout <<ptr->data;
    }
};

int main()
{
    CircularLinkedList Sl;
    int ch;
    int pos, val;
    do
    {
        cout << "\n *******MENU*******\n"
             << endl;
        cout << "1______ Insert Node at First." << endl;
        cout << "2______Insert Node at the Last." << endl;
        cout << "3______Insert Node at any given position." << endl;
        cout << "4______Delete Node at first." << endl;
        cout << "5______Delete Node at last." << endl;
        cout << "6______Delete Node at any given position." << endl;
        cout << "7______Reverse the List." << endl;
        cout << "8______Update a Node." << endl;
        cout << "9______Count the List." << endl;
        cout << "10______Display the List." << endl;
        cout << "0.....EXIT." << endl;
        cout << "\nEnter your choice : ";
        cin >> ch;

        switch (ch)
        {
        case 0:
            cout << "\nEnd of Program" << endl;
            break;
        case 1:
            cout << "Enter value: ";
            cin >> val;
            Sl.InsertNodeFirst(val);
            break;
        case 2:
            cout << "Enter value: ";
            cin >> val;
            Sl.InsertNodeLast(val);
            break;
        case 3:
            cout << "Enter pos: ";
            cin >> pos;
            cout << "Enter value: ";
            cin >> val;
            Sl.InsertAtPos(pos, val);
            break;
        case 4:
            Sl.DeleteNodeFirst();
            break;
        case 5:
            Sl.DeleteNodeLast();
            break;
        case 6:
            cout << "Enter pos: ";
            cin >> pos;
            Sl.DeleteNodeAtPosition(pos);
            break;
        case 7:
            Sl.ReverseList();
            break;
        case 8:
            cout << "Enter pos: ";
            cin >> pos;
            cout << "Enter val: ";
            cin >> val;
            Sl.UpdateList(pos, val);
            break;
        case 9:
            cout << Sl.CountList();
            break;
        case 10:
            Sl.DisplayList();
            break;
        default:
            cout << "\nInvalid Input!!" << endl;
            break;
        }
    } while (ch != 0);

    return 0;

};
