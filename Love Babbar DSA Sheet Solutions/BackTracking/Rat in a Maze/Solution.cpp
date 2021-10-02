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
