# Count Strongly Connected Components using Kosaraju Algorithm

Link : https://practice.geeksforgeeks.org/problems/bipartite-graph/1

## Problem

Given a Undirected Graph with V vertices (Numbered from 0 to V-1) and E edges. Check whether it is Bipartite or Not.

## Example 1

<em>`Input`</em> : 3 2</br>
0 1</br>
1 2</br>

<em>`Output`</em> : 1

## Example 2

<em>`Input`</em> : 4 4</br>
0 2</br>
0 3</br>
2 3</br>
3 1</br>

<em>`Output`</em> : 0

## Approach

A bipartite graph is a graph whose vertices can be divided into two <strong>disjoint sets</strong> so that every edge connects two vertices from different sets (i.e. there are no edges which connect vertices from the same set). These sets are usually called <strong>sides</strong>.

There exists a theorem which claims that a graph is bipartite if and only if all its <strong>cycles have even length<strong>. However, in practice it's more convenient to use a different formulation of the definition: a graph is bipartite if and only if it is <strong>two-colorable</strong> i.e each adjacent node have different color.

So we run depth-first-search on the graph and assign previous visited vertex color(v) to the current visited vertex (to).
For example,
If we are going from vertex v to unvisited vertex to, we assign color[to] = !color[v]. 
If we are going from vertex v to visited vertex to, we know that both the vertex have some color assigned. So we check if color[v] == color[to]. If this condition is true than v and to have same color(which are neighbours) thus the graph is not bipartite otherwise check for rest of the graph.

<strong>Time Complexity :</strong> O(V+E)
