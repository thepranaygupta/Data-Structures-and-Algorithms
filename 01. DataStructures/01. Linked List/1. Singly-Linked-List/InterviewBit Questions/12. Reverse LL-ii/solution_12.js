// REMEMBER 
// you need legit linked list for input to test this solution, which you don't have but you have checked it on leet code
// it's workin fine. just push it on github as it is. it's legit solution and it's working.


var reverseBetween = function(head, left, right) {
    
    let dummy = new ListNode(null, head);
    let preNode = dummy;
    let current = head;
      let count = 0;
      while(count < left - 1) {
          current = current.next;
          preNode = preNode.next;
          count++;
      }
      
      count = 0;
      let pre = null;
      while(count < right - left + 1) {
          const temp = current.next;
          current.next = pre;
          pre = current;
          current = temp;
          count++;
      }
      
      preNode.next.next = current;
      preNode.next = pre;
      return dummy.next;
  };
  
