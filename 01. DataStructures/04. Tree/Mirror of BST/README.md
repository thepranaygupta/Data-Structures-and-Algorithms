## Description 
Given a Binary Tree, convert it into its mirror.

## Format-
### Input-:
Enter values to create and BST and enter a negative value when end input.

### Output-:
First Line contains the PreOrder Sequence of Original BST
Second Line contains the PreOrder Sequence of Mirrored BST

## Constraints:
1 ≤ Number of nodes ≤ 10^5 <br/>
1 ≤ Data of a node ≤ 10^5

#### Expected Time Complexity: O(N).
#### Expected Auxiliary Space: O(Height of the Tree).


### Example 1:
#### Input: 100 50 20 70 60 80 120 110 190 -3
#### Output: 100 120 190 110 50 70 80 60 20

### Explanation: The tree is
```
       100                       100
     /     \                  /       \
    50     120   (mirror)    120       50
   /  \    /  \     =>      /   \     /  \
  20  70  110 190         190   110  70  20
     /  \                           /  \
    60  80                         80  60 
```
The preorder of mirror is 
100 120 190 110 50 70 80 60 20


#### OUTPUT-: 
![Screenshot (3055)](https://user-images.githubusercontent.com/64676594/137595404-489709ab-b4d3-438e-b572-bdbf850cc3a2.png)
