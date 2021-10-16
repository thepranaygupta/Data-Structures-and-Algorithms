// https://leetcode.com/problems/unique-paths/

#include<iostream>
using namespace std;

int factorial(int n){
    if(n==1 || n==0)
        return 1;
    return n*factorial(n-1);
}

int main(){
    int n,m;
    cin>>n>>m;
    cout<<(factorial(n+m-2))/(factorial(n-1)*factorial(m-1));
    return 0;
}
