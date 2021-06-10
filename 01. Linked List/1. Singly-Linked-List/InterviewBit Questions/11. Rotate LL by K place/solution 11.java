/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode last=head;
        ListNode t=head;
        int size=0;
        while(t.next!=null)
        {
            size++;
            t=t.next;
        }
        size++;
        
        if(size==1){
            return head;
        }
        if(k>size){
            k=k%size;
        }
        if(k==0) return head;
        
        
        int lpos=size-k;
        
        while(lpos>1){
            last=last.next;
            lpos--;
        }
        
        ListNode start=last.next;
        
        t.next=head;
        last.next=null;
        
        return start;
    }
}