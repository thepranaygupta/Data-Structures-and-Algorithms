'''
Aim: To implement depth first search.
''' 

# Graph class created
class Graph:

    def __init__(self):
        # graph declared to a dictionary
        self.graph = {}
        # visited nodes are maintained in this set
        self.visited = set()

    def add_vertex(self, vertex):
        # vertex is added to the graph dictionary and it's adjacency list is declared
        self.graph[vertex] = []
    
    def add_edge(self, source, destination):
        # directional edges are added in this function
        # the edge is directional, i.e., going from source to destination

        # conditional statements in case the vertex aren't present in the graph
        if destination not in self.graph or source not in self.graph:
            if source not in self.graph:
                print(str(source)+' is not a vertex')    
                # 1 is returned to avoid stopping the running of the program allows the user to re-enter values
                return 1 
            if destination not in self.graph:
                print('\n'+str(destination)+' is not a vertex.')
                # 1 is returned to avoid stopping the running of the program allows the user to re-enter values
                return 1     

        # edge is added to the graph, from source to destination
        self.graph[source].append(destination)

    def add_edge_bidirected(self, vertex1, vertex2):
        # bidirectional graph edges are added in this function
        # the edge is bidirectional, i.e., the edge goes both ways

        # conditional statements to check if the vertices are present
        if vertex2 not in self.graph or vertex1 not in self.graph:
            if vertex1 not in self.graph:
                print('\n'+str(vertex1)+' is not a vertex'+'\n')
                return 1    # 1 is returned to avoid stopping the running of the program allows the user to re-enter values
            if destination not in self.graph:
                print('\n'+str(vertex2)+' is not a vertex.'+'\n')
                return 1    # 1 is returned to avoid stopping the running of the program allows the user to re-enter values
        
        # edges are added to the adjacency list
        self.graph[vertex1].append(vertex2)
        self.graph[vertex2].append(vertex1)

    def dfs_helper(self, start):
        # function to assist in calling dfs
        # also prints the final dfs traversal

        # checks if the start node is in the graph
        if start not in self.graph:
            print('\n'+str(start)+' not in graph.'+'\n')
            # 1 is returned to avoid stopping the running of the program,
            # allows the user to re-enter the start vertex
            return 1 
        
        # dfs implementation starts
        print('\n'+'Implementing DFS...')
        # the dfs traversal is appended to the list at each visit
        self.traversal = [] 
        self.dfs(start)

        traversal_length = len(self.traversal)
        # prints the dfs implementation neatly
        for i in range(traversal_length):
            if i == (traversal_length-1):
                print(str(self.traversal[i]))
            else:
                print(str(self.traversal[i])+' -> ',end="")
            
    def dfs(self, node):
        # dfs function
        if node not in self.visited:            # checks if the node was already visited
            self.traversal.append(node)         # if the node wasn't visited, it's added to the traversal
            self.visited.add(node)              # the node is marked visited
            for neighbour in self.graph[node]:  # neighbouring vertices are explored one after the other     
                self.dfs(neighbour)
        
# Code Implementation starts here
if __name__ == "__main__":
    # To Implement Depth-First Search for Bi-Directional Graphs,
    # replace G.add_edge in lines 99 and 105 with G.add_edge_bidirectional

    # Graph instance is created
    G = Graph()

    # Number of vertices in the graph is read from user input
    number_of_vertices = int(input('How many vertices are in the graph? '))

    # vertices are added to the graph
    for v in range(number_of_vertices):
        G.add_vertex(str(input("Enter Vertex: ")))

    # Number of edges in the graph read from user input
    number_of_edges = int(input('\n'+'How many edges are in the Graph? '))

    # edges are added to the graph
    for e in range(number_of_edges):
        source, destination = input("Enter Source and Destination vertices separated by a space: ").split()
        val = G.add_edge(source, destination)

        # If the incorrecct vertex was given, the values are taken again for this iteration
        # This is added to not skip over a count of the edge
        while val == 1:
            source, destination = input("Enter Source and Destination vertices separated by a space: ").split()
            val = G.add_edge(source, destination)

    # start node for the dfs traversal is taken from the user
    start_node = input('\n'+"Enter the Start Node for traversal: ")

    # dfs is implemented
    return_value = G.dfs_helper(start_node)

    # If the user entered a non-existent vertex as start node, the following is implemented
    # 1 is returned if the vertex is non existent
    while (return_value == 1):
        start_node = input('\n'+"Enter the Start Node for traversal: ")
        return_value = G.dfs_helper(start_node)

'''
COMPLEXITY:
    
     Time Complexity: O(V+E)
                      V is the number of vertices and E is the number of edges
     Space Complexity: O(V)
                       V is the number of vertices
Sample Working:
    
DFS Implementation for the Adjacency List Given Below
{
    'A': ['B','C'],
    'B': ['D'],
    'C': ['F'],
    'D': ['E'],
    'E': [],
    'F': [],
}
Sample Input:
    
How many vertices are in the graph? 6
Enter Vertex: A
Enter Vertex: B
Enter Vertex: C
Enter Vertex: D
Enter Vertex: E
Enter Vertex: F
How many edges are in the Graph? 5
Enter Source and Destination Vertices separated by a space: A B
Enter Source and Destination Vertices separated by a space: A C
Enter Source and Destination Vertices separated by a space: B D
Enter Source and Destination Vertices separated by a space: C F
Enter Source and Destination Vertices separated by a space: D E
Enter the Start Node for traversal: A
Implementing DFS...       
Sample Output:
    
A -> B -> D -> E -> C -> F
'''
