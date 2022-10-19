#include<stdio.h>
#include<bits/stdc++.h>
using namespace std;

struct Node {
	int data;
	struct Node *next;
} *head = NULL;
struct Node* tail;


//creating a linked list
void create(int a[], int n) {
	struct Node *temp, *tail;

	head = new Node();
	head -> data = a[0];
	head -> next = NULL;
	tail = head;

	for (int i = 1; i < n; i++) {
		temp = new Node();
		temp -> data = a[i];
		temp -> next = NULL;
		tail -> next = temp;
		tail = temp;
	}
}
int Rmax(struct Node*p) {
	int x = 0;
	if (p == 0) {
		return INT_MIN;
	}
	else {
		x = Rmax(p->next);
		if (x > p->data)
			return x;
		else
			return (p->data);

	}
}
int main() {
	int a[] = {3, 5, 10, 98, 1, 41, 100, 23, 56, 89};
	create(a, 10);
  	cout << "Largest Number present:" << Rmax(head) << endl;
return 0;
}
