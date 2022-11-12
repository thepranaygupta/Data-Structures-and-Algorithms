// problem link the problem is same as  inverting a binary tree: https://leetcode.com/problems/invert-binary-tree/

var invertTree = function(root) {
    
    
    function dfs(root) {
        if(!root) return root;

        dfs(root.left);
        dfs(root.right);
        swap(root);

        return root;
    }

   return dfs(root);
   
};

function swap(root) {

    const temp = root.left;
    root.left = root.right;
    root.right = temp;
}
