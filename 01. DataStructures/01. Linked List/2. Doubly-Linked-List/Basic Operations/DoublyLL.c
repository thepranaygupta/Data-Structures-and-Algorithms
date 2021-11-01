#include <stdio.h>
#include <malloc.h>

struct Node
{
    int val;
    struct Node *prev;
    struct Node *next;
};

typedef struct Node N;
N *start = NULL, *tmp, *ptr;

void CreateList()
{
    tmp = (N *)malloc(sizeof(N));
    printf("Enter value : ");
    scanf("%d", &tmp->val);
    tmp->next = NULL;
    if (start == NULL)
    {
        ptr = tmp;
        start = tmp;
        tmp->prev = NULL;
    }
    else
    {
        ptr->next = tmp;
        tmp->prev = ptr;
        ptr = tmp;
    }
}

void DisplayList()
{
    tmp = start;
    while (tmp->next != NULL)
    {
        printf("%d -> ", tmp->val);
        tmp = tmp->next;
    }
    while (tmp != NULL)
    {
        printf("%d <- ", tmp->val);
        tmp = tmp->prev;
    }
}

void InsertBeg()
{
    ptr = (N *)malloc(sizeof(N));
    printf("Enter value : ");
    scanf("%d",&ptr->val);
    ptr->prev = NULL;
    ptr->next = start;
    tmp = start;
    tmp->prev = ptr;
}

void InsertEnd()
{
    tmp = start;
    while(tmp->next!=NULL)
    {
        tmp = tmp->next;
    }
    ptr = (N *)malloc(sizeof(N));
    printf("Enter value : ");
    scanf("%d",&ptr->val);
    ptr->next = NULL;
    ptr->prev = tmp;
    tmp->next = ptr;
}

void InsertAfter()
{
    int n;
    printf("Enter node after which you want to insert : ");
    scanf("%d",&n);
    ptr = start;
    while(ptr->val!=n)
    {
        ptr = ptr->next;
    }
    tmp = (N *)malloc(sizeof(N));
    printf("Enter value : ");
    scanf("%d",&tmp->val);
    tmp->next = ptr->next;
    ptr->next->prev = tmp;
    ptr->next = tmp;
    tmp->prev = ptr;
}

void DeleteFirst()
{
    tmp = start;
    start = tmp->next;
    tmp->next->prev = NULL;
    free(tmp);
}

void DeleteLast()
{
    tmp = start;
    while(tmp->next->next!=NULL)
    {
        tmp = tmp->next;
    }
    free(tmp->next);
    tmp->next = NULL;
}

void DeleteAny()
{
    int n;
    printf("Enter value to delete : ");
    scanf("%d",&n);
    tmp = start;
    while(tmp->next->val!=n)
    {
        tmp = tmp->next;
    }
    ptr = tmp->next;
    tmp->next = tmp->next->next;
    tmp->next->next->prev = tmp;
    free (ptr);
}

int main()
{
    int ch;
    do
    {
        printf("\n\t-: M E N U :- \n================================\n");
        printf("\n1.....Create List.");
        printf("\n2.....Display List.");
        printf("\n3.....Insert at Beginning.");
        printf("\n4.....Insert at the end.");
        printf("\n5.....Insert After a node.");
        printf("\n6.....Delete First node.");
        printf("\n7.....Delete Last node.");
        printf("\n8.....Delete Any node.");
        printf("\n0.....Exit.");
        printf("\nEnter your choice : ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 0:
            printf("\nEnd of Program\n");
            break;
        case 1:
            CreateList();
            break;
        case 2:
            DisplayList();
            break;
        case 3:
            InsertBeg();
            break;
        case 4:
            InsertEnd();
            break;
        case 5:
            InsertAfter();
            break;
        case 6:
            DeleteFirst();
            break;
        case 7:
            DeleteLast();
            break;
        case 8:
            DeleteAny();
            break;
        default:
            printf("\nInvalid Choice!!\n");
        }

    } while (ch != 0);
    return 0;
}
