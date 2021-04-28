package stackqueue;

import java.util.*;

public class CircularQueue_Array {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Size of Queue.");
		int size=sc.nextInt();
		CircularQueue q=new CircularQueue(size);
		
		boolean flag=true;
		int val=0;
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
			
				case 1: System.out.println("Enter Value");
						val=sc.nextInt();
						q.enqueue(val);
				break;
				
				
				case 2: System.out.println(q.dequeue());
				break;
				
				
				case 3: System.out.println(q.count());
				break;
				
				case 4:System.out.println(q.peek());
				break;
				
				case 5:q.viewQ();
				break;
				
				case 6: flag=false;
				break;
								
				default: System.out.println("Invalid Choice");
			}//switch
			System.out.println();
		}//while

	}

}

class CircularQueue{
	private int front;
	private int rear;
	private int n;
	private int cnt;
	private int arr[];
	
	public CircularQueue(int size){
		this.n=size;
		arr=new int[n];
		front=-1; rear=-1;cnt=0;
	}
	
	public boolean isEmpty() {
		return (rear==-1 && front==-1);
	}
	public boolean isFull() {
		return ((rear+1)%n==front);
	}
	public int count() {
		return cnt;
	}
	
	public void enqueue(int val) {
		if(isFull()) {
			System.out.println("Queue  is full");
			return;
		}
		else if(front==-1) {
			front=rear=0;
		}
		else {
			rear=(rear+1)%n;
		}
		arr[rear]=val;
		cnt++;
	}
	public int dequeue() {
		int x=0;
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -999;
		}
		else if(rear==front) {
			x = arr[front];
		    front=rear=-1;
		    return x;
		}
		else {
			x=arr[front];
			front=(front+1)%n;
			return x;
		}
	}
	public void viewQ() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		int i=front;
		while(i!=rear) {
			System.out.print(arr[i]+" ");
			i=(i+1)%n;
		}
		System.out.print(arr[i]+" ");
	}
	public int peek() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -999;
		}
		return arr[front];
	}
}
