class Solution
{
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // for topological sorting, the graph must be directed acyclic graph
        // if its not mentioned, we need to make sure the graph is not having any cycke
        // if it have any cycle, then there is no topological sort ordering
        if (adj == null || adj.size() == 0) {
            return new int []{};
        }
        // algorithm using BFS to find topological sorting is Kahn's algorithm
        // here at first we find the indegree of each node
        // whichever node with zero indegree will be added onto the queue
        // now we pop each node from the queue and check for th eadjacent node
        // if there is adjacent, we reduce its indegree by one because there was a 
        // dependency for the adjacent node before but now we remove that
        // continue adding the elements into the queue with indegree 0
        // when queue becomes empty, we have our ordering
        
        int [] indegree = new int [v];
        int [] result = new int [v];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<v; i++) {
            ArrayList<Integer> children = adj.get(i);
            for (Integer child : children) {
                indegree[child] += 1;
            }
        }
        for (int i=0; i<v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int currentNode = queue.poll();
                result[index++] = currentNode;
                ArrayList<Integer> children = adj.get(currentNode);
                for (Integer child : children) {
                    indegree[child] -= 1;
                    if (indegree[child] == 0) {
                        queue.offer(child);
                    }
                }
            }
        }
        return result;
    }
}