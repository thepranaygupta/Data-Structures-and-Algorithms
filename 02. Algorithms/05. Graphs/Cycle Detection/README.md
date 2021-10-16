# Description 
Detect cycle in an undirected graph.<br/>
Given an Undirected Graph. Check whether it contains a cycle or not. <br/>

# Format:
### Input:
The first line of input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. <br/>
Each test case consists of two lines. Description of test cases are as follows: The first line of each test case contains two integers 'N' and 'M'. Which denotes the number of vertices and number of edges respectively. <br/>
The Second line of each test case contains 'M'  space-separated pairs u and v <br/>
denoting that there is a bidirectional edge from u to v.<br/>

### Output:
The method should return 1 if there is a cycle else it should return 0.<br/>

### Constraints:
1 <= T <= 100<br/>
2 <= N <= 104<br/>
1 <= M <= (N*(N-1))/2<br/>
0 <= u, v <= N-1<br/>
The graph doesn't contain multiple edges and self-loops.<br/>

## Example:
#### Input:
3<br/>
2 1<br/>
0 1<br/>
<br/>
4 3<br/>
0 1 1 2 2 3<br/>
<br/>
5 4<br/>
0 1 2 3 3 4 4 2<br/>

#### Output:
0<br/>
0<br/>
1<br/>

## Explanation:
##### Testcase 1: There is a graph with 2 vertices and 1 edge from 0 to 1. So there is no cycle.<br/>
##### Testcase 2: There is a graph with 3 vertices and 3 edges from 0 to 1, 1 to 2, and 2 to 3.<br/>
##### Testcase 3: There is a cycle in the given graph formed by vertices 2, 3, and 4.<br/>


<br/><br/>
## OUTPUT-:
![Screenshot (3054)](https://user-images.githubusercontent.com/64676594/137593739-2d2d8682-abb8-49c5-bbe8-386b669a0142.png)

