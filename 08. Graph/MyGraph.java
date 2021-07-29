package graphs;

import java.util.*;

public class MyGraph {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Vertices & Edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();
		if (e > v * (v - 1) / 2) {
			System.out.println("Invalid Edge");
			return;
		}

		Graph1 g1 = new Graph1(v);

		System.out.println("1. Add Edge in Undirected Graph");
		System.out.println("1. Add Edge in Directed Graph");
		System.out.print("Enter Your Choice: ");
		int choice = sc.nextInt();

		for (int i = 0; i < e; i++) {
			System.out.println("Enter Source and Destination: ");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			if (choice == 1)
				g1.addEdgeU(source, destination);
			else if (choice == 2)
				g1.addEdgeD(source, destination);
		}
		g1.printAdjacencyList();
		g1.printBFS();
		g1.printDFS();

		if (choice == 1) {
			System.out.println("Cycle Detected  in Undirected Graph using BFS= " + g1.isCycleBfsUg());
			System.out.println("Cycle Detected  in Undirected Graph using DFS= " + g1.isCycleDfsUg());
		}

	}

}

class Graph1 {

	private ArrayList<Integer> graph[];

	public Graph1(int v) {
		graph = new ArrayList[v];
		for (int i = 0; i < v; i++)
			graph[i] = new ArrayList<>();
	}

	public void addEdgeU(int source, int destination) {
		graph[source].add(destination);
		graph[destination].add(source);
	}

	public void addEdgeD(int source, int destination) {
		graph[source].add(destination);
	}

	public void printAdjacencyList() {
		System.out.println("Adjacency List:");
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + "--> ");
			int j = 0;
			while (j < graph[i].size()) {
				System.out.print(graph[i].get(j) + "  ");
				j++;
			}
			System.out.println();
		}
	}

// START BFS
	public void printBFS() {
		System.out.println("BFS Traversal: ");
		boolean vis[] = new boolean[graph.length]; // visited array
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				vis[i] = true; // mark the node as visited

				while (!q.isEmpty()) {
					int vert = q.poll();
					System.out.print(vert + " ");
					for (Integer adj : graph[vert]) {
						if (!vis[adj]) {
							vis[adj] = true;
							q.add(adj);
						}
					}
				}
			}
		}
		System.out.println();
	}
// END DFS

// START printDFS
	public void printDFS() {
		System.out.println("DFS Traversal:");
		boolean vis[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				dfs(i, vis);
			}
		}
		System.out.println();
	}

	private void dfs(int vert, boolean vis[]) {
		vis[vert] = true;
		System.out.print(vert + " ");

		for (Integer adj : graph[vert]) {
			if (!vis[adj]) {
				dfs(adj, vis);
			}
		}
	}
// END DFS

// START Cycle Detection in Undirected Graph using BFS
	class Pair {
		int current;
		int parent;

		public Pair(int curr, int par) {
			current = curr;
			parent = par;
		}
	}

	private boolean cycleBfsUg(int i, boolean vis[]) {
		vis[i] = true;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, -1));

		while (!q.isEmpty()) {
			int vert = q.peek().current;
			int par = q.poll().parent;

			for (Integer adj : graph[vert]) {
				if (!vis[adj]) {
					vis[adj] = true;
					q.add(new Pair(adj, vert));
				} else if (vis[adj] && adj != par)
					return true;
			}
		}
		return false;
	}
	
	public boolean isCycleBfsUg() {
		boolean vis[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i])
				if (cycleBfsUg(i, vis))
					return true;
		}
		return false;
	}
// END Cycle Detection in Undirected Graph using BFS

// START Cycle Detection in Undirected Graph using DFS
	private boolean cycleDfsUg(int vert, int parent, boolean vis[]) {
		vis[vert] = true;
		for (Integer adj : graph[vert]) {
			if (!vis[adj]) {
				if (cycleDfsUg(adj, vert, vis))
					return true;
			} else if (adj != parent)
				return true;
		}
		return false;
	}
	
	public boolean isCycleDfsUg() {
		boolean vis[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			if (!vis[i]) {
				if (cycleDfsUg(i, -1, vis))
					return true;
			}
		}
		return false;
	}
// END Cycle Detection in Undirected Graph using DFS
}
