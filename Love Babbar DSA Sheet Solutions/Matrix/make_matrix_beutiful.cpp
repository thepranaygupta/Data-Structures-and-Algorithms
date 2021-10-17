

#include <bits/stdc++.h>

using namespace std;

int findMinOpeartion(vector<vector<int> > matrix, int n){
        vector<int> sums;
        int mx=0;
        for(int i=0;i<n;i++){
            int sumR=0;
            int sumC=0;
            for(int j=0;j<n;j++){
                sumR+=matrix[i][j];
                sumC+=matrix[j][i];
            }
            mx=max(mx,max(sumR,sumC));
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum+=matrix[i][j];
            }
            sums.push_back(sum);
        }
        int op=0;
        for(auto itr: sums){
            op+=(mx-itr);
        }
        return op;
    } 

int main()
{
   int n;
   
   cin>>n;
  vector<vector<int>> matrix (n,vector<int>(n));
   
   for(int i=0;i<n;i++ )
    for(int j=0;j<n;j++){
       cin>>matrix[i][j];
    }
    int result=findMinOpeartion(matrix,n);
    cout<<result;
    return 0;
}
