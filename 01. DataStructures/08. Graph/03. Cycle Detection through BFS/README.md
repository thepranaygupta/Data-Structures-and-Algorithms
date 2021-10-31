**Detect Cycle in a Directed Graph**

Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle, else return false. For example, the following graph contains two cycles 0->1->2->3->0 and 2->4->2, so your function must return true.

**Algorithm**
Steps involved in detecting cycle in a directed graph using BFS.
- Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the graph and initialize the count of visited nodes as 0.
- Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)
- Step-3: Remove a vertex from the queue (Dequeue operation) and then. 

-- Increment count of visited nodes by 1.
-- Decrease in-degree by 1 for all its neighboring nodes.
-- If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
- Step 4: Repeat Step 3 until the queue is empty.
- Step 5: If count of visited nodes is not equal to the number of nodes in the graph has cycle, otherwise not.


Steps involved in detecting cycle in a directed graph using DFS.
- Create the graph using the given number of edges and vertices.
- Create a recursive function that initializes the current index or vertex, visited, and recursion stack.
- Mark the current node as visited and also mark the index in recursion stack.
- Find all the vertices which are not visited and are adjacent to the current node. Recursively call the function for those vertices, If the recursive function returns true, return true.
- If the adjacent vertices are already marked in the recursion stack then return true.
- Create a wrapper class, that calls the recursive function for all the vertices and if any function returns true return true. Else if for all vertices the function returns false return false.