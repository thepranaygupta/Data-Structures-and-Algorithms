#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    // pcolor represents the color of the parent node of v in the dfs tree.
    bool dfs(int v, bool pcolor, vector<bool>& visited, vector<bool>& color, vector<int> *adj) {
        visited[v] = true;
        color[v] = pcolor;
        for (auto to : adj[v]) {
            if (!visited[to]) { // going from vertex v to unvisited vertex to 
                if(!dfs(to, !color[v], visited, color, adj)) { // passing opposite color of vertex v to vertex to
                    return false;
                }
            }
            else if (color[v] == color[to]) { // Since to is already visited, thus a cycle is form. If both neighbouring nodes v and to have
                return false;                 // same color than graph is not bipartite.
            }
        }
        return true;
    }
	bool isBipartite(int V, vector<int> adj[]) {
	    vector<bool> visited(V, false);
	    vector<bool> color(V, false);
	    bool isbipartite = true;
	    for (int i = 0; i < V; ++i) { // Run this loop because the graph might be disconnected.
	        if (!visited[i]) {
	            isbipartite &= dfs(i, false, visited, color, adj);
	        }
	    }
	    return isbipartite;
	}

};

int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}