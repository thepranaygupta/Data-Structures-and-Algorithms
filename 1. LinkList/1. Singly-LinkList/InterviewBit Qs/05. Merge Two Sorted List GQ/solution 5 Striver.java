/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val>l2.val){
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        ListNode res=l1;
        while(l1!=null && l2!=null){
            ListNode t=null;
            while(l1!=null && l1.val<=l2.val){
                t=l1;
                l1=l1.next;
            }
            t.next=l2;
            
            //swap
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        return res;
    }
}