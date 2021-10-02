// Definition for singly-linked list.
//    function Node(data){
//      this.data = data
//      this.next = null
//    }

module.exports = {
  //param A : head node of linked list
  //return an integer
  lPalin: function (A) {
    let fastPointer = A,
      slowPointer = A,
      prev = null;
    while (fastPointer && fastPointer.next) {
      fastPointer = fastPointer.next.next;
      const next = slowPointer.next;
      slowPointer.next = prev;
      prev = slowPointer;
      slowPointer = next;
    }
    if (fastPointer) {
      slowPointer = slowPointer.next;
    }

    while (slowPointer || prev) {
      if (slowPointer.data !== prev.data) {
        return 0;
      }
      slowPointer = slowPointer.next;
      prev = prev.next;
    }
    return 1;
  },
};
