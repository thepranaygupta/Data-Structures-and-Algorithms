// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
	public:
	//Function to return list containing vertices in Topological order. 
	vector<int> res;
	void dfs(int V, vector<int> adj[], vector<bool> &vis, vector<int> &res)
	{
	    if(vis[V])
	        return;
	    vis[V] = true;
	    for(int i : adj[V])
	        dfs(i, adj, vis, res);
	    res.push_back(V);
	}
	vector<int> topoSort(int V, vector<int> adj[]) 
	{
	    // code here
	    vector<int> res;
	    vector<bool> vis(V, false);
	    for(int i = 0 ; i < V ; i++)
	    {
	        if(!vis[i])
	            dfs(i, adj, vis, res);
	    }
	    reverse(res.begin(), res.end());
	    return res;
	}

    vector<int> bfssort(vector<vector<int>> graph) {
        vector <int> indegree(graph.size(), 0);
        queue<int> q;
        vector<int> solution;
        
        for(int i = 0; i < graph.size(); i++) {
            for(int j = 0; j < graph[i].size(); j++)
            { 
            //iterate over all edges
                indegree[ graph[i][j] ]++;
            }
        }
        
        //enqueue all nodes with indegree 0
        for(int i = 0; i < graph.size(); i++) 
        {
            if(indegree[i] == 0) {
                q.push(i);
            }
        }

        //remove one node after the other
        while(q.size() > 0) {
            int currentNode = q.front();
            q.pop();
            solution.push_back(currentNode);
            for(int j = 0; j < graph[currentNode].size(); j++)
            { 
            //remove all edges
                int newNode = graph[currentNode][j];
                indegree[newNode]--;
                if(indegree[newNode] == 0) 
                { 
                //target node has now no more incoming edges
                    q.push(newNode);
                }
            }
        }
        
        return solution;
    }
};

// { Driver Code Starts.

/*  Function to check if elements returned by user
*   contains the elements in topological sorted form
*   V: number of vertices
*   *res: array containing elements in topological sorted form
*   adj[]: graph input
*/
int check(int V, vector <int> &res, vector<int> adj[]) {
    vector<int> map(V, -1);
    for (int i = 0; i < V; i++) {
        map[res[i]] = i;
    }
    for (int i = 0; i < V; i++) {
        for (int v : adj[i]) {
            if (map[i] > map[v]) return 0;
        }
    }
    return 1;
}

int main() {
    //cin to specify whether dfs or bfs method should run
    string type;
    cin >> type;

    int N, E;
    cin >> E >> N;
    int u, v;

    vector<int> adj[N];

    for (int i = 0; i < E; i++) {
        cin >> u >> v;
        adj[u].push_back(v);
    }

    Solution obj;

    if (type=="dfs") {
        
        vector <int> res = obj.topoSort(N, adj);
    }
    else {
        vector <int> res = obj.bfssort();
    }
    
    cout << check(N, res, adj) << endl;
    
    return 0;
}  // } Driver Code Ends
