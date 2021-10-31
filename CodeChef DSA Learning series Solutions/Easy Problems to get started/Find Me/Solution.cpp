#include <iostream>
using namespace std;

int main() {
	// your code goes here
	int n,k,count=0,p=0;
	cin>>n>>k;
	int a[n];
	for(int i=0;i<n;i++){
	    cin>>a[i];
	}
	for(int i=0;i<n;i++){
	    if(a[i]==k){
	        count++;
	        }
	   else{
	       p++;
	   }
	}
	if(count>0){
	    cout<<"1";
	}
	else if(p>0){
	    cout<<"-1";
	    
	}
	return 0;
}
