// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
  //param A : head node of linked list
  //return the head node in the linked list
  reverseList: function (A) {
    prev = null;
    while (A) {
      temp = A.next;
      A.next = prev;
      prev = A;
      A = temp;
    }
    return prev;
  },
};
