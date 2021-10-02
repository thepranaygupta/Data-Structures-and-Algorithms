#include <iostream>

using namespace std;

class Node {
    public:
        int data;
        Node *prev;
        Node *next;
};

// void emptyListHandler(Node *node){
//     Node *new_node = new Node;
    
//     if((node) == NULL){
//         new_node->prev = new_node->next = new_node;
//         (node) = new_node;
//         return;
//     }
// }


void append(Node **head, int data){
    
    Node *new_node = new Node;
    new_node->data = data;
    
     if((*head) == NULL){
        new_node->prev = new_node->next = new_node;
        (*head) = new_node;
        return;
      }
    
    Node *last = (*head)->prev;
    new_node->next = (*head);
    (*head)->prev = new_node;
    new_node->prev = last;
    last->next = new_node;
}

void insertAtbegin(Node **head, int data){
    
    Node *new_node = new Node;
    new_node->data = data;
    
    if((*head) == NULL){
        new_node->prev = new_node->next = new_node;
        (*head) = new_node;
        return;
      }
    
    Node *last = (*head)->prev;
    new_node->prev = last;
    new_node->next = (*head);
    last->next = new_node;
    (*head)->prev = new_node;
    
    (*head) = new_node;
}

// new node data and prev node data
void insertAfter(Node **head, int new_node_data, int prev_node_data){
    int d1 = prev_node_data;
    int d2 = new_node_data;
    
    Node *new_node = new Node;
    new_node->data = d2;
    
   if((*head) == NULL){
        new_node->prev = new_node->next = new_node;
        (*head) = new_node;
        return;
      }
    
    Node *temp = (*head);
    
    while(temp->data != d1){
        temp = temp->next;
    }
    
    Node *next = temp->next;
    temp->next = new_node;
    new_node->prev = temp;
    new_node->next = next;
    next->prev = new_node;
    
}

void display( Node *start)
{
    Node *temp = start;
 
    printf("\nTraversal in forward direction \n");
    while (temp->next != start)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("%d ", temp->data);
 
    // printf("\nTraversal in reverse direction \n");
    // Node *last = start->prev;
    // temp = last;
    // while (temp->prev != last)
    // {
    //     printf("%d ", temp->data);
    //     temp = temp->prev;
    // }
    // printf("%d ", temp->data);
}

void findSize(Node *head){
    
    if(head == NULL) return;
    
    Node *temp = head;
    int count = 1;
 
    cout << "\nSize of the CDLL: ";
    while (head->prev != temp)
    {
        count++;
        temp = temp->next;
    }
    cout << count << endl;
}

 void ReverseList(Node **Head){
        // while((*Head)->next != NULL){
        //     *Head->next = *Head;
        // }
        
        Node *temp = NULL;
        Node *current = *Head;
        // Node *last = *Head->prev;
        
        do {
            temp = current->prev;
            current->prev = current->next;
            current->next = temp;
            current = current->prev;
        } while(current != *Head);
        
        if(temp != NULL) *Head = temp->prev;
        
    }
    


int main() {
    Node *head = NULL;
    
    append(&head, 6);
    insertAtbegin(&head, 5);
    
    insertAtbegin(&head, 1);
    
    insertAfter(&head, 8, 6);
    insertAfter(&head, 2, 1);
    insertAfter(&head, 9, 8);
    
    display(head);
    
    ReverseList(&head);
    
    display(head);
    
    findSize(head);
    return 0;
}
