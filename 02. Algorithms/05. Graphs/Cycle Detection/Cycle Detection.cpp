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
				
		cout<<"\nAdjajency Matric-:\n";
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

