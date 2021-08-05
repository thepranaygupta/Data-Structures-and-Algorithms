package treeDS;

import java.util.*;
import treeDS.BST.DiaPair;

public class BinaryTree {

	public static final int GLOBALSPACE = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BST bt = new BST();
		boolean flag = true;
		int inorder[];
		int preorder[];
		int postorder[];
		while (flag) {
			int val = 0;
			System.out.println();
			System.out.println("1  - Insert a Node(Iterative Approach)");
			System.out.println("2  - Insert a Node(Recursive Approach)");
			System.out.println("3  - Insert a Node(Level Order Insertion)");
			System.out.println("4  - Print 2D");
			System.out.println("5  - Height of Tree");
			System.out.println("6  - Sum of all Nodes in the Tree");
			System.out.println("7  - Total Number of Nodes in the Tree");
			System.out.println("8  - Maximum Value in the Binary Tree");
			System.out.println("9  - Print Level Order/Breadth First Search (using Queue)");
			System.out.println("10 - Print Level Order/Breadth First Search (using Recursion)");
			System.out.println("11 - Print a Certain Level of the Tree");
			System.out.println("12 - Sum of values at level K");
			System.out.println("13 - Print Pre-order Traversal");
			System.out.println("14 - Print In-order Traversal");
			System.out.println("15 - Print Post-order Traversal");
			System.out.println("16 - Print all Paths from Root to Leaf Nodes");
			System.out.println("17 - Search in Binary Search Tree(Iterative Approach)");
			System.out.println("18 - Search in Binary Search Tree(Recursive Approach)");
			System.out.println("19 - Diameter of Binary Tree (O(n^2) Approach)");
			System.out.println("20 - Diameter of Binary Tree (O(n) Approach)");
			System.out.println("21 - Delete a Node");
			System.out.println("22 - Construct BT from Pre-Order and In-Order");
			System.out.println("23 - Construct BT from Post-Order and In-Order");
			System.out.println("24 - Construct BST from In-Order");
			System.out.println("25 - Construct BST from Pre-Order");
			System.out.println("26 - Construct BST from Post-Order");
			System.out.println("27 - Check if the Binary Tree is Balanced");
			System.out.println("0  - Exit");

			int ch = sc.nextInt();
			switch (ch) {

			case 1:
				System.out.print("Enter Value to Insert: ");
				val = sc.nextInt();
				bt.insertIterative(val);
				break;

			case 2:
				System.out.print("Enter Value to Insert: ");
				val = sc.nextInt();
				bt.root = bt.insertRecursive(bt.root, val);
				break;

			case 3:
				System.out.println("Enter Value to Insert: ");
				val = sc.nextInt();
				bt.insertLevelOrder(bt.root, val);
				break;

			case 4:
				bt.print2D(bt.root, GLOBALSPACE);
				break;

			case 5:
				System.out.println("Height of the Tree is = " + bt.height(bt.root));
				break;

			case 6:
				System.out.println("Sum of all the Nodes in the Tree is = " + bt.sumOfNodes(bt.root));
				break;

			case 7:
				System.out.println("Total Number of Nodes in the Tree is = " + bt.countNodes(bt.root));
				break;

			case 8:
				System.out.println("The Maximum Value of the Binary Tree is = " + bt.maxValue(bt.root));
				break;

			case 9:
				System.out.println("The Binary Tree in Level Order/Breadth First Search (using Queue) is = ");
				bt.printLevelOrderQueue(bt.root);
				break;

			case 10:
				System.out.println("The Binary Tree in Level Order/Breadth First Search (using Recursion) is = ");
				bt.printLevelOrderRecursion(bt.root);
				break;

			case 11:
				System.out.print("Enter the Level to print Level Order: ");
				int l = sc.nextInt();
				System.out.println("The Nodes in Level-" + l + " in Level Order are:");
				bt.printGivenLevel(bt.root, l);
				break;

			case 12:
				System.out.print("Enter Level(K): ");
				val = sc.nextInt();
				bt.sum = 0;
				System.out.println("Sum of values at level K is = " + bt.sumAtK(bt.root, val));
				break;

			case 13:
				System.out.println("The Tree Nodes in Pre-Order Fashion = ");
				bt.printPreOrder(bt.root);
				break;

			case 14:
				System.out.println("The Tree Nodes in In-Order Fashion = ");
				bt.printInOrder(bt.root);
				break;

			case 15:
				System.out.println("The Tree Nodes in Post-Order Fashion = ");
				bt.printPostOrder(bt.root);
				break;

			case 16:
				System.out.println("All Paths from Root to Leaf Nodes are = ");
				bt.rootToLeaf(bt.root);
				break;

			case 17:
				System.out.print("Enter the Value to Search: ");
				val = sc.nextInt();
				if (bt.iterativeSearch(val))
					System.out.println("Value Found");
				else
					System.out.println("Value Not Found");
//				System.out.println(bt.iterativeSearch(val));
				break;

			case 18:
				System.out.print("Enter the Value to Search: ");
				val = sc.nextInt();
				if (bt.recursiveSearch(bt.root, val) == null)
					System.out.println("Value Not Found");
				else
					System.out.println("Value Found");
//				System.out.println(bt.iterativeSearch(val));
				break;

			case 19:
				System.out.println("Diameter of Binary Tree (O(n^2) Approach) is = " + bt.diameterOfBT(bt.root));
				break;

			case 20:
				DiaPair d = new DiaPair();
				d = bt.diameter(bt.root);
				System.out.println("Diameter of Binary Tree (O(n) Approach) is = " + d.dia);
				break;

			case 21:
				System.out.print("Enter Value to Delete: ");
				val = sc.nextInt();
				bt.root = bt.delete(bt.root, val);
				break;

			case 22:
				System.out.print("Enter Number of Nodes in Binary Tree: ");
				val = sc.nextInt();
				preorder = new int[val];
				inorder = new int[val];

				System.out.println("Enter Values in Pre-Order Sequence:");
				for (int i = 0; i < val; i++)
					preorder[i] = sc.nextInt();
				System.out.println("Enter Values in In-Order Sequence:");
				for (int i = 0; i < val; i++)
					inorder[i] = sc.nextInt();
				bt.root = bt.buildTreeFromInorderPreorder(preorder, inorder);
				break;

			case 23:
				System.out.print("Enter Number of Nodes in Binary Tree: ");
				val = sc.nextInt();
				postorder = new int[val];
				inorder = new int[val];

				System.out.println("Enter Values in Post-Order Sequence:");
				for (int i = 0; i < val; i++)
					postorder[i] = sc.nextInt();
				System.out.println("Enter Values in In-Order Sequence:");
				for (int i = 0; i < val; i++)
					inorder[i] = sc.nextInt();
				bt.root = bt.buildTreeFromInorderPostorder(postorder, inorder);
				break;

			case 24:
				System.out.print("Enter Number of Nodes in Binary Search Tree: ");
				val = sc.nextInt();
				inorder = new int[val];
				System.out.println("Enter Values in In-Order Sequence:");
				for (int i = 0; i < val; i++)
					inorder[i] = sc.nextInt();
				bt.root = bt.buildBSTfromInorder(inorder);
				break;

			case 25:
				System.out.print("Enter Number of Nodes in Binary Search Tree: ");
				val = sc.nextInt();
				preorder = new int[val];
				System.out.println("Enter Values in Pre-Order Sequence:");
				for (int i = 0; i < val; i++)
					preorder[i] = sc.nextInt();
				bt.root = bt.buildBSTfromPreorder(preorder);
				break;

			case 26:
				System.out.print("Enter Number of Nodes in Binary Search Tree: ");
				val = sc.nextInt();
				postorder = new int[val];
				System.out.println("Enter Values in Post-Order Sequence:");
				for (int i = 0; i < val; i++)
					postorder[i] = sc.nextInt();
				bt.root = bt.buildBSTfromPostorder(postorder);
				break;
			case 27:
				bt.height(bt.root);
				System.out.println(bt.isBal);

			case 0:
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice.");
			}
		}
	}
}

class BST {
	class Node {
		int data;
		Node left;
		Node right;

		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	Node root;

	public BST() {
		root = null;
	}

	public boolean isTreeEmpty() {
		return root == null;
	}

// START	1  - Insert a Node(Iterative Approach)
	public void insertIterative(int val) {
		Node n = new Node(val);

		if (isTreeEmpty()) {
			root = n;
			System.out.println("Value Inserted as the Root Node.");
		}

		else {
			Node temp = root;
			while (temp != null) {
				// check if the value already exists at the current node
				if (val == temp.data) {
					System.out.println("Value Already Exists!");
					return;
				}
				// to insert in the left position
				else if (val < temp.data && temp.left == null) {
					temp.left = n;
					System.out.println("Value inserted at the left.");
					break;
				}
				// to traverse to the left node
				else if (val < temp.data) {
					temp = temp.left;
				}
				// to insert in the right position
				else if (val > temp.data && temp.right == null) {
					temp.right = n;
					System.out.println("Value inserted at the right.");
					break;
				}
				// to traverse to the right node
				else {
					temp = temp.right;
				}

			}
		}
	}
// END 1 - Insert a Node(Iterative Approach)

// START	2  - Insert a Node(Recursive Approach)
	public Node insertRecursive(Node root, int val) {
		if (root == null) {
			return new Node(val);
		}
		// if the value is less than the root node then recur for the left subtree
		if (val < root.data) {
			root.left = insertRecursive(root.left, val);
		}

		// else recur for the right subtree
		else {
			root.right = insertRecursive(root.right, val);
		}
		return root;
	}
// END 2 - Insert a Node(Recursive Approach)

// START 3 - Insert a Node(Level Order Insertion)
	public void insertLevelOrder(Node rt, int val) {
		Node nn = new Node(val);
		if (rt == null) {
			rt = nn;
			System.out.println("Inserted at the Root");
			root = rt;
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(rt);

		while (!q.isEmpty()) {
			Node n = q.element();
			q.remove();

			if (n.left == null) {
				n.left = nn;
				System.out.println("Value inserted at the left.");
				root = rt;
				return;
			} else if (n.right == null) {
				n.right = nn;
				System.out.println("Value inserted at the right.");
				root = rt;
				return;
			} else {
				q.add(n.left);
				q.add(n.right);
			}
		}
	}
// END 3 - Insert a Node(Level Order Insertion)

// START 4 - Print 2D
	public void print2D(Node r, int space) {
		if (r == null) // base case
			return;

		print2D(r.right, space + BinaryTree.GLOBALSPACE);
		System.out.println();
		for (int i = BinaryTree.GLOBALSPACE; i < space; i++)
			System.out.print(" ");

		System.out.println(r.data);
		print2D(r.left, space + BinaryTree.GLOBALSPACE);
	}
// END 4 - Print 2D

// START 5 - Height of Tree
// START 27 - Check if the Binary Tree is Balanced
	static boolean isBal = true; // exclusive for func 27

	public static int height(Node r) {
		if (r == null)
			return -1;

		else {
			int lheight = height(r.left);
			int rheight = height(r.right);

			// exclusive for function 27, ignore this condition for finding the height
			if (Math.abs(lheight - rheight) > 1) {
				isBal = false;
			}
			//

			return Math.max(lheight, rheight) + 1;
		}
	}
// END 27 - Check if the Binary Tree is Balanced
// END 5 - Height of Tree

// START 6 - Sum of all Nodes in the Tree
	public int sumOfNodes(Node r) {
		if (r == null) {
			return 0;
		}
		int lsum = sumOfNodes(r.left); // to calc the sum of left subtree
		int rsum = sumOfNodes(r.right); // to calc the sum of right subtree
		return lsum + rsum + r.data;
	}
// END 6 - Sum of all Nodes in the Tree

// START 7 - Total Number of Nodes in the Tree
	public int countNodes(Node r) {
		if (r == null) {
			return 0;
		}
		int leftCount = countNodes(r.left); // count the total nodes in left subtree
		int rightCount = countNodes(r.right); // count the total nodes in right subtree
		return leftCount + rightCount + 1;
	}
// END 7 - Total Number of Nodes in the Tree

// START 8 - Maximum Value in the Binary Tree
	public int maxValue(Node r) {
		if (r == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = maxValue(r.left); // find the Maximum Value in the left subtree
		int rmax = maxValue(r.right); // find the Maximum Value in the right subtree
		return Math.max(r.data, Math.max(lmax, rmax));
	}
// END 8 - Maximum Value in the Binary Tree

// START 9 - Print Level Order/Breadth First Search (using queue)
	public void printLevelOrderQueue(Node r) {
		Node temp = null;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(r);

		while (queue.size() > 0) {
			temp = queue.poll(); // store the value of current node in 'temp' and dequeue it
			System.out.print(temp.data + " "); // print the current node value
			if (temp.left != null) {
				queue.add(temp.left); // enqueue the left child
			}
			if (temp.right != null) {
				queue.add(temp.right); // enqueue the right child
			}
		}
	}
// END 9 - Print Level Order/Breadth First Search (using queue)

// START 10 - Print Level Order/Breadth First Search (using Recursion)
	public void printLevelOrderRecursion(Node r) {
		int h = height(r);
		for (int i = 0; i <= h; i++)
			printGivenLevel(r, i);
	}
// END 10 - Print Level Order/Breadth First Search (using Recursion)

// START 11 - Print Given Level of the Tree
	public void printGivenLevel(Node r, int level) {
		if (r == null) // base case
			return;

		else if (level == 0)
			System.out.print(r.data + " ");

		else { // level > 0
			printGivenLevel(r.left, level - 1);
			printGivenLevel(r.right, level - 1);
		}
	}
// END 11 - Print Given Level of the Tree

// START 12 - Sum of values at level K
	int sum = 0;

	public int sumAtK(Node r, int K) {
		if (r == null)
			return sum;

		else if (K == 0) // if K is at root level (0)
			sum = sum + r.data;

		else {
			sumAtK(r.left, K - 1);
			sumAtK(r.right, K - 1);
		}
		return sum;
	}
// END 12 - Sum of values at level K

// START 13 - Print Pre-Order Traversal (NODE, LEFT, RIGHT)
	public void printPreOrder(Node r) { // N L R
		if (r == null)
			return;

		System.out.print(r.data + " ");
		printPreOrder(r.left);
		printPreOrder(r.right);
	}
// END 13 - Print Pre-Order Traversal

// START 14 - Print In-Order Traversal (LEFT, NODE, RIGHT)
	public void printInOrder(Node r) { // L N R
		if (r == null)
			return;

		printInOrder(r.left);
		System.out.print(r.data + " ");
		printInOrder(r.right);
	}
// END 14 - Print In-Order Traversal

// START 15 - Print Post-Order Traversal (LEFT, RIGHT, NODE)
	public void printPostOrder(Node r) { // L R N
		if (r == null)
			return;

		printPostOrder(r.left);
		printPostOrder(r.right);
		System.out.print(r.data + " ");
	}
// END 15 - Print Post-Order Traversal

// START 16 - Print all Paths from Root to Leaf Nodes
	static Stack<Integer> st = new Stack<Integer>();

	// print from root to leaf node by In-Order Traversal
	public static void rootToLeaf(Node r) {
		if (r == null)
			return;

		st.push(r.data);
		rootToLeaf(r.left);
		if (r.left == null && r.right == null) // if the encountered node is a leaf node
		{
			System.out.println(st);
		}

		rootToLeaf(r.right);
		st.pop();
	}
// END 16 - Print all Paths from Root to Leaf Nodes

// START 17 - Search in Binary Search Tree(Iterative Approach)
	public boolean iterativeSearch(int val) {
		boolean flag = false;
		if (root == null) {
			System.out.println("Binary Search Tree is Empty");
		}

		else {
			Node temp = root;
			while (temp != null) {
				if (val == temp.data) { // if the node is found
					flag = true;
					break;
				}

				else if (val < temp.data) // traverse to the left-subtree
					temp = temp.left;

				else if (val > temp.data) // traverse to the right-subtree
					temp = temp.right;
			}
		}
		return flag;
	}
// END 17 - Search in Binary Search Tree(Iterative Approach)

// START 18 - Search in Binary Search Tree(Recursive Approach)
	public Node recursiveSearch(Node r, int val) {
		if (r == null) // if the current node is null or the value is not present in the BST
			return null;

		if (r.data == val) // if the value is found
			return r;

		if (r.data > val) // when data>val then traverse to the left-subtree
			return recursiveSearch(r.left, val);

		return recursiveSearch(r.right, val); // when data<val then traverse to the right-subtree
	}
// END 18 - Search in Binary Search Tree(Recursive Approach)

// START 19 - Diameter of Binary Tree (O(n^2) Approach)
	public static int diameterOfBT(Node r) {
		if (r == null)
			return 0;

		// maximum distance between two nodes of LHS (factor 1)
		int ld = diameterOfBT(r.left);

		// maximum distance between two nodes of RHS (factor 2)
		int rd = diameterOfBT(r.right);

		// maximum distance between left's deepest & right's deepest nodes (factor 3)
		int des = height(r.left) + height(r.right) + 2;

		int dia = Math.max(des, Math.max(ld, rd));
		return dia;
	}
// END 19 - Diameter of Binary Tree (O(n^2) Approach)

// START 20 - Diameter of Binary Tree (O(n) Approach)
	static class DiaPair {
		int ht;
		int dia;
	}

	public static DiaPair diameter(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();
			bp.ht = -1;
			bp.dia = 0;
			return bp;
		}
		DiaPair lp = diameter(node.left);
		DiaPair rp = diameter(node.right);

		DiaPair mp = new DiaPair();
		mp.ht = Math.max(lp.ht, rp.ht) + 1;

		int des = lp.ht + rp.ht + 2;
		mp.dia = Math.max(des, Math.max(lp.dia, rp.dia));

		return mp;
	}
// END 20 - Diameter of Binary Tree (O(n) Approach)

//	START 21 - Delete a Node
	// function to find the maximum value from the left-subtree
	public static int maxLeft(Node node) {
		if (node.right != null)
			return maxLeft(node.right);
		else
			return node.data;
	}

	public Node delete(Node node, int val) {
		if (node == null)
			return null;
		if (val < node.data) {
			node.left = delete(node.left, val);
		} else if (val > node.data) {
			node.right = delete(node.right, val);
		}
		// when the node to be deleted is found
		else {
			if (node.left != null && node.right != null) // if the node has a left and right child
			{
				int lmax = maxLeft(node.left);
				node.data = lmax;
				node.left = delete(node.left, lmax);
			}
			// if the node has only a left child
			else if (node.left != null) {
				return node.left;
			}
			// if the node has only a right child
			else if (node.right != null) {
				return node.right;
			}
			// if the node has no child i.e., it is a leaf node
			else {
				return null;
			}
		}
		return node;
	}
// END 21 - Delete a Node

// START 22 - Construct BT from Pre-Order and In-Order
	public Node buildTreeFromInorderPreorder(int preorder[], int inorder[]) {
		int n = inorder.length;
		System.out.println("Your BT is Ready PRESS 4 AND ENTER to View");
		return preInTree(preorder, 0, n - 1, inorder, 0, n - 1);
	}

	// psi = preorder starting index
	// pei = preorder ending index.
	// isi = inorder starting index
	// iei = inorder ending inex.
	public Node preInTree(int pre[], int psi, int pei, int in[], int isi, int iei) {
		if (isi > iei)
			return null;

		Node n = new Node(pre[psi]);
		int idx = isi;
		while (in[idx] != pre[psi])
			idx++;
		int tnel = idx - isi; // total no. of element on left side/right side of root.

		n.left = preInTree(pre, psi + 1, psi + tnel, in, isi, idx - 1);
		n.right = preInTree(pre, psi + tnel + 1, pei, in, idx + 1, iei);

		return n;
	}
// END 22 - Construct BT from Pre-Order and In-Order

// START 23 - Construct BT from Post-Order and In-Order
	public Node buildTreeFromInorderPostorder(int postorder[], int inorder[]) {
		int n = postorder.length;
		System.out.println("Your BT is Ready PRESS 4 AND ENTER to View");
		return postInTree(postorder, 0, n - 1, inorder, 0, n - 1);
	}

	// psi = postorder starting index
	// pei = postorder ending index.
	// isi = inorder starting index
	// iei = inorder ending inex.
	public Node postInTree(int post[], int psi, int pei, int in[], int isi, int iei) {
		if (isi > iei)
			return null;
		Node n = new Node(post[pei]);
		int idx = isi;
		while (in[idx] != post[pei])
			idx++;
		int tnel = idx - isi; // total no of elements on left side/right side of root.

		n.left = postInTree(post, psi, psi + tnel - 1, in, isi, idx - 1);
		n.right = postInTree(post, psi + tnel, pei - 1, in, idx + 1, iei);

		return n;
	}
// END 23 - Construct BT from Post-Order and In-Order

// START 24 - Construct BST from In-Order
	public Node buildBSTfromInorder(int inorder[]) {
		int n = inorder.length;
		System.out.println("Your BST is Ready PRESS 4 AND ENTER to View");
		return buildBSTfromInorder(inorder, 0, n - 1);
	}

	private Node buildBSTfromInorder(int[] in, int si, int ei) {
		if (si > ei)
			return null;
		int midRoot = (si + ei) / 2;
		Node n = new Node(in[midRoot]);

		n.left = buildBSTfromInorder(in, si, midRoot - 1);
		n.right = buildBSTfromInorder(in, midRoot + 1, ei);

		return n;
	}
// END 24 - Construct BST from In-Order

// START 25 - Construct BST from Pre-Order	
	int idx = 0;

	public Node buildBSTfromPreorder(int preorder[]) {
		int lr = -1000; // left range
		int rr = 1000; // right range
		idx = 0;
		System.out.println("Your BST is ready PRESS 4 AND ENTER to view");
		return buildBSTfromPreorder(preorder, lr, rr);
	}

	private Node buildBSTfromPreorder(int[] pre, int lr, int rr) {
		if (idx >= pre.length || pre[idx] < lr || pre[idx] > rr)
			return null;

		Node n = new Node(pre[idx++]);

		n.left = buildBSTfromPreorder(pre, lr, n.data);
		n.right = buildBSTfromPreorder(pre, n.data, rr);

		return n;
	}
// END 25 - Construct BST from Pre-Order	

// START 26 - Construct BST from Post-Order
	public Node buildBSTfromPostorder(int postorder[]) {
		int lr = -1000; // left range
		int rr = 1000; // right range
		idx = postorder.length - 1;
		System.out.println("Your BST is Ready PRESS 4 AND ENTER to view");
		return buildBSTfromPostorder(postorder, lr, rr);
	}

	private Node buildBSTfromPostorder(int[] post, int lr, int rr) {
		if (idx < 0 || post[idx] < lr || post[idx] > rr)
			return null;

		Node n = new Node(post[idx--]);

		n.right = buildBSTfromPostorder(post, n.data, rr);
		n.left = buildBSTfromPostorder(post, lr, n.data);

		return n;
	}
// END 26 - Construct BST from Post-Order
}
