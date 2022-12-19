
    /** Refer to the README to know how the algorithm works and to find the link for the question.
     * @param node the head of the linked list
     * @return the reversed linked list
     */
    public static ListNode reverseList(ListNode node) {
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


