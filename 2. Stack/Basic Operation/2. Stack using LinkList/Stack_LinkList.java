import java.util.*;


public class Stack_LinkList {
		
		public static void main(String args[]) {
			Scanner sc=new Scanner(System.in);
			stack_LL st=new stack_LL();
			boolean flag=true;
			int valu=0;
			while(flag) {
				
				System.out.println("1. Push item in Stack");
				System.out.println("2. Pop item out from Stack");
				System.out.println("3. Current size of stack");
				System.out.println("4. peek()");
				System.out.println("5. View Stack");
				System.out.println("6. Exit");
				
				System.out.println("Enter Choice");
				int choice=sc.nextInt();
				switch(choice) {
				
					case 1: System.out.println("Enter value");
							valu=sc.nextInt();
							st.push(valu);
					break;
					
					
					case 2: System.out.println(st.pop());
					break;
					
					
					case 3: System.out.println(st.size());
					break;
					
					case 4: System.out.println(st.peek());  
					break;
						
					case 5:st.display();
					break;
					
					case 6: flag=false;
					break;
					
					default: System.out.println("invalid choice");
				}//switch
				System.out.println();
			}//while
			
		}
}


class stack_LL{

		class Node{
				private int data; 
				private Node next;
					
				public Node(int data) {
					this.data=data;next=null;
				}
		}
		
		private Node top;
		private int size;
		
		public stack_LL() {
			top=null;
			size=0;
		}
		
		public int size() {
			return size;
		}
		
		public boolean isEmpty() {
			return top==null;
		}
		
		public void push(int val) {
			Node n=new Node(val);
			n.next=top;
			top=n;
			size++;
		}
		
		public int pop() {
			if(isEmpty()) {
				System.out.println("Stack Underflow i.e Stack is Empty");
				return -9999;
			}
			int result=top.data;
			top=top.next;
			size--;
			return result;
		}
		
		//this will return top value of stack
		public int peek() {
			if(isEmpty()) {
				System.out.println("Stack Underflow i.e Stack is Empty");
				return -9999;
			}
			return top.data;
		}
		
		public void display() {
			Node t=top;
			if(isEmpty()) {
				System.out.println("Stack is Empty");
				return;
			}
			while(t!=null) {
				System.out.println(t.data);
				t=t.next;
			}
		}
}
