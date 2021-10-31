#include<stdio.h>
#include<stdlib.h>

// #define N  5;
int st[5];
int top = -1;

void push(int n){
    if(top == 5-1){
        printf("\nOverflow Condition No Further Data Can Be Pushed!\n");
    }
    else{
        top++;
        st[top] = n;
    }
}

void pop(){
    if(top == -1){
        printf("\nNO DATA TO POP\n");
    }
    else{
        int item = st[top];
        top--; 
        printf("\nThe deleted item is %d\n" , item); 

    }
}

void display(){
    for (int i = top; i >= 0; i--)
    {
        printf("%d " , st[i]);
    }
    
}
void peek(){
    int item ;
    if (top == -1)
    {
        printf("No Data To Peek!");
    }
    else{
        item = st[top];
        printf("The Item at the top is %d" , item);
    }
    
}


int main(){
    int choice = 1;
    int num;
    while (choice)
    {
        system("CLS");
        // clrscr(); clear screen
        display();
        printf("\nPRESS - 1 FOR PUSH\nPRESS - 2 FOR POP\nPRESS - 3 FOR DISPLAY\nPRESS - 4 TO PEEK \nPRESS - 5 TO EXIT");
        printf("\nEnter your Choice : ");
        scanf("%d" , &choice);
        switch (choice)
        {
        case 1:
            
            printf("\nEnter the number : ");
            scanf("%d" , &num);
            push(num);
            break;
        case 2:
            pop();
            break;
        case 3:
            printf("\n");
            display();
            printf("\n");
            break;
        case 4:
            peek();
            break;
        case 5:
            choice = 0;
            break;

        default:
            printf("\nInvalid Input \n");
            break;
        }
    }
    
    return 0;
}
