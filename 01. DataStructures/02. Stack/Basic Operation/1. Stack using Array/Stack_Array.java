package stackqueue;

import java.util.*;

public class Stack_Array {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of Stack: ");
		int n = sc.nextInt();
		stack st = new stack(n);

		boolean flag = true;
		int val;
		int pos = 0;
		while (flag) {

			System.out.println("1. Push item in Stack");
			System.out.println("2. Pop item out from Stack");
			System.out.println("3. Current size of stack");
			System.out.println("4. Update value at position");
			System.out.println("5. View value at position");
			System.out.println("6. View Stack");
			System.out.println("7. Exit");

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
				System.out.println(st.count());
				break;

			case 4:
				System.out.print("Enter value: ");
				val = sc.nextInt();
				System.out.print("Enter position: ");
				pos = sc.nextInt();
				st.updateValue(pos, val);
				break;

			case 5:
				System.out.print("Enter position: ");
				pos = sc.nextInt();
				st.peek(pos);
				break;

			case 6:
				st.display();
				break;

			case 7:
				flag = false;
				break;

			default:
				System.out.println("Invalid Choice");
			}
			System.out.println();
		}

	}

}

class stack {
	private int top;
	private int arr[];
	private int n;

	public stack(int n) {
		top = -1;
		this.n = n;
		arr = new int[this.n];
	}

	// this tells if the stack is empty or not
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	// this tells if the stack is full or not
	public boolean isFull() {
		if (top == n - 1)
			return true;
		else
			return false;
	}

	// this will place an item on the stack
	public void push(int val) {
		if (isFull()) {
			System.out.println("Stack Overflow");
		} else {
			top++;
			arr[top] = val;
		}
	}

	// this will return the item at the top of the stack and then remove it
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int popValue = arr[top];
			arr[top] = 0;
			top--;
			return popValue;
		}
	}

	// this will return the no of items in the stack
	public int count() {
		return (top + 1);
	}

	// this will return top value of a stack
	public int Top() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return 0;
		}
		return arr[top];
	}

	// this will access the value at given position
	public int peek(int pos) {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			return arr[pos];
		}
	}

	// this will update the value of a given positon
	public void updateValue(int pos, int val) {
		if (pos > count()) {
			System.out.println("Stack Overflow");
		} else {
			arr[pos - 1] = val;
			System.out.println("Value Updated at position " + pos);
		}

	}

	// display all the items of the stack
	void display() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			System.out.println("All values in the Stack are: ");
			for (int i = top; i >= 0; i--) {
				System.out.println(arr[i]);
			}
		}
	}
}
