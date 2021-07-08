package stackqueue;

import java.util.*;

public class PriorityQueue {

	public static void main(String[] args) {

		PriorityQueues<Integer> pq1 = new PriorityQueues<>(7); // When you want ascending order (min heap)

		pq1.add(8);
		pq1.add(5);
		pq1.add(85);
		pq1.add(20);
		pq1.add(15);
		pq1.add(95);
		pq1.add(4);
		pq1.display();
		System.out.println();
		System.out.println("Ascending order removal");
		System.out.println("removed element= " + pq1.remove());
		System.out.println("removed element= " + pq1.remove());
		System.out.println("removed element= " + pq1.remove());
		System.out.println("removed element= " + pq1.remove());
		System.out.println("removed element= " + pq1.remove());
		System.out.println("removed element= " + pq1.remove());
		System.out.println("removed element= " + pq1.remove());

		System.out.println("------------------------------------");

		// object addition in PQ
		System.out.println("Object in PQ");
		PriorityQueues<Student> pq2 = new PriorityQueues<>(4);
		pq2.add(new Student(1, 1000));
		pq2.add(new Student(2, 2000));
		pq2.add(new Student(3, 3000));
		pq2.add(new Student(4, 4000));
		pq2.display();
		System.out.println();
		System.out.println("removed element=" + pq2.remove());
		System.out.println("peek element=" + pq2.peek());

		System.out.println("------------------------------------");

		// Now How will you change the removingOrder of Wrapper classes the Answer is
		// --> by using comparator
		PriorityQueues<Integer> pq3 = new PriorityQueues<>(7, new IntegerSorting());// when you want descending
																					// order(max heap)
		pq3.add(8);
		pq3.add(5);
		pq3.add(85);
		pq3.add(20);
		pq3.add(15);
		pq3.add(95);
		pq3.add(4);
		pq3.display();
		System.out.println();
		System.out.println("Descending order removal");
		System.out.println("removed element= " + pq3.remove());
		System.out.println("removed element= " + pq3.remove());
		System.out.println("removed element= " + pq3.remove());
		System.out.println("removed element= " + pq3.remove());
		System.out.println("removed element= " + pq3.remove());
		System.out.println("removed element= " + pq3.remove());
		System.out.println("removed element= " + pq3.remove());
	}

}

class PriorityQueues<T> {
	ArrayList<T> harr;
	int hSize;
	int hCap;
	Comparator comparator;

	// object of this constructor will use comparable
	public PriorityQueues(int cap) {
		harr = new ArrayList<>();
		hCap = cap;
		hSize = 0;
		for (int i = 0; i < hCap; i++) {
			harr.add(null);
		}
		comparator = null;
	}

	// object of this constructor will use comparator
	public PriorityQueues(int cap, Comparator comp) {
		harr = new ArrayList<>();
		hCap = cap;
		hSize = 0;
		for (int i = 0; i < hCap; i++) {
			harr.add(null);
		}
		this.comparator = comp;
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

	public void display() {
		for (int i = 0; i < hSize; i++)
			System.out.print(harr.get(i) + " ");
	}

	public void swap(int currI, int swI) {// currentIndex, swapIndex
		T temp = harr.get(currI);
		harr.set(currI, harr.get(swI));
		harr.set(swI, temp);
	}

	private boolean isSmaller(T i, T j) {
		if (comparator != null) {
			return comparator.compare(i, j) < 0;
		} else {
			Comparable ith = (Comparable) i;
			Comparable jth = (Comparable) j;
			return (ith.compareTo(jth) < 0); // thisObj-callingObj

		}
	}

	// add STARTS
	public void add(T val) {
		if (hSize == hCap) {
			System.out.println("PQ overflow");
			return;
		}
		hSize++;
		int i = hSize - 1;
		harr.add(i, val);

		// here checking if currInsertedNode is lesser than parent node -->then SWAP
		while (i != 0 && isSmaller(harr.get(i), harr.get(parent(i)))) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	// add ENDS

	// peek() starts
	public T peek() {
		return harr.get(0);
	}
	// peek() ends

	// remove() starts
	public T remove() {
		if (hSize <= 0) {
			System.out.println("Empty PQ");
			return null;
		}
		if (hSize == 1) {
			hSize--;
			return harr.get(0);
		}
		T root = harr.get(0);
		harr.set(0, harr.get(hSize - 1));

		hSize--;
		minHeapify(0);
		return root;
	}

	public void minHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;

		if (l < hSize && isSmaller(harr.get(l), harr.get(smallest)))
			smallest = l;
		if (r < hSize && isSmaller(harr.get(r), harr.get(smallest)))
			smallest = r;

		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}
	// remove() ENDS
}

class Student implements Comparable<Student> {
	int roll;
	int rank;

	public Student(int ro, int rnk) {
		roll = ro;
		rank = rnk;
	}

	@Override
	public int compareTo(Student o) {
		return this.roll - o.roll;
	}

	@Override
	public String toString() {
		return "(" + roll + "," + rank + ")";
	}
}

class IntegerSorting implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o2 - o1;
	}

}
