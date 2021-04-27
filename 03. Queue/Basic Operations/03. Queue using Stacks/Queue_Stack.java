import java.util.*;
public class Queue_Stack {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue_St q=new Queue_St();
		boolean flag=true;
		int valu=0;
		while(flag) {
			
			System.out.println("1. Enqueue()");
			System.out.println("2. Dequeue()");
			System.out.println("3. Current Size of Queue");
			System.out.println("4. Peek()");
			System.out.println("5. View Queue");
			System.out.println("6. Exit");
			
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			
				case 1: System.out.println("Enter value");
						valu=sc.nextInt();
						q.enqueue(valu);
				break;
				
				
				case 2: System.out.println(q.dequeue());
				break;
				
				
				case 3: System.out.println(q.count());
				break;
				
				case 4: System.out.println(q.peek());
				break;
				
				case 5:q.viewQ();
				break;
				
				case 6: flag=false;
				break;
				
				default: System.out.println("invalid choice");
			}//switch
			System.out.println();
		}//while
			

	}

}

class Queue_St{
	
	Stack<Integer> st1;
	Stack<Integer> st2;
	int size;
	int peek;
	
	public Queue_St(){
	st1=new Stack();
	st2=new Stack();
	size=0;
	peek=0;
	}
	
	public int count() {
		return size;
	}
	public boolean isEmpty() {
		return(st1.isEmpty() && st2.isEmpty());
	}
	
	public void enqueue(int val) {
		if(size==0)
			peek=val;
		st1.push(val);
		size++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -999;
		}
		else {
			while(!st1.isEmpty()) {
			st2.push(st1.pop());
			}
			size--;
			int pop= st2.pop();
			peek=st2.peek();
			while(!st2.isEmpty()) {
				st1.push(st2.pop());
			}
			return pop;
			
		}
	}
	
	public int peek() {
		return peek;
	}
	
	
	public void viewQ() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		else
		{
			System.out.println(String.valueOf(st1));
		}
		
	}
	
}
