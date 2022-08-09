# Ceil in BST

**Problem Link :- https://leetcode.com/problems/search-in-a-binary-search-tree/**

**Input: root = [4,2,7,1,3], val = 2**
**Output: [2,1,3]**

**Approach:-**
1.For Searching element in Tree we can use any type of traversal like inorder, preorder, postorder, levelorder.but the worst time complexity is O(n) for this traversals.
2.We can use Binary Search Tree property to find the element in the O(height) => O(log N) time complexity.
3.We willl make use of ptoperty of BST which is Left key will be always smaller than the root key and right key will be always greater than the root key.
4.So if root.val > val then we will search in left subtree else(root.val < val) we will search in right subtree.

**Solution:-**

```
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
       if(root == null) return null;
       if(root.val == val) return root;

       if(root.val > val){
           return searchBST(root.left,val);
       }else{
           return searchBST(root.right,val);
       }
    }
}
```

**Solution Contributed by Sanket Jagdale | [Github](https://github.com/Sanket00900) | [LinkedIn](https://www.linkedin.com/in/sanketjagdale09/)**
