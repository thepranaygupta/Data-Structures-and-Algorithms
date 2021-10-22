/ { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


 // } Driver Code Ends
//User function template for C++
#define max 256
class Solution{
public:
	bool compare(char count[],char countW[])
{
    for(int i=0;i<max;i++){
        if(count[i]!=countW[i])
        return false;
    }
    return true;
}
	int search(string pat, string txt) {
	    // code here
	    int M = pat.size();
	    int N = txt.size();
	    char count[max]={0};
	    char countW[max]={0};
	    for(int i=0;i<M;i++){
	        countW[pat[i]]++;
	        count[txt[i]]++;
	    }
	    int x = 0;
	    for(int i=M;i<N;i++){
	        if(compare(count,countW))
	        x++;
	        
	        count[txt[i]]++;
	        count[txt[i-M]]--;
	    }
	     if (compare(count, countW))
           x++;
	    return x;
	}

};


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string pat, txt;
        cin >> txt >> pat;
        Solution ob;
        auto ans = ob.search(pat, txt);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends