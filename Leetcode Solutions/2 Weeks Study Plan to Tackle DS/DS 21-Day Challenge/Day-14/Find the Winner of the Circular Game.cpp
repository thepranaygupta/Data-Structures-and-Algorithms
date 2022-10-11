class Solution {
public:
    int solve(int n,int k)
    {
        if(n==1) return 0;
        int x=solve(n-1,k);
        int y=(x+k)%n;
        return y;
    }
    int findTheWinner(int n, int k) {
       if(k>n) k=k%n;
        return solve(n,k)+1;
    }
};