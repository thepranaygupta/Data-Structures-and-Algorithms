    //Fibonacci Series upto n numbers
    #include<iostream>
    using namespace std;
    //main program
    int main()
    {
    // initialising variables
    int limit, first=0, second=1, next, num;
    cout <<“Enter the limit of Fibonacci series”<<endl;
    // user input
    cin >> num;   
    cout << “First “<<num<<” terms of Fibonacci series are :- “<<endl;
    //loop for printing fibonacci series
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
