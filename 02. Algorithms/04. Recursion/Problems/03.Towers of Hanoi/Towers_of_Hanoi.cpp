#include<iostream>
using namespace std;
void toh(int n,char sou,char aux,char des);
int main(){
	int n;
	cout<<"enter the number of disks "<<endl;
	cin>>n;
	toh(n,'A','B','C');
	return 0;
}
void toh(int n,char sou,char aux,char des){
	if (n==1)
	{
		cout<<"move disk "<<n<<" from "<<sou<<" to "<<des<<" "<<endl;
	}
	else
	{
		toh(n-1,sou,des,aux);
		cout<<"move disk "<<n<<" from "<<sou<<" to "<<des<<" "<<endl;
		toh(n-1,aux,sou,des);
	}
	
}
