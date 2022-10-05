// C++ implementation to sort a k sorted doubly
// linked list
#include<bits/stdc++.h>
using namespace std;

// a node of the doubly linked list
struct Node {
	int data;
	struct Node* next;
	struct Node* prev;
};


// function to sort a k sorted doubly linked list
struct Node* sortAKSortedDLL(struct Node* head, int k)
{
	if(head == NULL || head->next == NULL)
		return head;

	// perform on all the nodes in list
	for(Node *i = head->next; i != NULL; i = i->next) {
		Node *j = i;
		// There will be atmost k swaps for each element in the list
		// since each node is k steps away from its correct position
		while(j->prev != NULL && j->data < j->prev->data) {
			// swap j and j.prev node
			Node* temp = j->prev->prev;
			Node* temp2 = j->prev;
			Node *temp3 = j->next;
			j->prev->next = temp3;
			j->prev->prev = j;
			j->prev = temp;
			j->next = temp2;
			if(temp != NULL)
				temp->next = j;
			if(temp3 != NULL)
				temp3->prev = temp2;
		}
		// if j is now the new head
	// then reset head
		if(j->prev == NULL)
			head = j;
	}
	return head;
}

// Function to insert a node at the beginning
// of the Doubly Linked List
void push(struct Node** head_ref, int new_data)
{
	// allocate node
	struct Node* new_node =
		(struct Node*)malloc(sizeof(struct Node));

	// put in the data
	new_node->data = new_data;

	// since we are adding at the beginning,
	// prev is always NULL
	new_node->prev = NULL;

	// link the old list off the new node
	new_node->next = (*head_ref);

	// change prev of head node to new node
	if ((*head_ref) != NULL)
		(*head_ref)->prev = new_node;

	// move the head to point to the new node
	(*head_ref) = new_node;
}

// Function to print nodes in a given doubly linked list
void printList(struct Node* head)
{
	// if list is empty
	if (head == NULL)
		cout << "Doubly Linked list empty";

	while (head != NULL) {
		cout << head->data << " ";
		head = head->next;
	}
}

// Driver program to test above
int main()
{
	struct Node* head = NULL;

	// Create the doubly linked list:
	// 3<->6<->2<->12<->56<->8
	push(&head, 8);
	push(&head, 56);
	push(&head, 12);
	push(&head, 2);
	push(&head, 6);
	push(&head, 3);

	int k = 2;

	cout << "Original Doubly linked list:\n";
	printList(head);

	// sort the biotonic DLL
	head = sortAKSortedDLL(head, k);

	cout << "\nDoubly linked list after sorting:\n";
	printList(head);

	return 0;
}

// This code is contributed by sachinejain74754.
