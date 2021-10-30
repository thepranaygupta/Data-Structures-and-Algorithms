#include <iostream>
using namespace std;

int main() {
    int n;
    cin>>n;
    int sumi = 0, sumj = 10;
    for(int i=1; i<=n; i++){
        if(i%2!=0){
            for(int j=sumi+1; j<=sumi+5; j++){
                cout<<j<<" ";
            }
            cout<<endl;
            sumi = sumi + 10;
        }else{
            for(int j=sumj; j>=sumj-4; j--){
                cout<<j<<" ";
            }
            cout<<endl;
            sumj = sumj + 10;
        }
    }
    return 0;
}