/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int l1=getLength(head1);
        int l2=getLength(head2);
        int d=0;
        ListNode ptr1=null;
        ListNode ptr2=null;
        
        if(l1>l2)
        {
            d=l1-l2;
            ptr1=head1;
            ptr2=head2;
            
        }
        else{
            d=l2-l1;
            ptr1=head2;
            ptr2=head1;
        }
        
        while(d!=0){
            ptr1=ptr1.next;
            d--;
        }
        
        while(ptr1!=null && ptr2!=null){
            if(ptr1==ptr2) 
                return ptr1;
            ptr1=ptr1.next;
            ptr2=ptr2.next;
            
        }
        return null;
    }
    public int getLength(ListNode head){
        ListNode t=head;
        int size=0;
        while(t!=null){
            size++;
            t=t.next;
        }
        return size;
    }
}