## Problem Description

* Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

* Problem Link

[Problem Description](https://practice.geeksforgeeks.org/problems/topological-sort/1)

* Time Complexity

- O(V + E) where V = vertices and E = edges

* Space Complexity

- O(V) + O(V) + O(V) + O(V + E) where we uses an extra array for indegree storing, queue for storing nodes, array for storing result and for the adjacency list