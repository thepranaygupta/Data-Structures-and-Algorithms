var middleNode = function(head) {
    
    if (!head) return null;
    
    let fasterNode = head;
    while(fasterNode && fasterNode.next) {
        head = head.next;
        fasterNode = fasterNode.next.next
    }
    
    return head;
};
