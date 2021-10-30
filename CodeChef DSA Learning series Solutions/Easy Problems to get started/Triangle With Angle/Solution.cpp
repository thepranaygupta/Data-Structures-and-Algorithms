#include <iostream>
using namespace std;

int main() {

    int a,b,c;
    cin>>a>>b>>c;
    if(a+b+c==180&& a>0 && b>0 && c>0){
        cout<<"YES";
    }
    else{
    cout<<"NO";
    }
    return 0;
}