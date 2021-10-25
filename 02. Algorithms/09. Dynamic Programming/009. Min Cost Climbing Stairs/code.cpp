class Solution {
public:
    
    int min(int a, int b) {
        return a<b?a:b ;
    }
    
    int solve(vector<int>cost, vector<int>&dp, int index) {
        if(index>=cost.size())
            return 0 ;
        
        if(dp[index]!=-1)
            return dp[index] ;
        
        return dp[index] = cost[index] + min(solve(cost,dp,index+1), solve(cost,dp,index+2)) ;
    }  
    
    int minCostClimbingStairs(vector<int>& cost) {
        int n = cost.size() ;
        
        /*vector<int>dp(n+1,-1) ;
        return min(solve(cost,dp,0), solve(cost,dp,1)) ;*/
        
        int dp[n] ;
        
        dp[0] = cost[0] ;
        dp[1] = cost[1] ;
        
        for(int i=2;i<n;i++) {
            dp[i] = cost[i] + min(dp[i-1],dp[i-2]) ;
        }
        
        return min(dp[n-1],dp[n-2]) ;
    }
};