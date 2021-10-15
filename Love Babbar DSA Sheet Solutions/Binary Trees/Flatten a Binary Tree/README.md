Link to solve this problem on Gfg.<br>
<a href="https://practice.geeksforgeeks.org/problems/flatten-binary-tree-to-linked-list/1">Click Here</a>

<b>Problem:</b><p>Given a binary tree, flatten it into linked list in-place.After flattening, left of each node should point to NULL and right should contain next node in preorder.</p>

<b>Algorithm to solve</b>: <p>
<ul>
  <li>Recursively flatten the left and the right subtree</li>
  <li>Store the left and the right tail</li>
  <li>Start the right subtree in temp and make left subtree as right subtree</li>
  <li>Join right subtree with left tail</li>
  <li>Return right tail</li>
</ul>
</p>

