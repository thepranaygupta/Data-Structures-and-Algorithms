#include <iostream>
using namespace std;
template <typename T>
class Node
{
private:
    T data;
    Node<T> *next;
    template <typename U>
    friend class LinkedList;
public:
    Node()
    {
        this->next = NULL;
    }
};
template <typename T>
class LinkedList
{
public:
    Node<T> *head;
public:
    LinkedList()
    {
        this->head = NULL;
    }

    void createNode(T elem)
    {
        Node<T> *node = new Node<T>[1];
        node->data = elem;
        if (head == NULL)
        {
            head = node;
            cout << "new node added(firstnode) !\n";
            return;
        }
        Node<T> *temp = head;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        cout << "new node added at back!\n";
        temp->next = node;
    }

    void addFront(T elem)
    {
        Node<T> *node = new Node<T>[1];
        node->data = elem;
        if (head == NULL)
        {
            head = node;
            cout << "new node added(firstnode) !\n";
            return;
        }
        node->next = head;
        head = node;
        cout << "new node added at Begning !\n";
    }
    void add(int i, T elem)
    {
        if (i > length() || i < 0)
        {
            cout << "i out of bound !\n";
            return;
        }
        Node<T> *node = new Node<T>[1];
        node->data = elem;
        int count = 0;
        Node<T> *temp = head;
        while (temp != NULL && count < i)
        {
            if (count == i - 1)
            {
                if (temp->next != NULL)
                {
                    node->next = temp->next;
                }
                temp->next = node;
                cout << "new node added at i " << i << " !\n";
                break;
            }
            count++;
            temp = temp->next;
        }
    }
    int length()
    {
        int len = 0;
        Node<int> *temp = head;
        while (temp != NULL)
        {
            len++;
            temp = temp->next;
        }
        return len;
    }
    void displayAll()
    {
        if (head == NULL)
        {
            cout << "linked list is empty\n";
            return;
        }
        Node<T> *temp = head;
        while (temp != NULL)
        {
            cout << temp->data << "--->";
            temp = temp->next;
        }
    }
    void remove(int i)
    {
        if (head == NULL)
        {
            cout << "linked list is empty !\n";
            return;
        }
        if (i >= length() || i < 0)
        {
            cout << "i out of bound !\n";
            return;
        }
        if (i == 0)
        {
            removeFront();
            cout << "elem removed at i " << i << "\n";
            return;
        }

        int count = 0;
        Node<T> *temp = head;
        while (temp != NULL)
        {
            if (count == i - 1)
            {
                temp->next = temp->next->next;
                cout << "elem removed at i " << i << "\n";
                break;
            }
            count++;
            temp = temp->next;
        }
    }
    void removeFront()
    {
        if (head == NULL)
        {
            cout << "linked list is empty !\n";
            return;
        }
        head = head->next;
        cout << "Begning elem removed\n";
    }
    void concatenate(Node<T> *list)
    {
        Node<T> *temp = head;
        Node<T> *temp1 =list;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = temp1;
    }
};
int main()
{
    LinkedList<int> list1, list2;
    int ch, elem, i;
    bool quit = false;
    do
    {
        cout << "\n-----------------select option------------ :\n";
        cout << "1: Add node to List A\n";
        cout << "2: insert Begning\n";
        cout << "3: insert at i\n";
        cout << "4: display\n";
        cout << "5: delete Begning\n";
        cout << "6: delete at i\n";
        cout << "7  Add node to List B\n";
        cout << "8  Concatinate List A & B\n";
        cout << "9: exit";
        cout << "\n---------------------------------------- --: \n";
        cin >> ch;
        switch (ch)
        {
        case 1:
            cout << "enter elem to insert:\n";
            cin >> elem;
            list1.createNode(elem);
            break;
        case 2:
            cout << "enter elem to insert:\n";
            cin >> elem;
            list1.addFront(elem);
            break;
        case 3:
            cout << "enter elem to insert:\n";
            cin >> elem;
            cout << "enter i:\n";
            cin >> i;
            list1.add(i, elem);
            break;
        case 4:
            list1.displayAll();
            break;
        case 5:
            list1.removeFront();
            break;
        case 6:
            cout << "enter i:\n";
            cin >> i;
            list1.remove(i);
            break;
        case 7:
            cout << "enter elem to insert:\n";
            cin >> elem;
            list2.createNode(elem);
            break;
        case 8:
            list1.concatenate(list2.head);
            cout<<"Concatenated List\n";
            list1.displayAll();
            break;
        case 9:
            quit = true;
            break;
        default:
            cout << "invalid selection\n";
            break;
        }
    } while (!quit);
    return 0;
}
