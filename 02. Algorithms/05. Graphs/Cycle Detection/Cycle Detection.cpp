/*
Detect cycle in an undirected graph
Given an Undirected Graph. Check whether it contains a cycle or not. 



Format:

?Input:

The first line of input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of test cases are as follows: The first line of each test case contains two integers 'N' and 'M'. Which denotes the number of vertices and number of edges respectively. 

The Second line of each test case contains 'M'  space-separated pairs u and v 

denoting that there is a bidirectional edge from u to v.

Output:

The method should return 1 if there is a cycle else it should return 0.



Constraints:

1 <= T <= 100

2 <= N <= 104

1 <= M <= (N*(N-1))/2

0 <= u, v <= N-1

The graph doesn't contain multiple edges and self-loops.
Example:

Input:

3

2 1
0 1

4 3
0 1 1 2 2 3

5 4
0 1 2 3 3 4 4 2

Output:

0

0

1

Explanation:

Testcase 1: There is a graph with 2 vertices and 1 edge from 0 to 1. So there is no cycle.

Testcase 2: There is a graph with 3 vertices and 3 edges from 0 to 1, 1 to 2, and 2 to 3.

Testcase 3: There is a cycle in the given graph formed by vertices 2, 3, and 4.


*/

#include<bits/stdc++.h>
using namespace std;


bool checkLoop(vector<vector<int> >a,int v,int e){
	vector<int> stack;         //stack of vertices
	vector<int>parent; 
	bool visited[v];
	vector<int>::iterator itr = parent.begin();
	memset(visited,false,sizeof(visited));
	stack.push_back(0);
	parent.push_back(-1);
	
	for(int i=0;i<v;i++){
		for(int j=0;j<v;j++){
			if(a[i][j]==1 && find(stack.begin(),stack.end(),j)==stack.end()){  //if a[set value at i][j]==1 and value of j where its 1 not present in stack		
				//Add the j in stack and add in unordered list with parent;
				stack.push_back(j);
				parent.push_back(i);
			}
			else if(a[i][j]==1 && !visited[j]){  // if a[set value at i][j]==1 and value is present in stack but not visited yet
				continue;
			}
			else if(a[i][j]==1 && visited[j] && parent[i]!=j){ // if a[set value at i][j]==1 and value is present in stack and visited and also is not a parent 
				return true;
			}
		}
		visited[i+1]=true;	
	}
	
//	cout<<"Stack-: ";
//	for(int i=0;i<v;i++)
//	cout<<stack[i]<<" ";
//	cout<<"\n Parent-: ";
//	for(int i=0;i<v;i++)
//	cout<<parent[i]<<" ";
	
	return false;
}

void solve()
{
	int vertices,edges;
	cin>>vertices>>edges;
	// int adjajency[vertices+1][vertices+1];
	vector< vector<int> > adjajency (vertices , vector<int> (vertices, 0));
	
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++)
			adjajency[i].push_back(0);
		}
		
		int s,d;
		for(int i=0;i<edges;i++){
			cin>>s>>d;
			adjajency[s][d]=1;
			adjajency[d][s]=1;
		}
				
		cout<<"\n";
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++)
			cout<<adjajency[i][j]<<" ";
			cout<<"\n";
		}
		if(vertices<3 || edges<3)
		cout<<"Answer: 0\n";
		else
		cout<<"Answer: "<<checkLoop(adjajency,vertices,edges)<<"\n\n";
	
}


int main()
{
ios_base::sync_with_stdio(0);
cin.tie(0); cout.tie(0);
long long t;
cin>>t;
while(t--)
   solve();
return 0;
}

