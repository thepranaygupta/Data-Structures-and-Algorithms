

var maxDepth = function(root) {
   
   if(!root) return 0;
   let current = 0;
   let max = 0;

    function dfs(root, current) {
        if(!root) return;
        
        if(!root.left && !root.right) {
            max = Math.max(current, max);
            return;
        }

        dfs(root.left, current + 1);
        dfs(root.right, current + 1);

    }

   dfs(root, current + 1);
   return max;
};
