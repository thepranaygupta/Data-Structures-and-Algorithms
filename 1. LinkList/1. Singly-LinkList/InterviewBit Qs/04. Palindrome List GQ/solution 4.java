/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int lPalin(ListNode A) {
        int size=0;
        ListNode t=A;
        int mid=0;
        while(t!=null){
            size++;
            t=t.next;
        }
        if(size%2==0)
            mid=size/2;
        else
            mid=(size/2)+1;
        
        t=A;
        for(int i=1;i<mid;i++)
        {
            t=t.next;
        }
        ListNode newH=t.next;
        ListNode t1=reverseList(newH);
        t=A;
        int flag=1;
        if(size%2==0)
        {
            for(int i=1;i<=mid;i++)
            {
                if(t.val!=t1.val){
                    flag=0;
                    break;
                }
                t=t.next;
                t1=t1.next;
            }
            return flag;
        }
        else{
            for(int i=1;i<mid;i++)
            {
                if(t.val!=t1.val){
                    flag=0;
                    break;
                }
                t=t.next;
                t1=t1.next;
            }
            return flag;
        }
        
        
    }
    public ListNode reverseList(ListNode h) {
        ListNode curr=h;
        ListNode previous=null;
        ListNode nex=null;
        while(curr!=null) {
            nex=curr.next;
            curr.next=previous;
            previous=curr;
            curr=nex;
        }
        return previous;
    }
}