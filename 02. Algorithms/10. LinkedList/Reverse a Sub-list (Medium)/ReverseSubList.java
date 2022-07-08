    /*
     * Refer to the README to know how the algorithm works and to find the link for the question.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // noting to reverse
        if (left == right)
            return head;

        // after skipping the nodes previous to the left position, current will point to the  left position
        ListNode current = head, previous = null;
        for (int i = 0; current != null && 1 < left-1; ++i) {
            previous = current;
            current = current.next;
        }

        // there are three parts of the linkedlist we want, the part before the left index
        // between left and right, and after the right index
        ListNode lastNodeOfFirstPart = previous;   // points to the node at index "left-1"

        // after reversing the linkedlist current will become the last node od the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null;   // used to temporarily store the next node

        // now reverse nodes between left and right
        for (int i = 0; current != null && i < left-right+1; ++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect the first part
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;  // previous is now the fist node of the sub-list
        }  else { // this means left is 1, and we are changing the first node of the linked list
           head = previous;
        }

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;
    }


