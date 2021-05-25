package treeDS;

import java.util.*;

public class BinaryTree {

	public static final int GLOBALSPACE = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BST bt = new BST();
		boolean flag = true;
		int val = 0;
		while (flag) {
			System.out.println();
			System.out.println("1  - Insert a Node(Iterative Approach)");
			System.out.println("2. - Insert a Node(Recursive Approach)");
			System.out.println("3  - Insert a Node(Level Order Insertion)");
			System.out.println("4  - Print 2D");
//			System.out.println("3  - Delete a Node");
			System.out.println("0  - Exit");

			int ch = sc.nextInt();
			switch (ch) {
			case 0:
				flag=false;
				break;
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
//		case 2:
//			System.out.print("Enter Value to Search: ");
//			val = sc.nextInt();
////			System.out.println(bt.Search(val));
//			break;
//		case 3:
//			System.out.print("Enter Value to Delete: ");
//			val = sc.nextInt();
////			bt.root=bt.delete(bt.root,val);
//			break;
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
	
// START 5 - 
}
