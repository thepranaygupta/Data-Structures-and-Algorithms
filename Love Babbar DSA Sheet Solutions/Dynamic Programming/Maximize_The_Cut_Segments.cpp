#include<bits/stdc++.h>
using namespace std;



 // } Driver Code Ends



class Solution
{
    public:
    //Function to find the maximum number of cuts.
    int maximizeTheCuts(int n, int x, int y, int z)
    {
        //Your code here
        int dp[4][n+1];
        int arr[4];
        arr[0]=0;
        arr[1]=x;
        arr[2]=y;
        arr[3]=z;
        for(int i=0;i<4;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0) dp[i][j]=0;
                else if(i==0) dp[i][j]=-1;
                else if(j==0) dp[i][j]=0;
                
                else{
                    if(arr[i]>j){
                      dp[i][j]=dp[i-1][j];
                     
                    } 
                    else{
                        if(dp[i][j-arr[i]]!=-1)
                        dp[i][j]=max(dp[i-1][j], (1+dp[i][j-arr[i]]));
                        else
                        dp[i][j]=dp[i-1][j];
                       
                    }
                }
                
                
            }
        }
       if(dp[3][n]==-1) return 0;
        return dp[3][n];
    }
};

// { Driver Code Starts.
int main() {
    
    //taking testcases
    int t;
    cin >> t;
    while(t--)
    {
        //taking length of line segment
        int n;
        cin >> n;
        
        //taking types of segments
        int x,y,z;
        cin>>x>>y>>z;
        Solution obj;
        //calling function maximizeTheCuts()
        cout<<obj.maximizeTheCuts(n,x,y,z)<<endl;

    }

	return 0;
}  // } Driver Code Ends