// problem link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

function findPath(root,target) {

    const pathArr = [];
    dfs(root);

    function dfs(root) {

        if(!root) return false;
        pathArr.push(root.val);

        if(root.val === target) {
            return true;
        }

        if(dfs(root.left) || dfs(root.right)) {
            return true;
        }
        pathArr.pop();
        return false;
    }
   
    return pathArr;
}


var lowestCommonAncestor = function(root, p, q) {

    const qPath = findPath(root, q.val);
    const pPath = findPath(root, p.val);

console.log(qPath, pPath);
    const maxLen = Math.max(pPath.length, qPath.length);
    
    for(let  i = 0; i < maxLen; i++) {
        if(pPath[i] !== qPath[i]) {
            return pPath[i - 1];
        }
    }    
};
