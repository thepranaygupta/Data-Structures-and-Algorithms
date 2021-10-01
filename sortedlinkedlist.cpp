#include<stdio.h>
#include<stdlib.h>
struct node{
            int info;
            struct node  *next;
            };
struct node *insert( struct node *start,int data);
void display(struct node *start);
void search( struct node *start,int data);
 main(){
    int data,choice,i,n;
    struct node  *start=NULL;
    while(1){
    printf("\n1.insert");
    printf("\n2.display");
    printf("\n3.search");
    printf("\nEnter choice:");
    scanf("%d",&choice);
    switch(choice)
    {
    case 1: printf("\nEnter the size:");
            scanf("%d",&n);
            for(i=0;i<n;i++)
            {
                printf("\nEnter element");
                scanf("%d",&data);
                start=insert(start,data);
            }
            break;
    case 2: display(start);
            break;
    case 3:printf("\nEnter element to be searched:");
            scanf("%d",&data);
            search(start,data);
            break;
    case 4: exit(1);
            default:printf("\nWrong choice");
    }
    }

}
struct node *insert(struct node *start,int data)
{   struct node *temp,*p;
    temp=(struct node *)malloc(sizeof(struct node));
    temp->info=data;
    if (start==NULL || data<start->info)
    {
        temp->next=start;
        start=temp;
        return start;
    }
    else
    { p=start;
     while(p->next!=NULL && data>p->next->info)
            p=p->next;
     temp->next=p->next;
     p->next=temp;

        }
   return start;
}
void display(struct node *start)
{
    struct node *p;
    p=start;
    while(p!=NULL)
    {
        printf("%d ",p->info);
        p=p->next;
    }
    printf("\n");

}
void search( struct node *start,int data)
{
    int pos=1;
    struct node *p;
    p=start;
    if (start==NULL || data<start->info)
    {
        printf("%d not found",data);
        return;
    }
    while(p!=NULL || p->info<=data){
        if (p->info==data)
        {
            printf ("%d present in index %d",data,pos);
            return;
        }
        pos++;
        p=p->next;
    }
    printf("%d not present",data);
    return;

}