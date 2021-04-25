package stackqueue;

import java.util.*;

public class Stack_LinkedList {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		stack_LL st = new stack_LL();
		boolean flag = true;
		int val = 0;
		while (flag) {

			System.out.println("1. Push item in Stack");
			System.out.println("2. Pop item out from Stack");
			System.out.println("3. Current size of stack");
			System.out.println("4. View value at Top");
			System.out.println("5. View Stack");
			System.out.println("6. Exit");

			System.out.print("Enter Choice: ");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.print("Enter value: ");
				val = sc.nextInt();
				st.push(val);
				break;

			case 2:
				System.out.println(st.pop());
				break;

			case 3:
				System.out.println(st.size());
				break;

			case 4:
				System.out.println(st.peek());
				break;

			case 5:
				st.display();
				break;

			case 6:
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice");
			}
			System.out.println();
		}

	}
}

class stack_LL {

	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private Node top;
	private int size;

	public stack_LL() {
		top = null;
		size = 0;
	}

	// returns the no of items in the stack
	public int size() {
		return size;
	}

	// checks if the Stack is empty or not
	public boolean isEmpty() {
		return top == null;
	}

	// place an item on the stack
	public void push(int val) {
		Node n = new Node(val);
		n.next = top;
		top = n;
		size++;
	}

	// returns the item at the top of the tack and then remove it
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow i.e Stack is Empty");
			return -9999;
		}
		int result = top.data;
		top = top.next;
		size--;
		return result;
	}

	// access the value at given top of the stack
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow i.e Stack is Empty");
			return -9999;
		}
		return top.data;
	}

	// display all the items in the stack
	public void display() {
		Node t = top;
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		while (t != null) {
			System.out.println(t.data);
			t = t.next;
		}
	}
}
