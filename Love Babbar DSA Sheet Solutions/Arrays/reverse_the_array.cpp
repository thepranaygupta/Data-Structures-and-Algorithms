// Sample Input 01:
// Geeks
// Sample Output:
// skeeG

// Sample Input 02:
// for
// Sample Output:
// rof

//Initial Template for C++
#include<bits/stdc++.h>
using namespace std;

string reverseWord(string str);

int main() {	
	int t;
	cin>>t;
	while(t--){
        string s;
        cin >> s;
        
        cout << reverseWord(s) << endl;
	}

	return 0;
}
// } Driver Code Ends

//User function Template for C++
void swap(char &ch1, char &ch2){
    char temp = ch1;
    ch1 = ch2;
    ch2 = temp;
}

// function to reverse the array.
string reverseWord(string str){
  for(int i = 0; i  < str.length()/2; i++){
      swap(str[i], str[str.length()-i-1]);
  }
  return str;
}