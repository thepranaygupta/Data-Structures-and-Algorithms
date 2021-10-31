
    #include<iostream>
    using namespace std;

    int main()
    {

    int limit, first=0, second=1, next, num;
    cout <<“Enter the limit of Fibonacci series”<<endl;

    cin >> num;   
    cout << “First “<<num<<” terms of Fibonacci series are :- “<<endl;

    for(int p=0;p<num;p++)
    {
        if (p <= 1)
            next = p;
        else
        {
            next = first + second;
            first = second;
            second = next;
        }
        cout<<next<<” “;
    }
    return 0;
    }
