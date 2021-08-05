# **What is Balanced BT ?**

### Binary tree where the difference between the height of left subtree and right subtree **for every node** is not more than k(usually k=1). This difference is called balanced factor. **bf=|height of LST - height of RST|**.

### So for every node **height of LST - height of RST** should be {-1,0,1}.

# **AVL TREE**

### AVL Tree is a self-balancing BST (i.e., basically a BST which remains balanced even though you insert or delete nodes).

## **Ways of Balancing AVL Tree**

### To maintain the balance in AVL Tree(i.e to be AVL tree always) while inserting and deleting, we perform Rotations. Depending on different imbalance cases, we have 4 basic types of rotations –

- **LEFT LEFT Imbalance/case - RIGHT Rotation**
- **RIGHT RIGHT Imbalance/case - LEFT Rotation**
- **LEFT RIGHT Imbalance/case - LEFT RIGHT Rotation**
- **RIGHT LEFT Imbalance/case - RIGHT LEFT Rotation**

### **[Video Reference](https://youtu.be/_nyt5QYel3Q)**

![AVL Tree Rotation](https://user-images.githubusercontent.com/64855541/122770456-1522f400-d2c3-11eb-9d95-7bba74a9afc8.jpg)

[AVL Tree Rotation.pdf](https://github.com/thepranaygupta/Data-Structures-and-Algorithms/files/6686954/AVL.Tree.Rotation.pdf)

<hr>

## **INSERTION IN AVL TREE**

### **Step 1 (Optional) : [Theoretical Insertion in AVL Tree](https://youtu.be/f0BplF93TIA)**

### **Step 2 : [Practical Insertion in AVL Tree dry run + code](https://youtu.be/otiDcwZbCo4)**

```java
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
```

<hr>

## **DELETION IN AVL TREE**

<img width="960" alt="AVL Tree Deletion" src="https://user-images.githubusercontent.com/64855541/122783991-b021cb00-d2cf-11eb-8af2-00c64f83af94.png">

### **Step 1: [Practical Implementation of Deletion in AVL Tree](https://youtu.be/3UivJWAFaI4)**

```java
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
		} 
		else if (val > r.data) {
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
```

<hr>
<h1 align="center"><b><a href="./AVLTree.java">SEE MY FULL IMPLEMENTED CODE HERE.</a></b></h1>

<h1 align="center"><b>THANK YOU</b></h1>
