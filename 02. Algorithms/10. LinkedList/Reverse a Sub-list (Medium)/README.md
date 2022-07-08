Leetcode link:  https://leetcode.com/problems/reverse-linked-list-ii/

Before doing this problem, I will suggest you first do reverse linkedlist problem
Once you know how to reverse a linked list then comeback to this problem.
Here are the steps we need to follow:
Skip the first left-1 nodes, to reach the node at position left.
Remember the node at position left-1 to be used later to connect with the reversed sub-list.
Next, reverse the nodes from left to right using a technique to reverse a likedlist. then
Connect the left-1 and right+1 nodes to the reversed sub-list.

Time complexity
The time complexity of this algorithm will be O(N) where ‘N’ is the total number of nodes in the LinkedList.

Space complexity
We only used constant space, therefore, the space complexity of our algorithm is O(1).