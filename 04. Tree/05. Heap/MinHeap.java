package treeDS;

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
			System.out.println("Enter Your Choice: ");
			System.out.println("0. Exit");
			System.out.println("1 - Insert an Element");
			System.out.println("2 - Display the Heap");
			System.out.println("3 - Height of the Heap");
			System.out.println("4 - Current Heap Size");
			System.out.println("5 - minExtract()");
			System.out.println("6 - Delete Key");
			System.out.println("7 - Heap Sort");
			int ch = sc.nextInt();
			switch (ch) {
			case 0:
				flag = false;
				break;
			case 1:
				System.out.print("Enter Value to be Inserted: ");
				val = sc.nextInt();
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

	public void display() {
		for (int i = 0; i < hSize; i++)
			System.out.print(hArr[i] + " ");
	}
}
