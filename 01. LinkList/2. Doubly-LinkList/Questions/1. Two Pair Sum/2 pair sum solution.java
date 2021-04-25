// Java program to find a
// pair with given sum x.
class doublyLL
{

// structure of node of
// doubly linked list
static class Node
{
	int data;
	Node next, prev;
};

// Function to find pair whose
// sum equal to given value x.
static void pairSum( Node head, int x)
{
	// Set two pointers, first
	// to the beginning of DLL
	// and second to the end of DLL.
	Node first = head;
	Node second = head;
	while (second.next != null)
		second = second.next;

	// To track if we find a pair or not
	boolean found = false;

	// The loop terminates when either
	// of two pointers become null, or
	// they cross each other (second.next
	// == first), or they become same
	// (first == second)
	while (first != null && second != null &&
		first != second && second.next != first)
	{
		// pair found
		if ((first.data + second.data) == x)
		{
			found = true;
			System.out.println( "(" + first.data +
								", "+ second.data + ")" );

			// move first in forward direction
			first = first.next;

			// move second in backward direction
			second = second.prev;
		}
		else
		{
			if ((first.data + second.data) < x)
				first = first.next;
			else
				second = second.prev;
		}
	}

	// if pair is not present
	if (found == false)
		System.out.println("No pair found");
}

// A utility function to insert
// a new node at the beginning
// of doubly linked list
static Node insert(Node head, int data)
{
	Node temp = new Node();
	temp.data = data;
	temp.next = temp.prev = null;
	if (head == null)
		(head) = temp;
	else
	{
		temp.next = head;
		(head).prev = temp;
		(head) = temp;
	}
	return temp;
}

// Driver Code
public static void main(String args[])
{
	Node head = null;
	head = insert(head, 9);
	head = insert(head, 8);
	head = insert(head, 6);
	head = insert(head, 5);
	head = insert(head, 4);
	head = insert(head, 2);
	head = insert(head, 1);
	int x = 7;

	pairSum(head, x);
}
}

// This code is contributed
// by Arnab Kundu
