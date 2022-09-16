  // // this won't work as we don't have linked list data structure paste this code 
// in leetcode editor it will run jsut fine.


var deleteDuplicates = function(head) {
    if(!head) return null;
     
   let dummy = new ListNode(null, head);
   let prev = dummy;
     while(head && head.next) {
         if(head.val == head.next.val) {
             while(head.next && head.val == head.next.val) {
                 head = head.next;
             }
             prev.next = head.next;
         } else {
             prev = prev.next;
         }
         head = head.next;
     }
     
     return dummy.next;
 };
