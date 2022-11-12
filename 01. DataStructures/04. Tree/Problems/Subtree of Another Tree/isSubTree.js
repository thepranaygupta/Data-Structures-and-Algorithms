// problem link https://leetcode.com/problems/subtree-of-another-tree/

var isSubtree = function(root, subRoot) {
    
    const rootArr = [];
    const subRootArr = [];

    function dfs(root, currentArr) {
        root ? currentArr.push( "0" + root.val) : currentArr.push('n');
        if(!root) return;
     
        dfs(root.left, currentArr);
        dfs(root.right, currentArr);
    }

    dfs(root, rootArr);
    dfs(subRoot, subRootArr);
    console.log(rootArr, subRootArr);
    return rootArr.join('').includes(subRootArr.join(''));
};
