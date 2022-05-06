
    /**
     * To reverse a LinkedList, we need to reverse one node at a time.
     * We will start with a variable current which will initially point to the head of the LinkedList
     * and a variable previous which will point to the previous node that we have processed;
     * initially previous will point to null.In a stepwise manner, we will reverse the current node by pointing
     * it to the previous before moving on to the next node.
     * Also, we will update the previous to always point to the previous node that we have processed.
     * @param node the head of the linked list
     * @return the reversed linked list
     *
     * Here is visual representation of how previous is populated in each iteration
     * Example: 4(head) -> 3 -> 0 -> 9
     * 1: previous =  4 -> null
     * 2: previous = 3 -> 4
     * 3: previous = 0 -> 3
     * 4: previous = 9 -> 0
     *
     * By the end of the iteration 9 is point to 0(9->0). if we go to 0's next field we get 3 and so on until null
     */
    public static ListNode reverseList(ListNode node) {
//       //
//        // p = 3 -> 4 -> null
        //
        ListNode current = node;            // stores the current node in the linked list
        ListNode previous = null;           // previous node that is processed
        ListNode nextNode = null ;          // a temporary node that will store the next node

        while (current != null) {
            nextNode = current.next;        // temporarily stores the next node
            current.next = previous;         // reverse the current node
            previous = current;             // point previous to the current node
            current = nextNode;             // move to the next node
        }

       return previous;                     // returns the previous node which has the reversed list
    }


