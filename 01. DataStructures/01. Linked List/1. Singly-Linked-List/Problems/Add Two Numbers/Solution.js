var addTwoNumbers = function(l1, l2) {
    if(!l1 || !l2) return null;
    
    const l1Length = getLen(l1);
    const l2Length = getLen(l2);
    const firstNodeRef = l1;
    let carry = 0;

    // appending zeors 
    if(l1Length !== l2Length) {
        if(l2Length < l1Length) {
            l2 = appendZeros(l2, l1Length - l2Length);
        } else {
            l1 = appendZeros(l1, l2Length - l1Length);
        }
    }
    
    // ref to one node before the current node.
    let prev;
    while(l1) {
        const total = l1.val + l2.val + carry;
        l1.val = (total) % 10;
        if(total > 9) {
            carry = 1;
        } else {
            carry = 0;
        }
        prev = l1;
        l1 = l1.next;
        l2 = l2.next;
    }
    // cheking if there is a carry at the last digit node.
    if(carry == 1) {
        prev.next = new ListNode(1);
    }
    return firstNodeRef;
};

// get the length of linklist.
function getLen(node) {
    let count = 0;
    while(node) {
        count++;
        node = node.next;
    }
    return count;
}
// append zeros at the end of shorter linklist.
function appendZeros(node, diff) {
     const temp = node;
            while(node.next) {
                node = node.next;
            }
            let count = 0;
            while(count < diff) {
                node.next = new ListNode(0);
                node = node.next;
                count++;
            }
            node = temp;  
    
    return node;
}
