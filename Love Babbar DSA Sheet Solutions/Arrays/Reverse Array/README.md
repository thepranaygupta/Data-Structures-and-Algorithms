# [Reverse Array](https://practice.geeksforgeeks.org/problems/reverse-a-string/1)
# You are given a string s. You need to reverse the string.

# Example 1:

# Input:
s = Geeks

# Output: skeeG
# Example 2:

# Input:
s = for
# Output: rof

```java
public static void main(String[] args) {
	int arr[]= {1,3,5,6,7,12,15};
	int n=arr.length;
	reverseArr(arr,0,n-1);
	System.out.println(Arrays.toString(arr));
}
static void reverseArr(int arr[],int s,int e) {
	if(s>=e) return;
	int temp=arr[s];
	arr[s]=arr[e];
	arr[e]=temp;
	reverseArr(arr,++s,--e);
}
  ```

# Iterative Solution in C++
```cpp
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
```