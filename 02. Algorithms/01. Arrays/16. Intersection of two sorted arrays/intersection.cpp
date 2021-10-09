#include<iostream>
#include<vector>
using namespace std;
vector<int> intersect(const vector<int> &A, const vector<int> &B) {
    vector<int> v;
    int i=0,j=0;
    
    while(i<A.size() && j<B.size()){
        if(A[i]==B[j])
        {
            v.push_back(A[i]);
            i++;
            j++;
        }
        else if(A[i]<B[j])
        i++;
        else if(B[j]<A[i])
        j++;

        
    }
    return v;
}
int main(){
      int n;
      cin>>n;
      vector<int> a(n,0);
      for(int i=0;i<n;i++){
          cin>>a[i];
      }
      int n1;
      cin>>n1;
      vector<int> b(n1,0);
       for(int i=0;i<n1;i++){
          cin>>b[i];
      }
      vector<int>  c = intersect(a,b);
        for(int i=0;i<c.size();i++){
          cin>>c[i];
      }
      return 0;
  } 
