### To check if a list is palindrome or not

#### Problem link: https://www.interviewbit.com/problems/palindrome-list/

#### Tutorial link: https://youtu.be/yOzXms1J6Nk

Problem algorithm:

A simple solution is to use a vector of list nodes. This mainly involves three steps.

Traverse the given list from head to tail and push every visited node to vector.

Traverse the list again. For every visited node, pop a node from the vector and compare data of popped node with the currently visited node.

If all nodes matched, then return 1, else 0.
