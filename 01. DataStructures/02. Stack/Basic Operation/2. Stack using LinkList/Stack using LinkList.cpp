#include <iostream>
using namespace std;

class StackLinkedList
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

    Node *top;
    int size;

    StackLinkedList()
    {
        top = NULL;
        size = 0;
    }



    bool isEmpty()
    {
        return top == NULL;
    }

    void push(int val)
    {
        Node *ptr = new Node(val);
        ptr->next = top;
        top = ptr;
        size++;
    }

    int pop()
    {
        if (isEmpty())
        {
            cout << "Stack Underflow i.e Stack is Empty" << endl;
            return 0;
        }
        int result = top->data;
        top = top->next;
        size--;
        return result;
    }

    int count()
    {
        return size;
    }

    //this will return top value of stack
    int peek(int pos)
    {
        if (isEmpty())
        {
            cout << "Stack Underflow i.e Stack is Empty" << endl;
            return 0;
        }
        return top->data;
    }

    void updateValue(int pos, int val)
    {
        if (pos > count())
        {
            cout << "Stack Overflow" << endl;
        }
        else
        {
            Node *ptr = top;
            for (int i = 0; i < pos - 1; i++)
            {
                ptr = ptr->next;
            }
            ptr->data = val;
        }
    }

    void display()
    {
        Node *ptr = top;
        if (isEmpty())
        {
            cout << "Stack is Empty" << endl;
            return;
        }
        while (ptr != NULL)
        {
            cout << ptr->data << endl;
            ptr = ptr->next;
        }
    }
};

int main()
{
    StackLinkedList s1;
    int option, pos, val;

    do
    {
        cout << "What operation do you want to perform? Select Option number. Enter 0 to exit." << endl;
        cout << "1. isEmpty()" << endl;
        cout << "2. Push()" << endl;
        cout << "3. Pop()" << endl;
        cout << "4. count()" << endl;
        cout << "5. peek()" << endl;
        cout << "6. updateValue()" << endl;
        cout << "7. display()" << endl;
        cout << "8. Clear Screen" << endl
             << endl;

        cin >> option;
        switch (option)
        {
        case 0:
            cout << "End of program" << endl;
            break;

        case 1:
            if (s1.isEmpty())
                cout << "Stack is Empty" << endl;
            else
                cout << "Stack is not Empty" << endl;
            break;

        case 2:
            cout << "Enter value: " << endl;
            cin >> val;
            s1.push(val);
            break;

        case 3:
            cout << "Popped value: " << s1.pop() << endl;
            break;

        case 4:
            cout << "No. of items in stack:" << s1.count() << endl;
            break;

        case 5:
            cout << "Enter pos: " << endl;
            cin >> pos;
            cout << "peek(show) the Value at  " << pos << " is : " << s1.peek(pos) << endl;
            break;

        case 6:
            cout << "Enter pos: ";
            cin >> pos;
            cout << "Enter val: ";
            cin >> val;
            s1.updateValue(pos, val);
            break;

        case 7:
            cout << "View stack: " << endl;
            s1.display();
            break;

        case 8:
            system("cls");
            break;

        default:
            cout << "Enter Proper Option number " << endl;
        }

    } while (option != 0);

    return 0;
}
