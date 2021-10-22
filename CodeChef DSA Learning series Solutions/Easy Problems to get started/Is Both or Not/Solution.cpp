#include <iostream>
using namespace std;

int main() 
{
    int n;
	cin>>n;
	           
    if(n%5==0  && n%11==0)
        {
            cout<<"BOTH";
        }
    if (n%5==0 && n%11!=0 || n%11==0 && n%5!=0 )
    {
    cout<<"ONE";
	               
    }
    if(n%5!=0 && n%11!=0)
    {
        cout<<"NONE";
    }
return 0;
}
