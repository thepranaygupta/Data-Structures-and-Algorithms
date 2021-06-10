/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp=dummy;
        int car=0;
        while(l1!=null || l2!=null || car==1){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=car;
            car=sum/10;
            ListNode node =new ListNode(sum%10);
            tmp.next=node;
            tmp=tmp.next;
            
        }
        return dummy.next;
    }
}