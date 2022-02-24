//Problem Statement : 
/*   
Given an array Arr of N positive integers. Your task is to find the elements whose value 
is equal to that of its index value ( Consider 1-based indexing ).

Difficulty : School
*/


/*
Example 1:
Input: 
N = 5
Arr[] = {15, 2, 45, 12, 7}
Output: 2
Explanation: Only Arr[2] = 2 exists here.
*/


//Solution Explained
//Easy School level problem. Added just for the sake of sequence...


// Solution-

#include<bits/stdc++.h>
using namespace std;

class Solution{
public:
	vector<int> valueEqualToIndex(int arr[], int n) {
	    int i = 0;
	    vector<int> v;
	    while(i <= n){
	        if(arr[i] == i+1){
	            v.push_back(arr[i]);
	            i++ ;
	        }
	        else
	            i++ ;     
	    }
	    return v;
	}
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.valueEqualToIndex(arr, n);
        if (ans.empty()) {
            cout << "Not Found";
        } else {
            for (int x: ans) {
                cout << x << " ";
            }
        }
        cout << "\n";
    }
    return 0;
}
  // } Driver Code Ends
