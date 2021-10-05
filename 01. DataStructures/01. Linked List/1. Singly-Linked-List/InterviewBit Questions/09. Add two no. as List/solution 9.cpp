
struct ListNode {
     int val;
    ListNode *next;
      ListNode(int x) : val(x), next( NULL ) {}
  };
 
ListNode* Solution::addTwoNumbers(ListNode* A, ListNode* B) {

    ListNode * it1=A,*it2=B,*it=0,*newNode,*C=0,*tmp1,*tmp2;
    int c=0,sum;
    while(it1 && it2)
    {
        sum=it1->val+it2->val+c;
        newNode = new ListNode(sum%10);
        c=sum/10;
        tmp1=it1->next;
        tmp2=it2->next;
        delete it1;
        delete it2;
        it1=tmp1;
        it2=tmp2;
        if(it==0)
        {
            it=newNode;
            C=it;
        }
        else
        {
            it->next=newNode;
            it=newNode;
        }
    }
    if(!it1)
        it1=it2;
    while(it1)
    {
        sum=it1->val+c;
        newNode = new ListNode(sum%10);
        c=sum/10;
        if(it==0)
        {
            it=newNode;
            C=it;
        }
        else
        {
            it->next=newNode;
            it=newNode;
        }
        tmp1=it1->next;
        delete it1;
        it1=tmp1;
    }
    if(c)
    {
        newNode = new ListNode(c);
        it->next=newNode;
    }
    return C;
}