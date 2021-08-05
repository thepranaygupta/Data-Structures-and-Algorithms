/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head, int k) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        
        int count=0;
        
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(next!=null)
            head.next=reverseList(next,k);
        return prev;
    }
}