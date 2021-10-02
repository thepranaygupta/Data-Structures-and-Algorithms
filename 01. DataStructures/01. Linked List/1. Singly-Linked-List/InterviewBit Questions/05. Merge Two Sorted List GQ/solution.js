// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
  //param A : head node of linked list
  //param B : head node of linked list
  //return the head node in the linked list
  mergeTwoLists: function (A, B) {
    let ans = new Node(null);
    let head = ans;
    while (A && B) {
      if (A.data > B.data) {
        ans.next = B;

        B = B.next;
      } else {
        ans.next = A;
        A = A.next;
      }
      ans = ans.next;
    }

    if (!A) {
      ans.next = B;
    } else {
      ans.next = A;
    }

    return head.next;
  },
};
