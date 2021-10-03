#include<bits/stdc++.h>
using namespace std;

class Solution{
	public:
	void DFS(vector<int> adj[], int src, bool visited[], stack<int> &st)
    {
        visited[src]=true;
        for(int i=0;i<adj[src].size();i++)
        {
            if(visited[adj[src][i]]==false)
            DFS(adj, adj[src][i], visited, st);
        }
        st.push(src);
    }
    void reverseEdges(vector<int> revEdge[], vector<int> adj[], int V)
    {
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<adj[i].size();j++)
            {
                revEdge[adj[i][j]].push_back(i);
            }
        }
    }
    void DFSRev(vector<int> revEdge[], int src, bool visited[])
    {
        visited[src]=true;
        for(int i=0;i<revEdge[src].size();i++)
        {
            if(visited[revEdge[src][i]]==false)
            DFSRev(revEdge, revEdge[src][i], visited);
        }
    }
    /*  Function to find the number of strongly connected components using Kosaraju's algorithm
        V: number of vertices
        adj[]: array of vectors to represent graph
    */
    int kosaraju(int V, vector<int> adj[]) {
        bool visited[V]; //Will store whether vertex traversed or not
        for(int i=0;i<V;i++)
        visited[i]=false;
        stack<int> st; //To help perform DFS according to finish times of vertices
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                DFS(adj, i, visited, st);
            }
        }
        vector<int> revEdge[V];
        reverseEdges(revEdge, adj, V); //Reverse the direction of all the edges of the graph
        for(int i=0;i<V;i++)
        visited[i]=false;
        int count=0; //Will store number of connected components
        while(!st.empty())
        {
            int u= st.top();
            st.pop();
            if(visited[u]==false){
                //DFS for reversed edges
                DFSRev(revEdge, u, visited);
                count++;
            }
        }
        return count;
    }
};

int main()
{
    int t; //Number of test cases
    cin >> t;
    while(t--)
    {
    	int V, E;
        //V -> Number of vertices
        //E -> Number of edges
    	cin >> V >> E;
    	vector<int> adj[V]; //Adjacency matrix
    	for(int i = 0; i < E; i++)
    	{
    		int u, v;
    		cin >> u >> v;
    		adj[u].push_back(v);
    	}
    	Solution obj;
    	cout << obj.kosaraju(V, adj) << "\n";
    }
    return 0;
}
