// https://www.codechef.com/problems/CHGM1
// Game of Chef

#include <iostream>
using namespace std;

int kadaneAlgo(int n, int a[]){
    int maxTillNow=0, maxFinal=0;
    for(int i=0;i<n;i++){
        maxTillNow+=a[i];
        if(maxTillNow>maxFinal)
            maxFinal=maxTillNow;
        if(maxTillNow<0)
            maxTillNow=0;
    }
    return maxFinal;
}

int main(){
    int k;
    cin>>k;
    for(int i=0;i<k;i++){
        int n;
        cin>>n;
        int a[n];
        for(int j=0;j<n;j++)
            cin>>a[j];
        int sum=kadaneAlgo(n,a);
        cout<<sum<<endl;
    }
    return 0;
}
