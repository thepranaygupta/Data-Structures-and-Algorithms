/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A, int B) {
        ListNode t=A;int n=0;
        while(t!=null){
            n++;
            t=t.next;
        }
        int mn=(n/2)+1;
        t=A;
        int nd=mn-B;
        if(nd<1){return -1;}
        else{
        for(int i=1;i<nd;i++)
        {
            t=t.next;
        }
        return t.val;}
    }
}