#include <iostream>
#include <bits/stdc++.h>
using namespace std;

class Stack_Queue
{

    queue<int> q1, q2;
    int size;

public:
    Stack_Queue()
    {
        size = 0;
    }

    bool empty()
    {
        return q1.empty();
    }

    void push(int val)
    {
        // Push val first in empty q2
        q2.push(val);
        // Push all the remaining from q1 to q2.
        while (!q1.empty())
        {
            q2.push(q1.front());
            q1.pop();
        }
        //swap the two queues
        queue<int> temp = q1;
        q1 = q2;
        q2 = temp;
        size++;
    }

    void pop()
    {

        if (q1.empty())
            return;
        q1.pop();
        size--;
    }

    // get the top data element of the stack , without removing it.
    int top()
    {
        if (q1.empty())
            return 0;
        return q1.front();
    }

    int count()
    {
        return size;
    }

    void display()
    {
        queue<int> temp = q1;

        while (!temp.empty())
        {
            cout << temp.front() << " " << endl;
            temp.pop();
        }
        cout << "\n";
    }
};

int main()
{
    Stack_Queue s1;
    int option, val;

    do
    {
        cout << "What operation do you want to perform? Select Option number. Enter 0 to exit." << endl;
        cout << "1. empty()" << endl;
        cout << "2. Push()" << endl;
        cout << "3. Pop()" << endl;
        cout << "4. count()" << endl;
        cout << "5. top()" << endl;
        cout << "6. display()" << endl;
        cout << "7. Clear Screen" << endl
             << endl;

        cin >> option;
        switch (option)
        {
        case 0:
            cout << "End of program" << endl;
            break;

        case 1:
            if (s1.empty())
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
            s1.pop();

            break;

        case 4:
            cout << "No. of items in stack:" << s1.count() << endl;
            break;

        case 5:
            cout << "show the top Value  " << s1.top() << endl;
            break;

        case 6:
            cout << "View stack: " << endl;
            s1.display();
            break;

        case 7:
            system("cls");
            break;

        default:
            cout << "Enter Proper Option number " << endl;
        }

    } while (option != 0);

    return 0;
}
