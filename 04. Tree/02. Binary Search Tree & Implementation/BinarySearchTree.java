package treeDS;

import java.util.*;

public class BinarySearchTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BST bt = new BST();
		boolean flag = true;
		int val = 0;
		while (flag) {
			System.out.println();
			System.out.println("1  - Insert a Node(Iterative Approach)");
			System.out.println("2  - Search a Node");
			System.out.println("3  - Delete a Node");
			System.out.println("4  - Print 2D");
			System.out.println("5  - Exit");
		}
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.print("Enter Value to Insert: ");
			val = sc.nextInt();
			break;
		case 2:
			System.out.print("Enter Value to Search: ");
			val = sc.nextInt();
//			System.out.println(bt.Search(val));
			break;
		case 3:
			System.out.print("Enter Value to Delete: ");
			val = sc.nextInt();
//			bt.root=bt.delete(bt.root,val);
			break;
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
	public void insertNodeIA(int val) {
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
	// END	1  - Insert a Node(Iterative Approach)
	
}