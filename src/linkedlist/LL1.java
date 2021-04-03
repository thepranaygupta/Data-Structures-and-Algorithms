package linkedlist;

import java.io.*;

class Node {
	private int data;
	private Node next;

	public Node() {
		data = 0;
		next = null;
	}

	public Node(int d, Node n) {
		data = d;
		next = n;
	}

	public void setNext(Node n) {
		next = n;
	}

	public void setData(int d) {
		data = d;
	}

	public Node getNext() {
		return (next);
	}

	public int getData() {
		return (data);
	}
}

class LinkedList {
	private Node start;
	private int size;

	public LinkedList() {
		start = null;
		size = 0;
	}

	public boolean isEmpty() {
		if (start == null)
			return (true);
		else
			return (false);
	}

	public int getListSize() {
		return (size);
	}

	public void insertAtFirst(int val) {
		Node n;
		n = new Node();
		n.setData(val);
		n.setNext(start);
		start=n;
		size++;
	}

	public void insertAtLast(int val) {
		Node n, t;
		n = new Node();
		n.setData(val);
		t = start;
		if (t == null)
			start = n;
		else {
			while (t.getNext() != null)
				t = t.getNext();
			t.setNext(n);
		}
		size++;
	}

	public void insertAtPos(int val, int pos) {
		if (pos == 1)
			insertAtFirst(val);
		else if (pos == size + 1)
			insertAtLast(val);
		else if (pos > 1 && pos <= size) {
			Node n, t;
			n = new Node(val, null);
			t = start;
			for (int i = 1; i < pos - 1; i++)
				t = t.getNext();
			n.setNext(t.getNext());
			t.setNext(n);
			size++;
		} else
			System.out.println("Insertion not Possible at Position: " + pos);
	}

	public void deleteFirst() {
		if (start == null)
			System.out.println("List is Already Empty.");
		else {
			start = start.getNext();
			size--;
		}
	}

	public void deleteLast() {
		if (start == null) // when list is empty
			System.out.println("List is Already Empty.");
		else if (size == 1) { // when has only one node
			start = null;
			size--;
		} else { // when list has more than one node
			Node t;
			t = start;
			for (int i = 1; i < size - 1; i++)
				t = t.getNext();
			t.setNext(null);
			size--;
		}
	}

	public void deleteAtPos(int pos) {
		if (start == null) // when list is empty
			System.out.println("List is Already Empty.");
		else if (pos > size || pos < 1)
			System.out.println("Invalid Position.");
		else if (pos == 1)
			deleteFirst();
		else if (pos == size)
			deleteLast();
		else {
			Node t, t1;
			t = start;
			for (int i = 1; i < pos - 1; i++)
				t = t.getNext(); // reference variable t will store the address of (pos-1) Node's address
			t1 = t.getNext(); // reference variable t1 will store the address of (pos) Node's address
			t.setNext(t1.getNext()); // Node t will not point to (pos+1)Node
			size--;
		}
	}

	public void viewList() {
		Node rn;
		if (isEmpty())
			System.out.println("List is Empty.");
		else {
			rn = start;
			for (int i = 1; i <= size; i++) {
				System.out.print(rn.getData() + " ");
				rn = rn.getNext();
			}
		}
	}
}

public class LL1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList list = new LinkedList();
		boolean flag = true;
		while (flag) {
			System.out.println();
			System.out.println("\n1. Add item to the list at start");
			System.out.println("2. Add item to the list at last");
			System.out.println("3. Add item to the list at position");
			System.out.println("4. Delete First Item from the List");
			System.out.println("5. Delete Last Item from the List");
			System.out.println("6. Delete Item at Given Position from the List");
			System.out.println("7. View List");
			System.out.println("8. Exit");
			System.out.println("Enter Choice");
			int choice = Integer.parseInt(br.readLine());
			int pos, val;
			switch (choice) {
			case 1:
				System.out.println("Enter value");
				val = Integer.parseInt(br.readLine());
				list.insertAtFirst(val);
				break;

			case 2:
				System.out.println("Enter value");
				val = Integer.parseInt(br.readLine());
				list.insertAtLast(val);
				break;

			case 3:
				System.out.println("Enter position");
				pos = Integer.parseInt(br.readLine());
				System.out.println("Enter value");
				val = Integer.parseInt(br.readLine());
				list.insertAtPos(val, pos);
				break;

			case 4:
				list.deleteFirst();
				break;

			case 5:
				list.deleteLast();
				break;

			case 6:
				System.out.println("Enter position");
				pos = Integer.parseInt(br.readLine());
				list.deleteAtPos(pos);
				break;

			case 7:
				list.viewList();
				break;

			case 8:
				flag = false;
				break;

			default:
				System.out.println("invalid choice");
			}
		}

	}

}
