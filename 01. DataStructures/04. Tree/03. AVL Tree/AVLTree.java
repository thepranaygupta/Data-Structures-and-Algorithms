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
				at.root = at.insert(at.root, val);
				break;
			case 2:
				at.print2D(at.root, 5);
				break;
			case 3:
				at.height(at.root);
				System.out.println(at.isBal);
				break;
			case 4:
				System.out.print("Enter Value to Delete: ");
				val = sc.nextInt();
				at.root = at.delete(at.root, val);
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

// ------ START Some Extra User Defined Functions ------

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

// ------ END Some Extra User Defined Functions ------

// START 1 - Insert a Node in AVL Tree
	public Node insert(Node r, int key) {
		if (r == null) {
			return new Node(key);
		}

		// if the value is less than the root node then recur for the left subtree
		else if (key < r.data) {
			r.left = insert(r.left, key);
		}

		// else recur for the right subtree
		else if (key > r.data) {
			r.right = insert(r.right, key);
		}

		// key == root.data
		else {
			System.out.println("Value Already Exists!");
			return r;
		}

		int bf = getBalancedFac(r);
		// Left Case
		if (bf > 1 && key < r.left.data)
			return rightRotate(r);
		// Right Case
		else if (bf < -1 && key > r.right.data)
			return leftRotate(r);
		// Left-Right Case
		else if (bf > 1 && key > r.left.data) {
			r.left = leftRotate(r.left);
			return rightRotate(r);
		}
		// Right-Left Case
		else if (bf < -1 && key < r.right.data) {
			r.right = rightRotate(r.right);
			return leftRotate(r);
		}
		return r;
	}
// END 1 - Insert a Node in AVL Tree

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

// START 4 Delete a Node in AVL Tree
	// function to find the maximum value from the left-subtree
	public static int maxLeft(Node node) {
		if (node.right != null)
			return maxLeft(node.right);
		else
			return node.data;
	}
	
	public Node delete(Node r, int val) {
		if (r == null)
			return null;
		if (val < r.data) {
			r.left = delete(r.left, val);
		} else if (val > r.data) {
			r.right = delete(r.right, val);
		} 
		// when the node to be deleted is found
		else {
			if (r.left != null && r.right != null) {
				int lmax = maxLeft(r.left);
				r.data = lmax;
				r.left = delete(r.left, lmax);
			} 
			// if the node has only a left child
			else if (r.left != null) {
				return r.left;
			} 
			// if the node has only a right child
			else if (r.right != null) {
				return r.right;
			} 
			// if the node has no child i.e., it is a leaf node
			else {
				return null;
			}
		}

		int bf = getBalancedFac(r);
		
		// if bf is 2, it means that the deletion will happen in the right subtree
		// this will result in L-L-Imbalance or L-R-Imbalance
		/*
		  => bf(r.left)=1 means remaining structure in this is:-
		 		30 bf=2
		 	   /
		 	  20   bf=1
		 	 /
		 	10     bf=0
		
		 => bf(r.left)=0 means remaining structure in this is:-
		 	   30 bf=2
		 	  /
		 	 20   bf=0
		 	/  \
		   10  25   bf=0 for both
	  */
		if (bf == 2 && getBalancedFac(r.left) >= 0)
			return rightRotate(r);
		else if (bf == 2 && getBalancedFac(r.left) == -1) {
			r.left = leftRotate(r.left);
			return rightRotate(r);
		}
		
		// if bf is -2, it means that the deletion will happen in the left subtree
		// this will result in R-R-Imbalance or R-L-Imbalance
		/*
		   => bf(r.right)=-1 means remaining structure in this is:-
		 		10 bf=-2
		 		  \
		 		  20 bf=-1
		 		    \
		 		    30 bf=0
		 
		
		
		  => bf(r.right)=0 means remaining structure in this is:-
		 	   10  bf=-2
		 		 \
		 		 20 bf=0
		 		/  \
		 	  15    30 bf=0 for both
	  */
		else if (bf == -2 && getBalancedFac(r.right) <= 0)
			return leftRotate(r);
		else if (bf == -2 && getBalancedFac(r.right) == 1) {
			r.right = rightRotate(r.right);
			return leftRotate(r);
		}
		return r;
	}
// END 4 Delete a Node in AVL Tree
}
