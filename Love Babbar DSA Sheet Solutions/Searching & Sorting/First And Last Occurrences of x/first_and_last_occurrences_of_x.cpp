//Problem Statement : 
/*   
Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of first 
and last occurrences of an element x in the given array.

Difficulty : Basic
*/


/*
Example 1:
Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last occurrence of 5 is at index 5. 


Example 2:
Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 6 


/*
Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1).
*/


// Solution Explained -
/* 
   1) Iterate the array from both forward and backward directions with 2 pointers.
   2) As soon as we find the required element in the array we will push_back the respective indices(values of those 2 pointers) in a vector.
   3) Return the vector.

*/


 //Solution--

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
vector<int> find(int a[], int n , int x );

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n,x;
        cin>>n>>x;
        int arr[n],i;
        for(i=0;i<n;i++)
        cin>>arr[i];
        vector<int> ans;
        ans=find(arr,n,x);
        cout<<ans[0]<<" "<<ans[1]<<endl;
    }
    return 0;
}
// } Driver Code Ends

vector<int> find(int arr[], int n , int x )
{
    int i = 0, j = n -1;
    vector<int> v;
    while(i <= j){
        if(arr[i] != x)
            i++ ;
        
        if(arr[j] != x)
            j-- ;
        
        if(arr[i] == x && arr[j] == x){
            v.push_back(i);
            v.push_back(j);
            break;
        }    
    }
    if(i > j){
        v.push_back(-1);
        v.push_back(-1);
    }
    
    return v;
}
