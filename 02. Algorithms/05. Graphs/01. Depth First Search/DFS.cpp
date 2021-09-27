// Including header files.
#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;

 // } Driver Code Ends
class Solution 
{
    public:
    vector<int> dfsTraversal;
    unordered_map<int, bool> isVisited;
    
    void getDFS(int vertex, vector<vector<int>> &adjList){
        dfsTraversal.push_back(vertex);
        isVisited[vertex] = true;
        
        for(auto x: adjList[vertex]){
            if(isVisited[x] == false)
	            getDFS(x, adjList);
        }
    }
	
	//Function to return a list containing the DFS traversal of the graph.
	vector<int>dfsOfGraph(int V, vector<int> adj[]){   
	    vector<vector<int>> adjList(V);
	    for(int i = 0; i < V; i++){
	        adjList[i].push_back(i);
	        for(auto x: adj[i])
	            adjList[i].push_back(x);
	    }
	    getDFS(adjList[0][0], adjList);
	    
	    return dfsTraversal;
	}
};

// { Driver Code Starts.
int main(){
	int tc;
	cout<< "Enter number of test cases you want to execute: "<< endl;
	cin>> tc;
	while(tc--){
		int V, E;
		cout<< "\nEnter number of Vertex and Edges in tese case: "<< tc<< endl;
    	cin>> V>> E;

    	vector<int> adj[V];
    	cout<< "\nEnter vertices with direction: "<< endl;
    	for(int i = 0; i < E; i++){
    		int u, v;
    		cin>> u>> v;
    		adj[u].push_back(v);
    		adj[v].push_back(u);
    	}
        // string s1;
        // cin>>s1;
        Solution obj;
        vector<int> ans = obj.dfsOfGraph(V, adj);
        cout<< "\nPossible DFS traversal of Graph is :"<< endl;
        for(int i = 0; i < ans.size(); i++){
        	cout<< ans[i]<< " ";
        }
        cout<< endl;
	}
	return 0;
}  // } Driver Code Ends