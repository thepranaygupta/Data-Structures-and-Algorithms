package linklist;
import java.util.*;

import linklist.Linkedlist.Node;




public class CircularLL {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Linklist list=new Linklist();
		
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
			System.out.println("8. Reverse link list");
			System.out.println("9. View List");
			System.out.println("10. Get List Size");
			System.out.println("11. Exit");
			
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
			
			case 10: System.out.println(list.getListSize());
			break;
			
			case 11: flag=false;
			break;
			
			
			
			default: System.out.println("invalid choice");
			
			
			
			}
		}
		
	}

}


class Linklist{
	
	class Node{
		private int data; private Node next;
		public Node() {
			data=0;next=null;
		}
		public void setData(int d) {
			data=d;
		}
		public void setNext(Node n) {
			next=n;
		}
		public int getData() {return data;}
		public Node getNext() {return next;}
	}
	
	
	private Node last;
	private int size;
	
	public Linklist() {
		last=null;size=0;
	}
	//reversing link list
	public void reverseList() {
		Node t=last.getNext();
		Node curr=last.getNext();
		Node previous=last;
		Node nex=null;
		while(curr!=last) {
			nex=curr.getNext();
			curr.setNext(previous);
			previous=curr;
			curr=nex;
		}
		last.setNext(previous);
		last=t;
		}
	public boolean isEmpty() {
		if(last==null) 
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
		Node t=last.getNext();
		while(t!=last) {
			System.out.print(t.getData()+ "|___|-->");
			t=t.getNext();
		}
		System.out.print(t.getData()+"|___|-->"+last.getNext().getData()+"(Node1)");
	}
	public void insertAtFirst(int val) {
		Node n=new Node();
		n.setData(val);
		if(isEmpty()) 
			last=n;
		else
			n.setNext(last.getNext());
		last.setNext(n);
		size++;
	}
	public void insertAtLast(int val) {
		
		Node n=new Node();
		n.setData(val);
		if(isEmpty()) {//if list is null
			last=n;
			last.setNext(n);
		}
		else {
			n.setNext(last.getNext());
			last.setNext(n);
			last=n;
		}
		size++;
	}
	public void insertAtPos(int val,int pos) {
		if(isEmpty()||pos>size||pos<1) {
			System.out.println("Insertion not possible");
			return;
		}
		else if(pos==1) {
			insertAtFirst(val);
		}
		else if(pos==size) {
			insertAtLast(val);
		}
		else {
			Node t=last.getNext();
			Node n=new Node();
			n.setData(val);
			for(int i=1;i<pos-1;i++) {
				t=t.getNext();
			}
			n.setNext(t.getNext());
			t.setNext(n);
			size++;	
		}
		
	}
	public void updateData(int val,int pos) {
		if(isEmpty()||pos>size||pos<1) {
			System.out.println("Updation not possible");
			return;
		}
		Node t=last.getNext();
		for(int i=1;i<pos;i++) {
			t=t.getNext();
		}
		t.setData(val);
		
	}
	public void deleteFirst() {
		if(last==null) {
			System.out.println("list is empty");
			return;
		}
		else {
			Node first=last.getNext();
			last.setNext(first.getNext());
			first.setNext(null);
			size--;
		}
	}
	
	public void deleteLast() {
		if(last==null) {
			System.out.println("list is empty");
			return;
		}
		else {
			Node t=last.getNext();
			while(t.getNext().getNext()!=last.getNext())
			{
				t=t.getNext();
			}
			t.setNext(last.getNext());
			last.setNext(null);
			last=t;
			size--;
		}
	}
	
	public void deleteAtPos(int pos) {
		if(isEmpty()||pos>size||pos<1) {
			System.out.println("Deletetion not possible");
			return;
		}
		else if(pos==1) {
			deleteFirst();
		}
		else if(pos==size) {
			deleteLast();
		}
		else {
			Node t=last.getNext();
			Node t1;
			for(int i=1;i<pos-1;i++) {
				t=t.getNext();
			}
			t1=t.getNext();
			t.setNext(t1.getNext());
			t1.setNext(null);
			size--;
		}
	}
	
	
	
}
