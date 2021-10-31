**What is BFS Algorithm (Breadth-First Search)?**

Breadth-first search (BFS) is an algorithm that is used to graph data or searching tree or traversing structures. The full form of BFS is the Breadth-first search.

The algorithm efficiently visits and marks all the key nodes in a graph in an accurate breadthwise fashion. This algorithm selects a single node (initial or source point) in a graph and then visits all the nodes adjacent to the selected node. Remember, BFS accesses these nodes one by one.

Once the algorithm visits and marks the starting node, then it moves towards the nearest unvisited nodes and analyses them. Once visited, all nodes are marked. These iterations continue until all the nodes of the graph have been successfully visited and marked.


**How does BFS Algorithm Work?**

Graph traversal requires the algorithm to visit, check, and/or update every single un-visited node in a tree-like structure. Graph traversals are categorized by the order in which they visit the nodes on the graph.

BFS algorithm starts the operation from the first or starting node in a graph and traverses it thoroughly. Once it successfully traverses the initial node, then the next non-traversed vertex in the graph is visited and marked.

Hence, you can say that all the nodes adjacent to the current vertex are visited and traversed in the first iteration. A simple queue methodology is utilized to implement the working of a BFS algorithm, and it consists of the following steps:

- Step 1) Each vertex or node in the graph is known. For instance, you can mark the node as V.

- Step 2) In case the vertex V is not accessed then add the vertex V into the BFS Queue

- Step 3) Start the BFS search, and after completion, Mark vertex V as visited.

- Step 4) The BFS queue is still not empty, hence remove the vertex V of the graph from the queue.

- Step 5) Retrieve all the remaining vertices on the graph that are adjacent to the vertex V

- Step 6) For each adjacent vertex let’s say V1, in case it is not visited yet then add V1 to the BFS queue

- Step 7) BFS will visit V1 and mark it as visited and delete it from the queue.

Traversing iterations are repeated until all nodes are visited.

**Rules of BFS Algorithm**

Here, are important rules for using BFS algorithm:
A queue (FIFO-First in First Out) data structure is used by BFS.
You mark any node in the graph as root and start traversing the data from it.
BFS traverses all the nodes in the graph and keeps dropping them as completed.
BFS visits an adjacent unvisited node, marks it as done, and inserts it into a queue.
Removes the previous vertex from the queue in case no adjacent vertex is found.
BFS algorithm iterates until all the vertices in the graph are successfully traversed and marked as completed.
There are no loops caused by BFS during the traversing of data from any node.
