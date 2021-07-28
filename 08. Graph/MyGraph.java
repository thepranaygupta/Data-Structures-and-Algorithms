package graphs;

import java.util.*;

public class MyGraph {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Vertices & Edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();
		if(e > v*(v-1)/2) {
			System.out.println("Invalid Edge");
			return;
		}
		
		Graph1 g1 = new Graph1(v);
		
		System.out.println("1. Add Edge in Undirected Graph");
		System.out.println("1. Add Edge in Directed Graph");
		System.out.print("Enter Your Choice: ");
		int choice = sc.nextInt();
		
		for(int i = 0; i<e; i++) {
			System.out.println("Enter Source and Destination: ");
			int source = sc.nextInt();
			int destination = sc.nextInt();
			if(choice == 1)
				g1.addEdgeU(source, destination);
			else if(choice == 2)
				g1.addEdgeD(source, destination);
		}
		g1.printAdjacencyList();
		
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
		for(int i = 0; i < graph.length; i++) {
			System.out.print(i + "-->");
			int j = 0;
			while(j < graph[i].size()) {
				System.out.print(graph[i].get(j) + " ");
				j++;
			}
			System.out.println();
		}
	}
}