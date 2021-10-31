#include <iostream>
using namespace std;

int main()
{
    int a, b, c;
    cin >> a >> b >> c;
    if (a + b < c  a + c < b  b + c < a)
        cout << "NO";
    else
        cout << "YES";
    return 0;
}