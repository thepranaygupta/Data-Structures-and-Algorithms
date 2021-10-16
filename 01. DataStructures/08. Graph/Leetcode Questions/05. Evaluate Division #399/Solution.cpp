## dfs approach

class Solution {
public:
    
    double find(string dest , string a, double mul,
                unordered_map<string, vector<pair<string, double>>>& g,
               unordered_set<string>& visited
               ){
        
        for(auto &it : g[a]){
            string i = it.first;
            double val = it.second;
            
            if(visited.count(i) == 0){
                visited.insert(i);
                
                if(i == dest){
                    return val * mul;
                    
                } else {
                    double next = find(dest, i, mul * val, g, visited);
                    if(next != -1){
                        return next;
                    }
                }
                
              
                visited.erase(i);
            }
        }
        
        return -1;
}
    
    vector<double> calcEquation(vector<vector<string>>& e, vector<double>& val, vector<vector<string>>& queries) {
        
        unordered_map<string, vector<pair<string, double>>> g;
        
        
        for(int i = 0 ; i < e.size() ; i++){
            string a = e[i][0];
            string b = e[i][1];
            double v = val[i];
            
            if( g.count(a) == 0){
                vector<pair<string,double>> ve;
                g[a] = ve;
            }
            g[a].push_back({b, 1/v});
            if( g.count(b) == 0){
                vector<pair<string,double>> ve;
                g[b] = ve;
            }
            g[b].push_back({a, v});
        }
        
        vector<double> ans;
        
        for(int i = 0 ; i < queries.size() ; i++){
            string a = queries[i][0];
            string b = queries[i][1]; 
            unordered_set<string> visited;
            ans.push_back(find(a, b, 1, g, visited));
        }
        
        
        return ans;
    }
};
