package linklist;
import java.util.*;

public class DoublyLL {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Linkedlists list=new Linkedlists();
		
		boolean flag=true;
		int valu;int posi=0;
		while(flag) {
			System.out.println();
			System.out.println("1. Add item to the list at start");
			System.out.println("2. Add item to the list at last");
			System.out.println("3. Add item to the list at position");
			System.out.println("4. Delete First node");
			System.out.println("5. Delete last node");
			System.out.println("6. Delete node at position");
			System.out.println("7. Update node at position");
			System.out.println("8. Display Backward/Reverse link list");
			System.out.println("9. View List");
			System.out.println("10. Exit");
			
			System.out.println("Enter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			
			case 1: System.out.println("Enter value");
				valu=sc.nextInt();
				list.insertAtFirst(valu);
			break;
			
			
			case 2: System.out.println("Enter value");
				valu=sc.nextInt();
				list.insertAtLast(valu);
			break;
			
			
			case 3: System.out.println("Enter value");
			valu=sc.nextInt();
			System.out.println("Enter position");
			posi=sc.nextInt();
			list.insertAtPos(valu,posi);
			break;
			
			case 4: 
			list.deleteFirst();
			break;
			
			case 5: 
				list.deleteLast();
				break;
				
			case 6: 
			System.out.println("Enter position");
			posi=sc.nextInt();
			list.deleteAtPos(posi);
			break;
			
			case 7:System.out.println("Enter value");
			valu=sc.nextInt();
			System.out.println("Enter position");
			posi=sc.nextInt();
			list.updateData(valu,posi);
			break;
			
			case 8:list.reverseList();
			break;
			
			case 9: list.viewList();
			break;
			
			case 10: flag=false;
			break;
			
			
			
			default: System.out.println("invalid choice");
			
			
			
			}
		}
		
	}

}


class Linkedlists{
	
	class Node{
		private int data; private Node next; private Node prev;
		public Node() {
			data=0;next=null;prev=null;
		}
		public void setData(int d) {
			data=d;
		}
		public void setNext(Node n) {
			next=n;
		}
		public void setPrev(Node n) {
			prev=n;
		}
		public int getData() {return data;}
		public Node getNext() {return next;}
		public Node getPrev() {return prev;}
	}
	
	
	private Node start;
	private int size;
	private Node tail;
	
	public Linkedlists() {
		start=null;size=0;tail=null;
	}
	//reversing link list
	public void reverseList() {
		if(isEmpty()) {
			System.out.println("Empty List");
			return;
		}
		Node t=tail;
		while(t!=null) {
		
			System.out.print(t.getData()+ "|___|"+"-->");
			t=t.getPrev();
		
		}
		System.out.print("null");
			
		

	}
	public boolean isEmpty() {
		if(start==null) 
			return true;
		else
			return false;
	}
	public int getListSize() {
		return size;
	}
	public void viewList() {
		if(isEmpty()) {
			System.out.println("Empty List");
			return;
		}
		Node t=start;
		while(t!=null) {
		
			System.out.print(t.getData()+ "|___|"+"-->");
			t=t.getNext();
		
		}
		System.out.print("null");
		
	}
	public void insertAtFirst(int val) {
		Node n=new Node();
		n.setData(val);
		if(isEmpty()) tail=n;
		else start.setPrev(n);
		n.setNext(start);
		
		start=n;
		size++;
	}
	public void insertAtLast(int val) {
		Node t=start;
		Node n=new Node();
		n.setData(val);
		if(t==null) start=n;//if list is null
		else tail.setNext(n);
		n.setPrev(tail);
		tail=n;
		
		
		size++;
	}
	public void insertAtPos(int val,int pos) {
		if(start==null) {
			System.out.println("Empty list, Try Again");
			return;
		}
		Node t=start;
		Node n=new Node();
		n.setData(val);
		for(int i=1;i<pos-1;i++) {
			t=t.getNext();
		}
		n.setNext(t.getNext());
		t.getNext().setPrev(n);
		t.setNext(n);
		n.setPrev(t);
		size++;
	}
	public void updateData(int val,int pos) {
		if(isEmpty()||pos>size||pos<1) {
			System.out.println("Updation not possible");
			return;
		}
		Node t=start;
		for(int i=1;i<pos;i++) {
			t=t.getNext();
		}
		t.setData(val);
		
	}
	public void deleteFirst() {
		if(start==null) {
			System.out.println("list is empty");
			return;
		}
		else {
			Node t=start;
			start=start.getNext();
			t.setNext(null);
			t.setPrev(null);
			start.setPrev(null);
			size--;
		}
	}
	
	public void deleteLast() {
		if(start==null) {
			System.out.println("list is empty");
			return;
		}
		else {
			Node t=tail;
			tail=start.getPrev();
			t.setNext(null);
			t.setPrev(null);
			tail.setPrev(null);
			size--;
		}
	}
	
	public void deleteAtPos(int pos) {
		if(isEmpty()||pos>size||pos<1) {
			System.out.println("Deletetion not possible");
			return;
		}
		else {
			Node t=start;
			Node t1;
			for(int i=1;i<pos-1;i++) {
				t=t.getNext();
			}
			t1=t.getNext();
			t.setNext(t1.getNext());
			t1.getNext().setPrev(t);
			t1.setNext(null);
			t1.setPrev(null);
			size--;
		}
	}
	
	
	
}
