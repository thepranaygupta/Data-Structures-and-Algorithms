
import java.util.Random;
public class Treap<Key extends Comparable<Key>> {
	
	// Here is the utility functions.
	private Random generator = new Random();
	private int rng_upperbound = 0;
	
	public void setRandomSeed(int seed) {
		generator = new Random(seed);
	}
	public void setRngUpperbound(int u) {
		rng_upperbound = u;
	}
	private int getNextPriority() {
		return generator.nextInt(rng_upperbound);
	}
	public void clear() {
		root = null;
	}

	// interface for the node class. 
	private class Node {
		Node left, right;
		Key key;
		int priority;
		Node(Key k) {
			this.left = null;
			this.right = null;
			this.key = k;
			this.priority = getNextPriority();
		}
	}
	
	private Node root;
	
	// Constructor
	public Treap() {
		root = null;
	} 
	
	// Insert key k to the tree.
	public void insert(Key k) {
		root = insert(k, root);
	}
	// Find key k in the tree and return number of comparisons needed.
	// Return -1 if key is not found.
	public int find(Key k) {
		int compareCount = 0;
		int notFound = -1;

		compareCount = find(k, compareCount, root);
		if (compareCount == notFound)
			return notFound;
		else
			return compareCount;
	}

	private int find(Key k, int compareCount, Node p) {
		if (p == null)
			return -1;
		else if (k.compareTo(p.key) < 0) {
			return find(k, ++compareCount, p.left);
		} else if (k.compareTo(p.key) > 0) {
			return find(k, ++compareCount, p.right);
		} else {
			return ++compareCount;
		}
	}

	private Node insert(Key k, Node p) {
		if (p == null) {
			p = new Node(k);
		}
		else if (k.compareTo(p.key) < 0)
			p.left = insert(k, p.left);
		else if (k.compareTo(p.key) > 0)
			p.right = insert(k, p.right);
		else
			throw new IllegalArgumentException("Key already exists");

		return restructure(p);
	}

	private Node rotateRight(Node p) {
		Node q = p.left;
		p.left = q.right;
		q.right = p;
		return q;
	}

	private Node rotateLeft(Node p) {
		Node q = p.right;
		p.right = q.left;
		q.left = p;
		return q;
	}

	private int getPriority(Node p) {
		return (p == null) ? rng_upperbound: p.priority;
	}

	private Node lowestPriority(Node p) {
		Node q = p;
		if (getPriority(p.left) < getPriority(q)) q = p.left;
		if (getPriority(p.right) < getPriority(q)) q = p.right;
		return q;
	}

	private Node restructure(Node p) {
		if (p == null) return p;

		Node q = lowestPriority(p);
		if (q == p.left)
			p = rotateRight(p);
		if (q == p.right)
			p = rotateLeft(p);
		return p;
	}

    // -------------------------------------------------------------------------
	// Here are functions for sanity check of your treap. 
	// -------------------------------------------------------------------------
	// private boolean keyCheckHelper(Node root) {
	// 	if (root == null)
	// 		return true;
	// 	boolean check_left_tree = keyCheckHelper(root.left);
	// 	boolean check_right_tree = keyCheckHelper(root.right);
	// 	boolean check = true;
	// 	if (root.left != null)
	// 		check = check && (root.left.key.compareTo(root.key) <= 0);
	// 	if (root.right != null)
	// 		check = check && (root.right.key.compareTo(root.key) > 0);
	// 	return check && check_left_tree && check_right_tree;
	// }
	
	
	// private boolean priorityCheckHelper(Node root) {
	// 	if (root == null)
	// 		return true;
	// 	boolean check_left_tree = priorityCheckHelper(root.left);
	// 	boolean check_right_tree = priorityCheckHelper(root.right);
	// 	boolean check = true;
	// 	if (root.left != null)
	// 		check = check && (root.left.priority >= root.priority);
	// 	if (root.right != null)
	// 		check = check && (root.right.priority >= root.priority);
	// 	return check && check_left_tree && check_right_tree;
	// }
	
	// public boolean isTreap() {
	// 	if (root == null)
	// 		return false;
	// 	boolean keyCheck = keyCheckHelper(root);
	// 	boolean priorityCheck = priorityCheckHelper(root);
	// 	return keyCheck && priorityCheck;
	// }

	/*private void inorderPrintHelper(Node p) {
		if (p != null) {
			inorderPrintHelper(p.left);
			System.out.println(p.key +"##"+ p.priority);
			inorderPrintHelper(p.right);
		}
	}

	public void inorderPrint() {
		System.out.println("--------");
		inorderPrintHelper(root);
	}*/
	
	/*public static void main(String[] args) {
		Treap<Integer> treap = new Treap<>();
		treap.setRandomSeed(1);
		treap.setRngUpperbound(10);
		treap.insert(2);
		treap.insert(4);
		treap.insert(5);
		treap.insert(7);
		treap.insert(9);
		treap.insert(8);
		treap.insert(15);
		treap.insert(6);
		treap.insert(3);
		System.out.println("--------");
		treap.inorderPrint();
	}*/

	/*public static void main(String[] args) {
		Treap<Integer> treap = new Treap<>();
		treap.setRandomSeed(1);
		treap.setRngUpperbound(100000);
		treap.insert(2);
		treap.insert(4);
		treap.insert(6);
		treap.insert(8);
		treap.insert(10);
		treap.inorderPrint();
		System.out.println(treap.find(2));
	}*/

}
