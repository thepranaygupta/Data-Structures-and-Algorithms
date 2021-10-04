#include<iostream>
#include<vector>
using namespace std;
vector<vector<int> > solve(int A) {
   
    vector< vector<int> > v;
     if(A == 0)
   return v;
    vector<int> v1;
    v1.push_back(1);
    v.push_back(v1);
    
    int x;
    for(int i=2;i<=A;i++)
    {
       vector<int> v2(v1.size(),0);
        x=1;
        v2[0] = v1[0];
    while(x<v1.size()){
        v2[x] = v1[x]+v1[x-1];
          x++; 
    }
    v2.push_back(v1[0]);
    v.push_back(v2);
    v1 = v2;
}
    return v;

}
int main(){
     int n;
     cin>>n;
     vector< vector<int> > v = solve(n);
     for(int i=0;i<v.size();i++){
         for(int j=0;j<v[i].size();j++){
             cout<<v[i][j]<<" ";
         }
         cout<<endl;
     }
     return 0;
 }
