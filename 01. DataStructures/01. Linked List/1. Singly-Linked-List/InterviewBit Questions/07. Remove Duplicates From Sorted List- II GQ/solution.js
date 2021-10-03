// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
  //param A : head node of linked list
  //return the head node in the linked list
  deleteDuplicates: function (A) {
    let previousPointer = new Node();
    previousPointer.next = A;
    let temp = previousPointer;
    while (A) {
      if (A && A.next && A.next.data == A.data) {
        while (A.next && A.data == A.next.data) A = A.next;

        temp.next = A.next;
      } else {
        temp = temp.next;
      }
      A = A.next;
    }
    return previousPointer.next;
  },
};
