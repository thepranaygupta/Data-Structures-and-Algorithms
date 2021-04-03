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
	public void insertAtPos

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

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
