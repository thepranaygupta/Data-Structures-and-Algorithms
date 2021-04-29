import java.util.*;

public class CircularQueue_LinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularQueue_LL q = new CircularQueue_LL();
		boolean flag = true;
		int val = 0;
		while (flag) {

			System.out.println("1. Enqueue()");
			System.out.println("2. Dequeue()");
			System.out.println("3. Current Size of Queue");
			System.out.println("4. Peek()");
			System.out.println("5. View Queue");
			System.out.println("6. Exit");

			System.out.println("Enter Choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Enter value");
				val = sc.nextInt();
				q.enqueue(val);
				break;

			case 2:
				System.out.println(q.dequeue());
				break;

			case 3:
				System.out.println(q.count());
				break;

			case 4:
				System.out.println(q.peek());
				break;

			case 5:
				q.viewQ();
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

class CircularQueue_LL {
	class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private Node front;
	private Node rear;
	private int size;

	public CircularQueue_LL() {
		front = null;
		rear = null;
		size = 0;
	}

	public boolean isEmpty() {
		return (front == null && rear == null);
	}

	public int count() {
		return size;
	}

	public void enqueue(int val) {
		Node n = new Node(val);
		if (isEmpty()) {
			front = rear = n;
		} else {
			rear.next = n;
			rear = n;
			n.next = front;
		}
		size++;
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -999;
		} else if (front == rear) {
			Node delD = front;
			front = rear = null;
			size--;
			return delD.data;
		} else {
			Node delD = front;
			front = front.next;
			rear.next = front;// for circular queue
			delD.next = null;
			size--;
			return delD.data;
		}
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -999;
		}
		return front.data;
	}

	public void viewQ() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		Node t = front;
		do {
			System.out.print(t.data + " ");
			t = t.next;
		} while (t != front);
		System.out.print("-->" + t.data);
	}
}
