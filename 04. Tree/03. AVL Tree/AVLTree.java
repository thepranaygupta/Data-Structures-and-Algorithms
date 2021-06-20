package treeDS;

import java.util.Scanner;

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
//	public int height(Node r) {}
//	public Node insert(Node r, int key) {}
//	public void print2D(Node r,int space) {}
//	public Node delete(Node r,int val) {}
}
