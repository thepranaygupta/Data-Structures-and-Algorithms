# **Treap**

## A treap is a binary search tree whose structure arises as if" the keys had been inserted in random order; the expected height of the tree is O(log n).
When first inserted, each key is assigned a random priority, call it p.priority. As in a standard binary tree, keys are sorted according to an
inorder traversal. But, the priorities are maintained according to heap order.
Since priorities are random, you might wonder about possibility of two priorities being equal.
This might happen, but if the domain of random numbers if much larger than n (say at least n2) then these events are so rare that they won't afect the tree's performance.