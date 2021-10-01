Question link:- https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
Solution:- 
  class Solution
{
    public:
    struct node *reverse (struct node *head, int k)
    { 
        Node* curr = head;
        Node* nex;
        Node* prev = NULL;
        int c = 0;
        while(curr!=NULL and c<k){
            nex = curr->next;
            curr->nex = prev;
            prev = curr;
            curr = nex;
            c++;
        }
        if(nex!=NULL){
            head->next = revers(next,k);
        }
        return prev;
    }
};
