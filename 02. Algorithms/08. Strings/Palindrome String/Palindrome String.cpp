//GeeksforGeeks question link https://practice.geeksforgeeks.org/problems/palindrome-string0817/1#
#include <bits/stdc++.h>
using namespace std; 
// Function to check whether
// the string is palindrome
class Solution{
  public:
int checkPalindrome(string S)
{
    // Stores the reverse of the
    // string S
    string P = S;
 
    // Reverse the string P
    reverse(P.begin(), P.end());
 
    // If S is equal to P
    if (S == P) {
        // Return "Yes"
        return 1;
    }
    // Otherwise
    else {
        // return "No"
        return 0;
    }
}
};
// Driver Code
int main()
{
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin>>t;
  while(t--)
  {
    string S;
    cin>>S;
    Solution ob;
    cout << ob.checkPalindrome(S)<<"\n";
  }
  return 0;
}
