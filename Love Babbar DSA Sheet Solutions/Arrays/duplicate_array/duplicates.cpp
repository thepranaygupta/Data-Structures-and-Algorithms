#include <bits/stdc++.h>
using namespace std;


class Solution{
  public:
    vector<int> duplicates(int arr[], int n) {
    
         vector<int> v;
       int last;
       sort(arr,arr+n);
       for(int i=0;i<n;i++){
       if(arr[i]==arr[i+1] && arr[i]!=last)
       {v.push_back(arr[i]);
       last=arr[i];
       }
       }
       if(v.size()==0)
       v.push_back(-1);
       return v;
    }
};


int main() {
    
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) cin >> a[i];
        Solution obj;
        vector<int> ans = obj.duplicates(a, n);
        for (int i : ans) cout << i << ' ';
        cout << endl;
    
    return 0;
}


