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

# **1. Insertion in MinHeap**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 1: System.out.println("Enter value");
			valu=sc.nextInt();
			hp.minInsert(valu);
break;

//minInsert STARTS
	public void minInsert(int val) {
		if(hSize==hCap) {
			System.out.println("Heap overflow");
			return;
		}
		System.out.println("Value Inserted in Heap");
		hSize++;
		int i=hSize-1;
		hArr[i]=val;

		//here checking if currInsertedNode is lesser than parent node -->then SWAP
		while(i!=0 && hArr[i] < hArr[parent(i)]) {
			swap(i, parent(i));
			i=parent(i);
		}
	}
//minInsert ENDS
```

## **[Video Reference](https://youtu.be/5l3n3HFgljg)**

<hr>

# **5. minExtract()**

## **Returning and Removing root element of Min Heap Tree** and then restructuring into Min Heap Tree this restructuring is called **Heapify.**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 5: System.out.println(hp.minExtract());
break;



//minExtract STARTS
	public int minExtract() {
		if(hSize<=0) {
			System.out.println("Empty heap");
			return -99999;
		}
		if(hSize==1) {
			hSize--;
			return hArr[0];
		}
		int root=hArr[0];
		hArr[0]=hArr[hSize-1];
		hSize--;
		minHeapify(0);
		return root;
	}

	public void minHeapify(int i) {
		int l=left(i);
		int r=right(i);
		int smallest=i;

		if(l<hSize && hArr[l]<hArr[smallest]) smallest=l;
		if(r<hSize && hArr[r]<hArr[smallest]) smallest=r;

		if(smallest!=i) {
			swap(i,smallest);
			minHeapify(smallest);
		}
	}
	//minExtract ENDS
```

## **[Video Reference](https://youtu.be/AHyXBIxC63g)**

<hr>

# **6. minDeleteKey()**

## This delete the key at particular index.

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 6: System.out.println("Enter key to be deleted");
			valu=sc.nextInt();
			hp.minDeleteKey(valu);
break;


// minDeleteKey operation STARTS
	public void minDeleteKey(int i) {
		if(i>=hSize) {
			System.out.println("Enter valid key"); return;
		}
		decreaseKey(i,-9999);
		minExtract();
	}

	//this () will set the value in deletingIndex with minimum value than will keep on swaping that deletingIndex value with its parents untill it reaches root.
	public void decreaseKey(int i, int minVal){
		hArr[i]=minVal;
		while( i!=0 && hArr[i] < hArr[parent(i)] ) {
			swap(i, parent(i));
			i=parent(i);
		}

	}
// minDeleteKey operation ENDS
```

## **[Video Reference](https://youtu.be/aK5Qj29C5PQ)**

<hr>

# **7. Heap Sort**

```java
//Main calling function
Min_Heap hp=new Min_Heap(hCap); // object of Min Heap class

case 7: hp.hSize=hp.hCap;
			System.out.println("Enter elements in unsorted array");
			for(int i=0;i<hp.hCap;i++) {
				hp.hArr[i]=sc.nextInt();
			}
			hp.heapSort(hp.hArr);
break;


//heap sort STARTS
	public void heapSort(int unsortedArr[]) {
		System.out.println("Unsorted Array -"+Arrays.toString(unsortedArr));

		//this will convert array into minheap array from bottom to top
		for(int i=(unsortedArr.length/2)-1; i>=0;i--) {
			minHeapify(i);
		}

		//actual heapsort start
		int sortedArr[]=new int[unsortedArr.length];
		for(int i=0;i<sortedArr.length;i++) {
			sortedArr[i]=minExtract();
		}
		System.out.println("Sorted Array -"+Arrays.toString(sortedArr));
	}
//heap sort ENDS
```

## **[Video Reference](https://youtu.be/XrY8z4e5HAk)**

<hr>
<h1 align="center"><b><a href="./MinHeap.java">SEE MY FULL IMPLEMENTED CODE HERE.</a></b></h1>
<br>
<br>

<h1 align="center"><b>THANK YOU</b></h1>
