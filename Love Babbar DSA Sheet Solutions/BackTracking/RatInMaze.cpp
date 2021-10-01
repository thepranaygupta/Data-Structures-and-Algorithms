/*
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
Find all possible paths that the rat can take to reach from source to destination. 
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). 
Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.

Input 1:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output 1:
DDRDRR DRDDRR
Explanation 1:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.

Input 2:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output 2:
-1
Explanation 2:
No path exists and destination cell is 
blocked.
*/

class Solution{
    public:
    bool safe(int i,int j,int r,int c,vector<vector<int>>& m,vector<vector<bool>>& vis){
        if(i<0 || j<0 || i>=r || j>=c || m[i][j]==0 || vis[i][j]==true){
            return false;
        }
        return true;
    }
    void solve(vector<vector<int>> &m,vector<vector<bool>>& vis,int i,int j,int r,int c,string &curr,vector<string>& ans){
        if(i==r-1 && j==c-1 && m[i][j]==1){
            ans.push_back(curr);
            return;
        }
        if(safe(i,j,r,c,m,vis)){
            vis[i][j]=true;
            if(safe(i+1,j,r,c,m,vis)){
                curr+='D';
                solve(m,vis,i+1,j,r,c,curr,ans);
                curr.pop_back();
            }
            if(safe(i,j-1,r,c,m,vis)){
                curr+='L';
                solve(m,vis,i,j-1,r,c,curr,ans);
                curr.pop_back();
            }
           
            
            if(safe(i,j+1,r,c,m,vis)){
                curr+='R';
                solve(m,vis,i,j+1,r,c,curr,ans);
                curr.pop_back();
            }
            
            
             if(safe(i-1,j,r,c,m,vis)){
                curr+='U';
                solve(m,vis,i-1,j,r,c,curr,ans);
                curr.pop_back();
            }
            
            vis[i][j]=false;
        }
        
    }
    vector<string> findPath(vector<vector<int>> &m, int n) {
        // Your code goes here
        vector<string> ans;
        string curr="";
        int r = m.size(),c=m[0].size();
        vector<vector<bool>>vis(r,vector<bool>(c,false));
        solve(m,vis,0,0,r,c,curr,ans);
        if(ans.size()==0){
            ans.push_back("-1");
        }
        return ans;
        
    }
};
