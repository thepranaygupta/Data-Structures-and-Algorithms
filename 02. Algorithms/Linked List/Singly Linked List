#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
struct node{
	int info;
	struct node*link;
}* start=NULL;
int data,item,pos,count;
int ch=1;
struct node*newnode,*list,*xnode,*loc,*ptr,*save,*prev,*loc;
void display(){
	if(start==NULL)
		printf("\nList is empty");
	else{
		xnode=start;
		printf("\nElements are : \t");
		while(xnode!=NULL){
			printf("[%d]",xnode->info);
			xnode = xnode->link;
		}
		printf("\n");
	}
}
void createlist(){
	while(1){
		printf("\nEnter data : ");
		scanf("%d",&data);
		if(ch==1){
			newnode=(struct node*)malloc(sizeof(struct node));
			newnode->info=data;
			newnode->link=NULL;
			if(start==NULL){
				start=newnode;
				list=newnode;
			}
			else{
				list->link=newnode;
				list=newnode;
			}
		}
		printf("Do you want to enter data,Enter 0 for exit and 1 for continue : ");
		scanf("%d",&ch);
		if(ch!=1)
			break; 		
	}
	display();
}
void insertbeg(){
	printf("\nEnter element to be inserted : ");
	scanf("%d",&item);
	newnode = (struct node*)malloc(sizeof(struct node));
	newnode ->info=item;
	if(start==NULL)
		newnode->link=NULL;
	else
		newnode->link=start;
	start=newnode;
	display();
}
void insertend(){
	printf("\nEnter the element to be inserted : ");
	scanf("%d",&item);
	newnode = (struct node*)malloc(sizeof(struct node));
	newnode->info=item;
	newnode->link=NULL;
	if(start==NULL){
		start = newnode;
		list = newnode;
	}
	else{
		list->link = newnode;
		list = newnode;
	}
	display();
}
void insertnode(){
	printf("\nEnter the element to be inserted : ");
	scanf("%d",&item);
	printf("\nEnter the element position to be inserted : ");
	scanf("%d",&pos);
	newnode=(struct node*)malloc(sizeof(struct node));
	newnode->info = item;
	ptr=start;
	for(count=0;count<=pos-1;count++){
		loc = ptr;
		ptr = ptr->link;
	}
	newnode->link = loc->link;
	loc->link = newnode;
	display();
}
void delnode(){
	printf("\nElement to be deleted : ");
	scanf("%d",&item);
	newnode = start;
	while(newnode!= NULL){
		if((newnode->info==item)){
			if(newnode==start)
				start = newnode->link;
			else{
				prev->link = newnode->link;
				free(newnode);
			}
			
			printf("\n\t%d is deleted", item);
			break;
		}
		else{
			prev = newnode;
			newnode = newnode->link;
		}
		
	}
	display();
}
void search(){
	int flag=0;
	printf("\n Enter the element to be searched : ");
	scanf("%d",&item);
	ptr = start;
	count=-1;
	while(ptr!=NULL){
		if(ptr->info==item){
			count++;
			printf("   %d found at position %d\n",item,count);
			flag=1;
			loc = ptr;
			break;
		}
		else{
			ptr = ptr->link;
			count++;
			
		}
	}
	if(flag==0)
		printf("%d not found\n",item);		
}
void main(){
	int ch1;
	char ch2;
	while(1){
		printf("\n 1.Create \t 2.Insert at first\n 3.Insert at end ");
		printf("4.Insert at a location\n 5.Delete \t 6.Search\n7. Dispaly\t 8.Exit");
		printf("\nEnter your choice : ");
		scanf("%d",&ch1);
		switch(ch1){
			case 1: createlist();break;
			case 2: insertbeg();break;
			case 3: insertend();break;
			case 4: insertnode();break;
			case 5: delnode();break;
			case 6: search();break;
			case 7 : display(); break;
			case 8 :exit(0);
			default : printf("\n Invalid choice");
		}
	}
	getch();
}
