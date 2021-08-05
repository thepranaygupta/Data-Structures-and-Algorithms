# **Graphs**

### Max no. of Edge in graph of N nodes can be **N x (N-1) / 2.**

### Min no. of Edge in graph of N nodes can be **N-1.**

# Prerequisites:-

- Stack
- Queue
- PriorityQueue

# Step 1 : Graph Representation
**[Video Reference by Anuj Bhaiya](https://youtu.be/D21-XVw6nYw)**
```java
package graphDS;
import java.util.*;
public class MyGraph2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Vertices and edge");
		int v=sc.nextInt();
		int e=sc.nextInt();
		if(e > v*(v-1)/2) {
			System.out.println("Invalid edge"); return;
		}
		Graphy1 g1=new Graphy1(v);
		System.out.println("1. Add edge in undirected graph");
		System.out.println("2. Add edge in directed graph");
		int ch=sc.nextInt();
		
		
		for(int i=0;i<e;i++) {
			System.out.println("Enter source and destination");
			int src=sc.nextInt();
			int des=sc.nextInt();
			if(ch==1) g1.addEdgeU(src, des);
			else if(ch==2) g1.addEdgeD(src, des);
		}
		g1.printAdjaencyList();
		
		
	}

}
class Graphy1{
	private ArrayList<Integer> graph[];
	public Graphy1(int v) {
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) graph[i]=new ArrayList<>();
	}
	public void addEdgeU(int source, int destination) {
		graph[source].add(destination);
		graph[destination].add(source);
	}
	public void addEdgeD(int source, int destination) {
		graph[source].add(destination);
	}
	public void printAdjaencyList() {
		System.out.println("Adjaency List : -");
		for(int i=0; i<graph.length; i++) {
			System.out.print(i+" --> ");
			int j=0;
			while(j<graph[i].size()) {
				System.out.print(graph[i].get(j)+"  ");
				j++;
			}
			System.out.println();
		}
	}
}

```
# Step 2 : Components in Graph
**[Video Reference](https://youtu.be/I6v0itcISSY)**
![componentsGraph](https://user-images.githubusercontent.com/71629248/127270730-a4dd8ef2-10fe-4942-82f2-5e5305a73784.png)

- This all are the 3 components of a single graph.
- From now whenever we will do any operations we will do for every components.
- To do that we will make a boolean visited array.
```java
boolean vis[]=new boolean[v];
for(int i=1; i<v; i++){
    if(!vis[i]){
        bfs(); or dfs(); // any operations.
    }
}
```
- To count number of components just add a counter inside if statement

# Step 3 : BFSprint()
**[Video Reference](https://youtu.be/UeE67iCK2lQ)**
- Make a boolean visited array of size v
- Run a loop from (0-->n-1)
	- if(!vis[i]) then call BFSPrint() for every component.
		1. make vis[i]=true;
		2. Make Queue and add i
		3. run a loop till queue is empty.
			- extract vertex from queue and print it.
			- add adjacent(if not visited) of this vertex into Queue and mark true in visited array.
```java
// 2. BFS print() Starts
		public void printBfs() {
			System.out.println("BFS Traversal : -");
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					vis[i]=true;
					Queue<Integer> q=new LinkedList<>();
					q.add(i);
					
					while(!q.isEmpty()) {
						int vert=q.poll();
						System.out.print(vert+" ");
						for(Integer adj: graph[vert]) {
							if(!vis[adj]) {
								vis[adj]=true;
								q.add(adj);
							}
						}// adjacent for
					}// queue while
				}// outer component if
			}// // outer component for
			System.out.println();
		}// outer ()
// 2. BFS print() Ends
```			
# Step 4 : DFSprint()
**[Video Reference](https://youtu.be/uDWljP2PGmU)**
- Make a visited array of vertices
- dfs(i)
	- mark visited and print i
	- for each adjacent of i
		- if not visited call dfs(i)
```java
// 3. DFS print() Starts
		public void printDFS() {
			System.out.println("DFS Traversal :-");
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					dfs(i,vis);
				}
			}
			System.out.println();
		}
		private void dfs(int vert, boolean vis[]) {
			vis[vert]=true;
			System.out.print(vert+" ");
			
			for(Integer adj: graph[vert]) {
				if(!vis[adj]) {
					dfs(adj,vis);
				}
			}
		}
// 3. DFS print() Ends
```		
# Step 5 : isCycle() for UG using BFS
**[Video Reference](https://youtu.be/A8ko93TyOns)**
- For being a cycle forward coming adjacent node must be visited.
- That's why we keep track for parent node for each vertex.
	- this is because parent node is also adjacent node so to tackle the clash **we will return true if (adj node is visited and adj!=parent)**
```java
// 4. isCycleBfsUg() Starts
		class Pair{
			int current;
			int parent;
			public Pair(int curr, int par) {
				current=curr;
				parent=par;
			}
		}
		public boolean isCycleBfsUg() {
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i])
					if(cycleBfsUg(i,vis)) return true;
			}
			return false;
		}
		private boolean cycleBfsUg(int i, boolean vis[]) {
			
			vis[i]=true;
			
			Queue<Pair> q=new LinkedList<>();
			q.add(new Pair(i,-1));
			
			while(!q.isEmpty()) {
				int vert=q.peek().current;
				int par=q.poll().parent; // assume it as a grandParent for adj nodes of vertex
				
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						vis[adj]=true;
						q.add(new Pair(adj,vert));
					}
					else if(vis[adj] && adj!=par) return true;
				}
			}
			return false;
		}
// 4. isCycleBfsUg() Ends
```
# Step 6 : isCycle() for UG using DFS
**[Video Reference](https://youtu.be/Y9NFqI6Pzd4)**
- Same Concept
```java
// 5. isCycleDfsUg() Starts
		public boolean isCycleDfsUg() {
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					if(cycleDfsUg(i,-1,vis))return true;
				}
			}
			return false;
		}
		private boolean cycleDfsUg(int vert,int parent, boolean vis[]) {
			vis[vert]=true;
			for(Integer adj:graph[vert]) {
				if(!vis[adj]) {
					if(cycleDfsUg(adj, vert, vis)) return true;
				}
				else if(adj!=parent) return true;
			}
			return false;
		}
// 5. isCycleDfsUg() Ends
```
# Step 7 : isBipartite() for UG using BFS
**[Video Reference](https://youtu.be/nbgaEu-pvkU)**
- Except **oddLengthCycleGraph** every graph is a bipartite graph.
- ![bipartiteBFS](https://user-images.githubusercontent.com/71629248/127450745-d47a9f4e-15e3-442b-a6bf-d0fad172fc20.png)

```java
// 6. isBipartiteBFSug() Starts
		public boolean isBipartiteBFSug() {
			int color[]=new int[graph.length];
			Arrays.fill(color, -1);
			for(int i=0; i<graph.length; i++){
				if(color[i]==-1)
					if(!bipartiteBfsUg(i,color)) return false;
			}
			return true;
		}
		private boolean bipartiteBfsUg(int i, int color[]) {
			color[i]=0;
			Queue<Integer> q=new LinkedList<>();
			q.add(i);
			
			while(!q.isEmpty()) {
				int vert=q.poll();
				for(Integer adj: graph[vert]) {
					if(color[adj]==-1) {
						color[adj]=1-color[vert];
						q.add(adj);
					}
					else if(color[adj]==color[vert]) return false;
				}
			}
			return true;
		}
// 6. isBipartiteBFSug() Ends
```
# Step 8 : isBipartite() for UG using DFS
**[Video Reference](https://youtu.be/uC884ske2uQ)**
- Same concept as step 7.
```java
// 7. isBipartiteDFSug() Starts
		public boolean isBipartiteDFSug() {
			int color[]=new int[graph.length];
			Arrays.fill(color, -1);
			
			for(int i=0; i<graph.length; i++) {
				if(color[i]==-1) {
					color[i]=0;
					if(!bipartiteDfsUg(i,color)) return false;
				}
			}
			return true;
		}
		private boolean bipartiteDfsUg(int vert, int color[]) {
			for(Integer adj: graph[vert]) {
				if(color[adj]==-1) {
					color[adj]=1-color[vert];
					if(!bipartiteDfsUg(adj,color)) return false;
				}
				else if(color[adj]==color[vert]) return false;
			}
			return true;
		}
// 7. isBipartiteDFSug() Ends
```
# Step 9 : isCycle() for DG using DFS
![isCycleDG](https://user-images.githubusercontent.com/71629248/127507105-59916cd3-e520-4055-b074-f39dc5168309.png)

**[Video Reference](https://youtu.be/uzVUw90ZFIg)**
- Here we will have two boolean array vis[] & dfsvis[] (this will tell current standing position of recurssion ())
- If there is no adjacent for current vertex we roll back to calling() after making dfsvis[vert]=false
- If adjacent is already visited(i.e., vis[adj]==true) then we will check wheather dfsvis[adj]==true.
	- If true than we return True
	- else we make dfsvis[vert]=false and rollback to calling().
```java
// 8. isCycleDfsDg() Starts
			public boolean isCycleDfsDg() {
				boolean vis[]=new boolean[graph.length];
				boolean dfsvis[]=new boolean[graph.length];
				for(int i=0; i<graph.length; i++) {
					if(!vis[i]) {
						if(cycleDfsDg(i,vis,dfsvis)) return true;
					}
				}
				return false;
			}
			private boolean cycleDfsDg(int vert, boolean vis[], boolean dfsvis[]) {
				vis[vert]=dfsvis[vert]=true;
				
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						if(cycleDfsDg(adj,vis,dfsvis)) return true;
					}
					else if(dfsvis[adj]) return true;
				}
				dfsvis[vert]=false;
				return false;
			}
// 8. isCycleDfsDg() Ends
```	
# Step 10 : Topological Sort for DAG using DFS
**[Video Reference](https://youtu.be/Yh6EFazXipA)**
 ### **Topological Sort :** Linear ordering of vertices such that if there is an edge between u-->v, u will apper before v.
 - That's why we do dfs traversal and insert the inner most vertex in stack then above it we insert the parent and so on..
 ```java
 // 9. topoDfsDAG() for DAG using DFS Starts
			public void topoDfsDAG() {
				System.out.println("Topological Sort :-");
				boolean vis[]=new boolean[graph.length];
				Stack<Integer> st=new Stack<>();
				for(int i=0; i<graph.length; i++) {
					if(!vis[i]) {
						topoDfs(i,vis,st);
					}
				}
				while(!st.isEmpty())
					System.out.print(st.pop()+" ");
				System.out.println();
			}
			private void topoDfs(int vert, boolean vis[], Stack<Integer> st) {
				vis[vert]=true;
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) {
						topoDfs(adj,vis,st);
					}
				}
				st.push(vert);
			}
// 9. topoDfsDAG() for DAG using DFS Ends	
 ```
# Step 11 : Topological Sort for DAG using BFS - Khan's Algorithm
**[Video Reference](https://youtu.be/rZv_jHZva34)**
## Thought Process :-
Indegree of each vertex defines Independent level of that vertex, vertex with 0 indegree is the most Independent vertex who can go and stand in toposort line without worrying about their parent. When any vertex go in toposort line they remove their burden from their adjacents by decreasing their indegree.
```java
// 10. topoBfsDAG() for DAG using BFS Starts
			public void topoBfsDAG() {
				System.out.println("Topological Sort using BFS :-");
				// Step 1 : Make a indegree array
				int indeg[]=new int[graph.length];
				for(int i=0; i<graph.length; i++) {
					for(Integer adj: graph[i]) {
						indeg[adj]++;
					}
				}
				// Step 2 : Insert vertices with indegree 0 in queue.
				Queue<Integer> q=new LinkedList<>();
				for(int i=0; i<graph.length; i++) {
					if(indeg[i]==0) q.add(i);
				}
				// Step 3 : do BFS in Queue till its empty
				while(!q.isEmpty()) {
					int vert=q.poll();
					System.out.print(vert+" ");
					for(Integer adj: graph[vert]) {
						indeg[adj]--;
						if(indeg[adj]==0) q.add(adj);
					}
				}
				System.out.println();
			}
// 10. topoBfsDAG() for DAG using BFS Ends
```
# Step 12 : isCycle() for DG using BFS 
**[Video Reference](https://youtu.be/V6GxfKDyLBM)**
## Thought Process :-
As Topological sort works only for DAG so we will us reverseThought process if toposort is generated by DG then there is no cycle else there is cycle in graph.
```java
// 11. isCycleBfsDg() Starts
			public boolean isCycleBfsDg() {
				// Step 1 : Make Indegree of each vertex
				int indeg[]=new int[graph.length];
				for(int i=0; i<graph.length; i++) {
					for(Integer adj: graph[i]) {
						indeg[adj]++;
					}
				}
				// Step 2 : Insert vertices with indegree 0 in Queue
				Queue<Integer> q=new LinkedList<>();
				for(int i=0;i<graph.length;i++) {
					if(indeg[i]==0) q.add(i);
				}
				// Step 3 : do BFS in queue till its empty
				int cnt=0;
				while(!q.isEmpty()) {
					int vert=q.poll();
					cnt++;
					for(Integer adj: graph[vert]) {
						indeg[adj]--;
						if(indeg[adj]==0) q.add(adj);
					}
				}
				return cnt!=graph.length;
			}
// 11. isCycleBfsDg() Ends
```
# Step 13 : Shortes path for UG with unit weight edges (shortest path in terms of no. of edges)
**[Video Reference](https://youtu.be/hwCWi7-bRfI)**
```java
// 12. sPath1wtUg() Starts 
			public void sPath1wtUg(int src) {
				// Step 1 : Make dis[] array which stores distance from source to each vertex.
				int dis[]=new int[graph.length];
				// Initialize with the max value
				Arrays.fill(dis, Integer.MAX_VALUE);
				// distance from source to source is always 0
				dis[src]=0;
				// Step 2 : Make Queue and add source
				Queue<Integer> q=new LinkedList<>();
				q.add(src);
				// Step 3 : Traverse queue Adjacents till its empty
				while(!q.isEmpty()) {
					int vert=q.poll();
					int dist=dis[vert];
					for(Integer adj: graph[vert]) {
						if(dist+1<dis[adj]) {
							dis[adj]=dist+1;
							q.add(adj);
						}
					}
				}
				System.out.println("Shortest Path for UG with unit weight : "+Arrays.toString(dis));
			}
// 12. sPath1wtUg() Ends	
```
# **Graphy2 Starts from here i.e., graphs with weights.**

# Step 14 : Make a Graphy2 class and code the structure of Graph
![graphy2](https://user-images.githubusercontent.com/71629248/127745038-31822bbe-9575-4573-884c-cf20d1945cf3.png)

```java
class Graphy2{
	
	class Tripy implements Comparable<Tripy>{
		int curr;
		int par;
		int wt;
		
		public Tripy(int destination,int source,int weight) {
			curr=destination;
			par=source;
			wt=weight;
		}

		@Override
		public int compareTo(Tripy o) {
			// TODO Auto-generated method stub
			return this.wt-o.wt;
		}
	}
	
	private ArrayList<Tripy> graph[];
	public Graphy2(int v) {
		graph=new ArrayList[v];
		for(int i=0;i<v;i++) graph[i]=new ArrayList<>();
	}
	
	public void addEdgeU(int par, int curr, int wt) {
		graph[par].add(new Tripy(curr,par,wt));
		graph[curr].add(new Tripy(par,curr,wt));
	}
	public void addEdgeD(int par, int curr, int wt) {
		graph[par].add(new Tripy(curr,par,wt));
	}
	public void printAdjaencyList() {
		for(int i=0; i<graph.length; i++) {
			System.out.print(i+"--> ");
			for(Tripy adj: graph[i]) {
				System.out.print("("+adj.curr+", "+adj.wt+")  ");
			}
			System.out.println();
		}
	}
}
```
# Step 15 : Shortest path in DAG using TopoSort 
**[Video Reference](https://youtu.be/CrxG4WJotgg)**
- Why if(dis[vert]!=Integer.MAX_VALUE) used ?
	- **ANS :** Because if you have not reached that node from source , how will you move ahead
- Why Toposort ? Why not BFS technique ?
	- **ANS :** TC issue. lets say you want to do it using DFS
yes you can do it using DFS , but consider the case when you already updated a node's distance by a dfs() call and lets say its 7 and as it is DFS then its obvious that you also have updated all the nodes in its segment of DFS call . now you have reached to the same node from different dfs() call and now the distance is 4 , so in order to update all the nodes which were affected by the DFS call previously on the node considering distance as 7 , you now again have to do the same so that its updated with new min distance.
Same is the scenario for the simple BFS approach.
This multiple time calling DFS/BFS degrades the Time Complexity, hence Topological Ordering save you from that overhead as you already know which nodes will come after the current node , so you keep on updating it .
```java
// 13. Shortest path in DAG using TopoSort STARTS
		private void topoSortDfs(int vert, boolean vis[], Stack<Integer> st) {
			vis[vert]=true;
			for(Tripy adj: graph[vert]) {
				if(!vis[adj.curr]) topoSortDfs(adj.curr,vis,st);
			}
			st.push(vert);
		}
		public void sPathDagTopo(int src) {
			// Step 1 : Arrange all the vertices in toposort order
			Stack<Integer> st=new Stack<>();
			boolean vis[]=new boolean[graph.length];
			for(int i=0; i<graph.length; i++) {
				if(!vis[i]) {
					topoSortDfs(i,vis,st);
				}
			}
			
			// Step 2 : Make dis[] array initialize all of them with INF and dis[src]=0
			int dis[]=new int[graph.length];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[src]=0;
			
			// Step 3 : pull out elements from stack 1by1
			while(!st.isEmpty()) {
				int vert=st.pop();
				
				if(dis[vert]!=Integer.MAX_VALUE) {
					for(Tripy adj: graph[vert]) {
						dis[adj.curr]=Math.min(dis[adj.curr], dis[vert]+adj.wt);
					}
				}
			}
			System.out.println("Shortest path in DAG with weights using TopoSort : "+ Arrays.toString(dis));
		}
// 13. Shortest path in DAG using TopoSort ENDS
```
# Step 15 : Shortest path in UG using PQ Dijkstra's Algorithms Starts
**[Video Reference](https://youtu.be/jbhuqIASjoM)**
- Same concept as Step 13 as in Step 13 there was same weight all over the edges so we used Queue now edges are of different weight, so we used MINPQ to priotrise the small path.
```java
// 14. Shortest path in UG #Dijkstra's Algorithms Starts
		class Pair implements Comparable<Pair>{
			int curr;
			int disFsrc;
			public Pair(int curr,int dis) {
				this.curr=curr;
				disFsrc=dis;
			}
			@Override
			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				return this.disFsrc-o.disFsrc;
			}
		}
		
		public void sPathUg(int src) {
			// Step 1 : Initialize dis[] array with INF value
			int dis[]=new int[graph.length];
			Arrays.fill(dis, Integer.MAX_VALUE);
			dis[src]=0;
			// Step 2 : Make PQ and add source
			PriorityQueue<Pair> pq=new PriorityQueue<>();
			pq.add(new Pair(src,0));
			// Step 3 : Traverse PQ
			while(!pq.isEmpty()) {
				Pair vert=pq.remove();
				for(Tripy adj: graph[vert.curr]) {
					if(dis[adj.curr] > vert.disFsrc+adj.wt) {
						dis[adj.curr]=vert.disFsrc+adj.wt;
						pq.add(new Pair(adj.curr,dis[adj.curr]));
					}
				}
			}
			System.out.println("Shortest path in UG with weights using PQ : "+ Arrays.toString(dis));
		}
	// 14. Shortest path in UG #Dijkstra's Algorithms Ends
```
# Step 16 : Minimum Spanning Tree - Prim's Algorithm
**[Video Reference](https://youtu.be/Vw-sktU1zmc)**
- Same as Dijkstra there we use to calculate Minimum Path from Source here we are taking Minimum Weight Edges to connect all the vertices to each other such that every vertices is accesible from each vertex.
```java
// 15. MST - Prim's Algorithm Starts
		public void mstPrims() {
			boolean vis[]=new boolean[graph.length];
			int parent[]=new int[graph.length]; // here we will store parents of each vertex
			
			// Step 1 : Make PQ
			PriorityQueue<Tripy> pq=new PriorityQueue<>();
			pq.add(new Tripy(0,-1,0));
			
			// Step 2 : Traverse in PQ
			while(!pq.isEmpty()) {
				Tripy vert=pq.remove(); // remove
				if(!vis[vert.curr]) {
					vis[vert.curr]=true; // mark
					parent[vert.curr]=vert.par; // work
					// Now add
					for(Tripy adj: graph[vert.curr]) {
						if(!vis[adj.curr]) {
							pq.add(adj);
						}
					}
				}
			}
			System.out.println("Minimum Spanning Tree using Prim's Algo : "+ Arrays.toString(parent));
		}
	// 15. MST - Prim's Algorithm Ends
``` 
# Step 17 : Minimum Spanning Tree - Kruskal's Algorithm
- **[Video Reference for disjoint set](https://youtu.be/3gbO7FDYNFQ)**
- **[Video Reference for Kruskal's algo](https://youtu.be/1KRmCzBl_mQ)**
```java
// 16. MST - Kruskal's Algorithm Starts
		// disjointSet() Starts
			private void make(int parent[]) {
				for(int i=0; i<parent.length; i++)
					parent[i]=i;
			}
			private int findPar(int node, int parent[]) {
				if(node==parent[node]) return node;
				return parent[node]=findPar(parent[node],parent);
			}
			private void union(int u, int v, int parent[], int rank[]) {
				int pu=findPar(u,parent);
				int pv=findPar(v,parent);
				
				if(rank[pu]<rank[pv]) { // hey pu from now your parent is pv.
					parent[pu]=pv;
				}
				else if(rank[pv]<rank[pu]) { // hey pv from now your parent is pu.
					parent[pv]=pu;
				}
				else {
					parent[pv]=pu;
					rank[pu]++;
				}
			}
		// disjointSet() Ends
		ArrayList<Tripy> edges=new ArrayList<>();
		public void addEdgeK(int par, int curr, int wt) {
			edges.add(new Tripy(curr,par,wt));
		}
		public void mstKruskal() {
			// Step 1 : sort arrayList of edges weight wise
			Collections.sort(edges);
			// Step 2 : set the vertices as selfParents & Initialize rank.
			int rank[]=new int[graph.length];
			int parent[]=new int[graph.length];
			make(parent);
			// Making outputParent
			int outParent[]=new int[graph.length];
			outParent[0]=-1;
			//Step 3 : Traverse in edges AL
			for(Tripy edge : edges) {
				if(findPar(edge.curr,parent)!=findPar(edge.par,parent)) {
					union(edge.curr,edge.par,parent,rank);
					outParent[edge.curr]=edge.par;
				}
			}
			System.out.println("Minimum Spanning Tree using Kruskal's Algo : "+ Arrays.toString(outParent));
		}
	// 16. MST - Kruskal's Algorithm Ends
```
# Step 18 : Bridge in graph + articulation points in UG using DFS
- **[Video Reference for Bridge in Graph](https://youtu.be/2rjZH0-2lhk)**
## Analogy for bridge in Graph
```
Take this analogy:-

Treat this full graph as a College:-
Where each Student has it's:-
admission time & connection.

Now tumhre(you're in 2nd sem) 2 dost hai(one is in 3rdsem, other in 4thsem ) jiske through tum college 
k information updated rhte hoe.

now 3rdSem friend will blackmail you "ye kaam krdo, wrna link todhdenge tumse aur fir tum alag hojaoge college se "
you will say "oye jao jake dekho mere connections list meh kon kon h, tumse senior senior friend bana ke rkhe hai"

here senior means nodes who took admission before that node.
```
```java
// 17. Bridges in undirectedGraph + Articulation Points Starts
			public void bridgeUgDfs() {
				
				boolean vis[]=new boolean[graph.length];
				int tad[]=new int[graph.length]; // timeOfAdmission
				int connections[]=new int[graph.length];
				boolean aPoint[]=new boolean[graph.length];
				int timer=0;
				System.out.println("Bridges in Graphs are :-");
				for(int i=0; i<graph.length; i++) {
					if(!vis[i]) bridgeDfs(i,-1,vis,tad,connections,timer,aPoint);
				}
				
				System.out.println("Articulation Points:-");
				for(int i=0;i<graph.length;i++) {
					if(aPoint[i])
						System.out.print(i+" ");
				}
				System.out.println();
			}
			private void bridgeDfs(int node, int parent, boolean vis[],int tad[], int connection[],int timer, boolean aPoint[]) {
				vis[node]=true;
				tad[node]=connection[node]=timer++;
				
				for(Integer adj: graph[node]) {
					if(adj==parent) continue;
					
					if(!vis[adj]) {
						bridgeDfs(adj,node,vis,tad,connection,timer,aPoint);
						connection[node]=Math.min(connection[node], connection[adj]);
						if(tad[node]<connection[adj]) {
							System.out.println("("+node+", "+adj+") ");
							aPoint[node]=aPoint[adj]=true;
						}
					}
					else {
						connection[node]=Math.min(connection[node], connection[adj]);
					}
				}
			}
// 17. Bridges in undirectedGraph + Articulation Points Ends
```
# Step 19 : Strongly Connected Components in DG using reverse DFS.
### **Intutions :**  I run forloop from n to 1 and in each itteration dfs() will be called ( in reverse order..) and in each dfs call, we will print value and as soon as component changes then add new line. **All I mean is I do dfs print in reverse order Bcz as it is a DG so if there is a cycle then all elements in cycle is SCC and if not cycle then each node itself is a SCC.**

```java
// 18. SCC(Self) Starts
			// here we are doing reverse DFS
			public void printSccDgDfs() {
				boolean vis[]=new boolean[graph.length];
				System.out.println("Strongly Connected components are :-");
				for(int i=graph.length-1; i>=0; i--) {
					if(!vis[i]) scc(i,vis);
					else continue;
					System.out.println();
				}
				System.out.println();
			}
			private void scc(int vert, boolean vis[]) {
				vis[vert]=true;
				System.out.print(vert+ " ");
				for(Integer adj: graph[vert]) {
					if(!vis[adj]) scc(adj,vis);
				}
			}
// 18. SCC(Self) Ends
```
# Step 20 : Shortest path In DG using -VE weights #BellmanfordALgo
- **[Video Reference](https://youtu.be/75yC1vbS8S8)**
```java
// 19 ShortestPath-DG(containing +ve,-ve weights) BellmanFord's Algorithm STARTS
			ArrayList<Tripy> edgeB=new ArrayList<>();
			public void addEdgeB(int par, int curr, int wt) {
				edgeB.add(new Tripy(curr,par,wt));
			}
			public void ShortestPathDGBellman(int src) {
				System.out.println("Shortest Path for DG with -ve weights :-");
				int dis[]=new int[graph.length];
					
				final int INF=999999;
				Arrays.fill(dis,INF);
				dis[src]=0;
				// Step 1 : 1st relaxation
				for(int i=1;i<graph.length;i++) {
					for(Tripy ege:edgeB) {
						if(dis[ege.par]+ege.wt<dis[ege.curr])
							dis[ege.curr]=dis[ege.par]+ege.wt;
					}
				}
				// Step 2 : 2nd relaxation for checking -Ve cycle
				for(Tripy ege:edgeB) {
					if(dis[ege.par]+ege.wt<dis[ege.curr])
					{	System.out.println("NEGATIVE CYCLE FOUND"); return;}
				}
				System.out.println(Arrays.toString(dis)); 
			}
	// 19 ShortestPath-DG(containing +ve,-ve weights) BellmanFord's Algorithm ENDS	
```

# **[See My Full Code Here](./MyGraphy.java)**

**<H1 align="center">Thank You</H1>**
