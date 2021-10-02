#include <stdio.h>
#include <malloc.h>
struct Stack
{
    int val;
    struct Stack *next;
};
typedef struct Stack N;
N *top = NULL, *tmp;

void Push();
void Status();
void Pop();
void Peek();
void Search();
void Update();

int main()
{
    int ch, val;
    do
    {
        printf("\n\tM.E.N.U.\n=======================\n");
        printf("\n1.....Push.");
        printf("\n2.....Status.");
        printf("\n3.....Pop.");
        printf("\n4.....Peek");
        printf("\n5.....Search.");
        printf("\n6.....Update.");
        printf("\n7.....Exit.");
        printf("\nEnter your choice : ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 1:
            Push();
            break;
        case 2:
            Status();
            break;
        case 3:
            Pop();
            break;
        case 4:
            Peek();
            break;
        case 5:
            Search();
            break;
        case 6:
            Update();
            break;
        case 7:
            printf("\nEnd of Program\n");
            break;
        default:
            printf("\nInvalid Input!!\n");
            break;
        }
    } while (ch != 7);
    return 0;
}
void Push()
{
    tmp = (N *)malloc(sizeof(N));
    printf("Enter value to push : ");
    scanf("%d", &tmp->val);
    if (top == NULL)
    {
        top = tmp;
        tmp->next = NULL;
    }
    else
    {

        tmp->next = top;
        top = tmp;
    }
}
void Status()
{
    printf("\nStack is Now :\n");
    tmp = top;
    while (tmp != NULL)
    {
        printf("%d\n", tmp->val);
        tmp = tmp->next;
    }
}
void Pop()
{
    if (top == NULL)
    {
        printf("\nStack Underflow\n");
        return;
    }
    else
    {
        printf("\n%d is Popped\n",top->val);
        tmp = top;
        top = top->next;
        free(tmp);
    }
}
void Peek()
{
    if (top == NULL)
    {
        printf("\nStack Underflow\n");
        return;
    }
    else
    {
        printf("\nTop value is %d\n", top->val);
    }
}
void Search()
{
    int n, i = 0, flag = 0;
    printf("Enter value to search : ");
    scanf("%d", &n);
    tmp = top;
    while (tmp != NULL)
    {
        i++;
        if (n == tmp->val)
        {
            flag = 1;
            break;
        }
        tmp = tmp->next;
    }
    if (flag == 1)
        printf("\nSearch Successful, Location is %d\n", i);
    else
        printf("\nSearch Failed\n");
}
void Update()
{
    int n, n1, flag = 0;
    printf("Enter value to update : ");
    scanf("%d", &n);
    tmp = top;
    while (tmp != NULL)
    {
        if (tmp->val == n)
        {
            printf("Enter new value : ");
            scanf("%d", &n1);
            tmp->val = n1;
            flag = 1;
            break;
        }
        tmp = tmp->next;
    }
    if (flag == 1)
        printf("\nSuccessfully Updated\n");
    else
        printf("\nValue not found in the Stack!!\n");
}