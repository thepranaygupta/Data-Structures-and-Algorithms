##  Rat in a Maze Problem - I 
### https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
Find all possible paths that the rat can take to reach from source to destination. 
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). 
Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.

Note: In a path, no cell can be visited more than one time.

```
Input 1:
N = 4
m[][] = { {1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1} }

Output 1:
DDRDRR DRDDRR
```

Explanation 1:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - `DRDDRR` 
and `DDRDRR`, when printed in sorted order 
we get `DDRDRR DRDDRR`.

```
Input 2:
N = 2
m[][] = { {1, 0}, {1, 0} }

Output 2:
-1
```

Explanation 2:
No path exists and destination cell is 
blocked.
