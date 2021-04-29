import java.util.*;

public class Stack_Queue { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack_Q st = new Stack_Q();

		boolean flag = true;
		int val = 0;
		while (flag) {

			System.out.println("1. Push item in Stack");
			System.out.println("2. Pop Item out of Stack");
			System.out.println("3. Current Size of Stack");
			System.out.println("4. Peek()");
			System.out.println("5. View Stack");
			System.out.println("6. Exit");

			System.out.println("Enter Choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("Enter value");
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
				System.out.println(st.peek());
				break;

			case 5:
				st.view();
				break;

			case 6:
				flag = false;
				break;

			default:
				System.out.println("invalid choice");
			}// switch
			System.out.println();
		} // while

	}

}

class Stack_Q {
	Queue<Integer> q1;// primary queue as stack
	Queue<Integer> q2;// secondary queue for push
	int count;

	public Stack_Q() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		count = 0;
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}

	public int count() {
		return count;
	}

	public int peek() {
		return q1.peek();
	}

	public void push(int val) {
		q2.add(val);
		while (!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		count++;
	}

	public int pop() {
		try {
			count--;
			return q1.remove();
		} catch (Exception e) {
			System.out.println("Exception occurs " + e.getMessage());
			return -999;
		}
	}

	public void view() {
		System.out.println(q1);
	}

}
