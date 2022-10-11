class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        
        dfs(root, 0, res);
        
        return res;
    }
    
    public void dfs(Node root, int level, List<List<Integer>> res){
        if(root==null){
            return;
        }
        
        if(res.size()<level+1){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        for(Node child : root.children){
            dfs(child, level+1, res);
        }
    }
}