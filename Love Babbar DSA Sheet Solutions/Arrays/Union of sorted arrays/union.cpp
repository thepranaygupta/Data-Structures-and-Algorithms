#include <bits/stdc++.h>
using namespace std;
void findunion(int arr1[], int n, int arr2[], int m)
{
    set<int> s;  //using the set to insert values
    for(int i = 0; i < n; i++)
     s.insert(arr1[i]);
    for(int i = 0; i < m; i++)
     s.insert(arr2[i]);
     //prints the sorted array
    for(auto i:s) 
    {
      cout<<i<<" ";
    }
}

int main()
{
   int n,m;
  cin>>n; //number of elements of first array
  cin>>m;  //number of elements of second array
  int a1[n],a2[m];

  //Enter the elements in the first array
  for(int i=0;i<n;i++)
  {
    cin>>a1[i];
  }
  //Enter the elements in the second array
   for(int i=0;i<m;i++)
  {
    cin>>a2[i];
  }
  
    findunion(a1, n, a2, m); //calling the function
  
    return 0;
}