![](https://cdn.shortpixel.ai/client/to_avif,q_glossy,ret_img,w_954/https://simplesnippets.tech/wp-content/uploads/2020/10/real-world-tree-diagram.png)

# **TREE TERMS :-**

1. **Root** – Root is a special node in a tree. The entire tree is referenced through it. It does not have a parent.
2. **Parent Node** – Parent node is an immediate predecessor of a node.
3. **Child Node** – All immediate successors of a node are its children.
4. **Siblings** – Nodes with the same parent are called Siblings.
5. **Leaf** – Last node in the tree. There is no node after this node.
6. **Edge** – Edge is a connection between one node to another. It is a line between two nodes or a node and a leaf.
7. **Path** – Path is a number of successive edges from source node to destination node.

# **TREE PROPERTIES :-**

1. Tree can be termed as a RECURSIVE data structure.
2. In a valid tree for N Nodes we have N-1 Edges/Links
3. **Depth (or LEVEL) of Node** – Depth of a node represents the number of edges from the tree’s root node to the node.
4. **Height of Node** – Height of a node is the number of edges on the longest path between that node & a leaf.
5. **Height of Tree** – Height of tree represents the height of its root node.

## **Visualize above terms here**

![](https://i.ibb.co/NyFwKpL/Tree-DS.png)

# **BINARY TREE DS**

A binary tree is a tree data structure in which each node has **at most two children,** which are referred to as the left child(LC) and the right child(RC).

# **BINARY TREE TERMS/PROPERTIES :-**

1. **Strict/Proper BT -** Binary tree where each node has 2 or 0 children.
2. **Complete BT -** Binary tree where all levels except the last are completely filled orelse if any levels are partially filled then all nodes in that level should be as left as possible.
   ![](https://i.ibb.co/bd3fyYk/BT-DS-1.png)
3. **Perfect BT -** Binary tree where each node has 2 children, **except leaf nodes.**
4. **Balance BT -** Binary tree where the difference between the height of left subtree and right subtree for every node is not more than k(usually k=1).
   **Travesal in balanced BT is more efficient than unbalanced BT.**
   ![](https://i.ibb.co/nPNZn9W/BT-DS-2.png)
5. Max number of nodes at a given level **‘x’ = 2^x**
6. For a binary tree, **maximum number of nodes** with height ‘h’ = **2^(h+1) – 1**

# **BINARY TREE IMPLEMENTATIONS VIEWS**

![](https://cdn.shortpixel.ai/client/to_avif,q_glossy,ret_img,w_1010/https://simplesnippets.tech/wp-content/uploads/2020/10/binary-tree-logical-diagram.png)

```java
public class BinaryTree {


	public static void main(String args[]) {

		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		/*        1
		         / \
		        2   3
		*/
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		/*            1
			     / \
			    2	3
			   / \
			  4   5
		*/
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		/*            1
			    /   \
			   2	 3
			  / \   / \
			 4   5 6   7
		*/
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int val) {
		data=val;
		left=right=null;
	}
}
```

![](https://cdn.shortpixel.ai/client/to_avif,q_glossy,ret_img,w_892/https://simplesnippets.tech/wp-content/uploads/2020/10/binary-tree-as-array-implementation-diagram.png)

### **[Video Reference of Tree DS.](https://youtu.be/URRNruf2yVk)**

### **[Video Reference of Binary Tree DS.](https://youtu.be/zW4JZt6Wud8)**
