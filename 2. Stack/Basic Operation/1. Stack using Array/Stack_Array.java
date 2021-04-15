import java.util.*;
public class Stack_Array {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of Stack");
		int n=sc.nextInt();
		stack st=new stack(n);
		
		boolean flag=true;
		int valu;int posi=0;
		while(flag) {
			
			System.out.println("1. Push item in Stack");
			System.out.println("2. Pop item out from Stack");
			System.out.println("3. Current size of stack");
			System.out.println("4. Update value at position");
			System.out.println("5. View value at position");
			System.out.println("6. View Stack");
			System.out.println("7. Exit");
			
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			
				case 1: System.out.println("Enter value");
						valu=sc.nextInt();
						st.push(valu);
				break;
				
				
				case 2: System.out.println(st.pop());
				break;
				
				
				case 3: System.out.println(st.count());
				break;
				
				case 4: System.out.println("Enter value");
						valu=sc.nextInt();
						System.out.println("Enter position");
						posi=sc.nextInt();
						st.updateValue(posi, valu);
				break;
				
				case 5:System.out.println("Enter position");
						posi=sc.nextInt();
						st.peek(posi);
				break;
					
				case 6:st.display();
				break;
				
				case 7: flag=false;
				break;
				
				default: System.out.println("invalid choice");
			}//switch
			System.out.println();
		}//while

	}//main()
	
}//class

class stack{
	private int top;
	private int arr[];
	private int n;// size of stack
	
	public stack(int n) {
		top=-1;
		this.n=n;
		arr=new int[this.n];
	}
	
	public boolean isEmpty() {
		if (top == -1)
		      return true;
		else
		      return false;
	}
	
	public boolean isFull() {
		if (top == n-1)
		      return true;
		else
		      return false;
	}
	
	public void push(int val) {
		if(isFull()) {
			System.out.println("Stack Overflow");
		}
		else {
			top++; 
		    arr[top] = val;
		}
	}
	
	public int pop() {
	    if (isEmpty()) {
	      System.out.println("Stack Underflow");
	      return -9999;
	    }
	    else {
	      int popValue = arr[top];
	      arr[top] = 0;
	      top--;
	      return popValue;
	    }
   }
	
	//return current size of stack
	public int count() {
	    return (top + 1);
	  }
	
	//this will return top value of a stack
	public int Top() {
		if (isEmpty()) {
		      System.out.println("Stack Underflow");
		      return -9999;
		    }
		return arr[top];
	}
	
	//this will only peek(show) the stack value in particular position
	public int peek(int pos) {
	    if (isEmpty()) {
	      System.out.println("Stack Underflow");
	      return -9999;
	    } 
	    else {
	      return arr[pos];
	    }
}
	
	public void updateValue(int pos,int val) {
		if(pos>count()) {
			System.out.println("Stack Overflow");
		}
		else {
			arr[pos-1] = val;
			System.out.println("Value Updated at position "+pos);
		}
		
	}
	
	void display() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		else {
		    System.out.println("All values in the Stack are ");
		    for (int i = top; i >= 0; i--) {
		      System.out.println(arr[i]);
		    }
	  }
   }
	
	
	
}
