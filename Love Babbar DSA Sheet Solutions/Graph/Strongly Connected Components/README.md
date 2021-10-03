# Count Strongly Connected Components using Kosaraju Algorithm

Link : https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

## Problem

Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges. Find the number of strongly connected components in the graph.

## Example

<em>`Input`</em> : 5 5</br>
1 0</br>
0 2</br>
2 1</br>
0 3</br>
3 4</br>

<em>`Output`</em> : 3

<p align="center"> <img src="https://user-images.githubusercontent.com/61552413/135741920-8b441174-ab64-4586-ab2d-4c856aff8abf.png" height="350"> </p>

## Approach

A strongly connected component of a graph is a component having a path between all pairs of vertices.</br>
In the <strong>Kosaraju algorithm</strong>, we use DFS two times. In the above example, suppose we want to start from vertex 4 (sink vertex) and then 3 and then {0, 1, 2} (source) but there is no direct way of obtaining such a sequence.</br>
To obtain this, we do a DFS traversal of the graph and store vertices according to their finish times i.e. finish time of 0 vertex will always be greater than the finish time of vertex 3 or 4. Therefore, we do DFS traversal and push that vertex when all its corresponding exploration is finished.</br>
Now, we'll reverse the edges. This would make vertices (0, 1, 2) as sink and (4) as the source. If we do a DFS of the reversed graph using sequence of vertices in the stack then, this would now help us segregate different strongly connected components and we could count them.

<strong>Time Complexity :</strong> O(V+E)
