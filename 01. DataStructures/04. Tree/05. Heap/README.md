# **Complete BT ?**

## Binary tree where all levels except the last are completely filled orelse if any levels are partially filled then all nodes in that level should be as left as possible.

# **HEAP DS**

## A Heap is a special Tree-based data structure in which the tree is a complete binary tree.

## It follows the Heap Property –

- ## **Max-Heap:** In a Max-Heap the key present at the root node must be greatest among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.
- ## **Min-Heap:** In a Min-Heap the key present at the root node must be minimum among the keys present at all of it’s children. The same property must be recursively true for all sub-trees in that Binary Tree.
  ![](https://simplesnippets.tech/wp-content/uploads/2021/04/heap-data-structure-with-program-code.jpg)

# **WAYS OF IMPLEMENTATION**

![](https://i.ibb.co/S7KWB3Q/HEAPdS.png)

## **NOTE:** We are going to continue with **Min Heap** implementations. For Max Heap, every approach will be as simillar as MinHeap with some small changes you yourself will know the changes once you complete MinHeap implementations.

# **Functions Overview in MinHeap**

## 1. Insertion in MinHeap

## 2. Display Heap

## 3. Height of Heap Tree

## 4. Current Heap Size

## 5. minExtract()

- Heapify

## 6. minDeleteKey()

- DecreaseKey()

## 7. Heap Sort

<hr>

# **1 - Insert an Element**

## **[Video Reference](https://youtu.be/5l3n3HFgljg)**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 1:
	System.out.print("Enter Value to be Inserted: ");
	val = sc.nextInt();
	hp.insert(val);
	break;


// START 1 - Insert an Element
	public void insert(int val) {
		if (hSize == hCap) {
			System.out.println("Heap Overflow");
			return;
		}
		System.out.println("Value Inserted in Heap");
		hSize++;
		int i = hSize - 1;
		hArr[i] = val;

		// if the new inserted node is less than its parent then swap them
		while (i != 0 && hArr[i] < hArr[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
// END 1 - Insert an Element
```

<hr>

# **2 - Display the Heap**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 2:
	hp.display();
	break;

// START 2 - Display the Heap
	public void display() {
		for (int i = 0; i < hSize; i++)
			System.out.print(hArr[i] + " ");
	}
// END 2 - Display the Heap
```

<hr>

# **3 - Height of the Heap**

```java
case 3:
	System.out.println(
	"Height of Heap Tree = " + ((int) Math.ceil(Math.log(hp.hSize + 1) / Math.log(2)) - 1));
	break;
```

<hr>

# **5 - minExtract()**

## **Returning and Removing root element of Min Heap Tree** and then restructuring into Min Heap Tree this restructuring is called **Heapify.**

## **[Video Reference](https://youtu.be/AHyXBIxC63g)**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 5:
	System.out.println(hp.minExtract());
	break;

// START 5 - minExtract()
	public int minExtract() {
		if (hSize <= 0) {
			System.out.println("Empty heap");
			return -99999;
		}
		if (hSize == 1) {
			hSize--;
			return hArr[0];
		}
		int root = hArr[0];
		hArr[0] = hArr[hSize - 1];
		hSize--;
		minHeapify(0);
		return root;
	}

	public void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l < hSize && hArr[l] < hArr[smallest])
			smallest = l;
		if (r < hSize && hArr[r] < hArr[smallest])
			smallest = r;

		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}
// END 5 - minExtract()
```

<hr>

# **6 - Delete Key**

## This delete the key at particular index.

## **[Video Reference](https://youtu.be/aK5Qj29C5PQ)**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 6:
	System.out.print("Enter Key to be Deleted: ");
	val = sc.nextInt();
	hp.minDeleteKey(val);
	break;

// START 6 - Delete Key
	public void minDeleteKey(int i) {
		if (i >= hSize) {
			System.out.println("Enter valid key");
			return;
		}
		decreaseKey(i, Integer.MIN_VALUE);
		minExtract();
		System.out.println("Value Deleted");
	}

	// this () will set the value in deletingIndex with minimum value than will keep
	// on swapping that deletingIndex value with its parents until it reaches root
	// then minExtract() will be called to remove the root(which is
	// Integer.MIN_VALUE) and heapify
	public void decreaseKey(int i, int minVal) {
		hArr[i] = minVal;
		while (i != 0 && hArr[i] < hArr[parent(i)]) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
// END 6 - Delete Key
```

<hr>

# **7 - Heap Sort**

## **[Video Reference](https://youtu.be/XrY8z4e5HAk)**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 7:
	hp.hSize = hp.hCap;
	System.out.println("Enter Elements of Unsorted Array:");
	for (int i = 0; i < hp.hCap; i++) {
		hp.hArr[i] = sc.nextInt();
	}
	hp.heapSort(hp.hArr);
	break;

// START 7 - Heap Sort
	public void heapSort(int unsortedArr[]) {
		System.out.println("\nUnsorted Array = " + Arrays.toString(unsortedArr));

		// this will convert array into a min-heap array from bottom to top
		for (int i = (unsortedArr.length / 2) - 1; i >= 0; i--) {
			minHeapify(i);
		}

		// actual heap sort starts
		int sortedArr[] = new int[unsortedArr.length];
		for (int i = 0; i < sortedArr.length; i++) {
			sortedArr[i] = minExtract();
		}
		System.out.println("Sorted Array = " + Arrays.toString(sortedArr));
	}
// END 7 - Heap Sort
```

<hr>
<h1 align="center"><b><a href="./MinHeap.java">SEE MY FULL IMPLEMENTED CODE HERE.</a></b></h1>
<h1 align="center"><b>THANK YOU</b></h1>
