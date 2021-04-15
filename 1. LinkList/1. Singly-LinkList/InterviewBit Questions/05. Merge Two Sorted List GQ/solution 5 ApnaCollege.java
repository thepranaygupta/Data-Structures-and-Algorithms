/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode dummy=new ListNode(-1);
        ListNode p1=h1;
        ListNode p2=h2;
        ListNode p3=dummy;
        
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p3.next=p1;
                p1=p1.next;
            }
            else{
                p3.next=p2;
                p2=p2.next;
            }
            p3=p3.next;
        }
        
        while(p1!=null){
            p3.next=p1;
            p1=p1.next;
            p3=p3.next;
        }
        
        while(p2!=null){
            p3.next=p2;
            p2=p2.next;
            p3=p3.next;
        }
        
        return dummy.next;
        
        
    }
}