class Solution {
public:
   void dfs(int i, vector<vector<int>>& rooms, vector<bool>& vis){
       vis[i]=true;
       for(auto nbr:rooms[i]){
           if(!vis[nbr]){
                dfs(nbr, rooms, vis);
           }
       }
   }
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int n = rooms.size();
        vector<bool> vis(n,false);
        dfs(0,rooms,vis);
        for(auto i:vis){
            if(!i)
                return false;
        }
        return true;
    }
};