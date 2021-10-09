//Problem :- Iterative function to show Linear Search in Linked List

#include<stdio.h>
#include<stdlib.h>

struct Node
{
	int data;
	struct Node *next;
}*first=NULL;

void create (int A[], int n)
{
	int i; 
	struct Node *t, *last;
	first=(struct Node *)malloc(sizeof(struct Node));
	first->data=A[0];
	first->next=NULL;
	last=first;
	for(i=1; i<n; i++)
	{
		t=(struct Node *)malloc(sizeof(struct Node));
		t->data=A[i];
		t->next=NULL;
		last->next=t;
		last=t;
	}
}

struct Node * LSearch(struct Node *p, int key)
{
	while(p!=NULL)
	{
		if(key == p->data)
		return p;
		p=p->next;
	}
	return NULL;
}

int main()
{
	struct Node *temp;
	int A[]={3,5,7,10,25,8,32,2};
	create(A,8);
	temp = LSearch(first, 32);
	if(temp)
	printf("Key is found = %d",temp->data);
	else
	printf("Key isn't found");
	return 0;	
}


/*

Output:- 

Key is found = 32

*/
