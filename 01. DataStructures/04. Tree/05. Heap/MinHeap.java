package treeDS;

import java.util.Arrays;
import java.util.Scanner;

public class MinHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Heap Capacity: ");
		int hCap = sc.nextInt();
		Min_Heap hp = new Min_Heap(hCap);
		boolean flag = true;
		int val = 0;
		while (flag) {
			System.out.println();
			System.out.println("0. Exit");
			System.out.println("1 - Insert an Element");
			System.out.println("2 - Display the Heap");
			System.out.println("3 - Height of the Heap");
			System.out.println("4 - Current Heap Size");
			System.out.println("5 - minExtract()");
			System.out.println("6 - Delete Key");
			System.out.println("7 - Heap Sort");
			System.out.print("Enter Your Choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 0:
				flag = false;
				break;
			case 1:
				System.out.print("Enter Value to be Inserted: ");
				val = sc.nextInt();
				hp.insert(val);
				break;
			case 2:
				hp.display();
				break;
			case 3:
				System.out.println(
						"Height of Heap Tree = " + ((int) Math.ceil(Math.log(hp.hSize + 1) / Math.log(2)) - 1));
				break;
			case 4:
				System.out.println("The Size of the Heap is = " + hp.hSize);
				break;
			case 5:
				System.out.println(hp.minExtract());
				break;
			case 6:
				System.out.print("Enter Key to be Deleted: ");
				val = sc.nextInt();
				hp.minDeleteKey(val);
				break;
			case 7:
				hp.hSize = hp.hCap;
				System.out.println("Enter Elements of Unsorted Array:");
				for (int i = 0; i < hp.hCap; i++) {
					hp.hArr[i] = sc.nextInt();
				}
				hp.heapSort(hp.hArr);
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}

class Min_Heap {
	int hArr[];
	int hCap;
	int hSize;

	public Min_Heap(int cap) {
		hCap = cap;
		hSize = 0;
		hArr = new int[hCap];
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int left(int i) {
		return (2 * i) + 1;
	}

	public int right(int i) {
		return (2 * i) + 2;
	}

	public void swap(int currI, int swI) { // currentIndex, swapIndex
		int temp = hArr[currI];
		hArr[currI] = hArr[swI];
		hArr[swI] = temp;
	}

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

// START 2 - Display the Heap
	public void display() {
		for (int i = 0; i < hSize; i++)
			System.out.print(hArr[i] + " ");
	}
// END 2 - Display the Heap

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
}
