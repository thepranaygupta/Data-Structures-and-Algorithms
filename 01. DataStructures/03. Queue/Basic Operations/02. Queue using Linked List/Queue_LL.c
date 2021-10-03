#include <stdio.h>
#include <malloc.h>
struct Queue
{
    int val;
    struct Queue *next;
};
typedef struct Queue N;
N *front = NULL, *rear = NULL, *ptr;

void Insert()
{
    ptr = (N *)malloc(sizeof(N));
    printf("Enter value : ");
    scanf("%d",&ptr->val);
    ptr->next = NULL;
    if(front == NULL)
    {
        front = ptr;
        rear = ptr;
        front->next = NULL;
        rear->next = NULL;
    }
    else
    {
        rear->next = ptr;
        rear = ptr;
        rear->next = NULL;
    }
}

void Delete()
{
    if(front == NULL)
    {
        printf("\nUnderflow\n");
        return;
    }
    ptr = front;
    front = front->next;
    free(ptr);
}

void Display()
{
    ptr = front;
    while(ptr!=rear)
    {
        printf("%d ",ptr->val);
        ptr = ptr->next;
    }
}

int main()
{
    int ch;
    do
    {
        printf("\n\tM.E.N.U.\n=======================\n");
        printf("\n1.....Insert.");
        printf("\n2.....Delete.");
        printf("\n3.....Display.");
        printf("\n4.....Exit.");
        printf("\nEnter your choice : ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            Insert();
            break;
        case 2:
            Delete();
            break;
        case 3:
            Display();
            break;
        case 4:
            printf("\nEnd of Program\n");
            break;
        default:
            printf("\nInvalid Input!!\n");
            break;
        }
    } while (ch != 4);
    return 0;
}