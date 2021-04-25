/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next=head;
        ListNode tmp = dummy;
        
        while(head != null) {
            if(head.next != null && head.val == head.next.val){
                //skip the nodes whose values are equal to head.
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                tmp.next = head.next;
            }
            else{
                tmp = tmp.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}