class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                Node current = nodesQueue.remove();
                for (Node child : current.children) 
                    nodesQueue.add(child);
                level.add(current.val);
            }
            ans.add(level);
        }
        return ans;
    }
}