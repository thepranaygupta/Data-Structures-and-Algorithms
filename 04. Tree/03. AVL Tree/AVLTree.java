package treeDS;

import java.util.Scanner;

import treeDS.BST.Node;

public class AVLTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AVL_T at = new AVL_T();
		boolean flag = true;
		int val = 0;
		while (flag) {
			System.out.println();
			System.out.println("1 - Insert a Node in AVL Tree");
			System.out.println("2 - Print 2D");
			System.out.println("3 - isBalanced?");
			System.out.println("4 - Delete a Node in AVL Tree");
			System.out.println("0 - Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.print("Enter Value to Insert: ");
				val = sc.nextInt();
//				at.root = at.insert(at.root, val);
				break;
			case 2:
//				at.print2D(at.root, 5);
				break;
			case 3:
//				at.height(at.root);
//				System.out.println(at.isBal);
				break;
			case 4:
				System.out.print("Enter Value to Delete: ");
				val = sc.nextInt();
//				at.root = at.delete(at.root, val);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Invalid choice");
			}
		}
	}
}

class AVL_T {
	class Node {
		int data;
		Node left;
		Node right;

		public Node(int val) {
			data = val;
			left = right = null;
		}
	}

	Node root;

	public AVL_T() {
		root = null;
	}

// ------ START Some Extra Functions ------

// START Get Balance factor of node N 
	public int getBalancedFac(Node r) {
		if (r == null)
			return -1;
		else
			return height(r.left) - height(r.right);
	}
// END Get Balance factor of node N 

// START Right Rotation
	public Node rightRotate(Node r) {
		Node nr = r.left; // new root
		Node T2 = nr.right;

		// perform right rotation
		nr.right = r;
		r.left = T2;

		return nr;
	}
// END Right Rotation

// START Left Rotation
	public Node leftRotate(Node r) {
		Node nr = r.right; // new root
		Node T2 = nr.left;

		// perform left rotation
		nr.left = r;
		r.right = T2;

		return nr;
	}
// END Left Rotation

// ------ END Some Extra Functions ------

// START 2 - Print 2D
	public void print2D(Node r, int space) {
		if (r == null) // base case
			return;

		print2D(r.right, space + 5);
		System.out.println();
		for (int i = 0; i < space; i++)
			System.out.print(" ");

		System.out.println(r.data);
		print2D(r.left, space + 5);
	}
// END 2 - Print 2D

// START Height of Tree
// START 3 - isBalanced?
	static boolean isBal = true; // only to check isBalanced?

	public static int height(Node r) {
		if (r == null)
			return -1;

		else {
			int lheight = height(r.left);
			int rheight = height(r.right);

			// only to check isBalanced?, ignore this condition for finding the height
			if (Math.abs(lheight - rheight) > 1) {
				isBal = false;
			}
			//
			return Math.max(lheight, rheight) + 1;
		}
	}
// END 3 - isBalanced?
// END Height of Tree

//	public Node insert(Node r, int key) {}
//	public Node delete(Node r,int val) {}
}
