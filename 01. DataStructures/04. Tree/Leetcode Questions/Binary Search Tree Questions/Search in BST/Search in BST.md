# Ceil in BST

**Problem Link :- https://leetcode.com/problems/search-in-a-binary-search-tree/**

<span>
<img src="https://user-images.githubusercontent.com/93209316/183753945-f44c129e-ab24-46aa-bf59-123f656b5d1e.png" width=410px/>
<img src="https://user-images.githubusercontent.com/93209316/183753968-1f6741f0-dfcc-4dc5-a180-e6bcfb644e63.png" width=400px/>
</span>

<br>
<hr>
**Approach:-**

1.For Searching element in Tree we can use any type of traversal like inorder, preorder, postorder, levelorder.but the worst time complexity is O(n) for this traversals.

2.We can use Binary Search Tree property to find the element in the O(height) => O(log N) time complexity.

3.We willl make use of ptoperty of BST which is Left key will be always smaller than the root key and right key will be always greater than the root key.

4.So if root.val > val then we will search in left subtree else(root.val < val) we will search in right subtree.
<hr>

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
