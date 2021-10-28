#include <iostream>
using namespace std;

int main() {
	long long N,sum=0;
    
	cin>>N;
	for(int i =1 ;i<=N;i++){
	    sum = sum+i;
	}
	cout<<sum;
	return 0;
}
