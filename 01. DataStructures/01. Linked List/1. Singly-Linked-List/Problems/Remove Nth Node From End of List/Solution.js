
var removeNthFromEnd = function(head, n) {
    
    if(!head) return null;
    // if the node is the only node in the list
    if(!head.next && n == 1) {
        head = null;
        return head;
    }
    
    const linkLen = findLen(head);
    const diff = linkLen - n;
    const firstHeadRef = head;
    

    
    if(diff >= 0) {
        let count = 1;
        
        // if n is equal to the  lenght of the linklist.
        if(diff === 0) {
            head = head.next;
            return head;
        }
        while(count < diff) {
            head = head.next;
            count++;
        }
        if(head.next && head.next.next) {
            head.next = head.next.next;            
        } else{
            head.next = null;            
        }
    } else {
        return null;
    }
    
    return firstHeadRef;
};

var findLen = function(node) {
    let count = 0;
    while(node) {
        node = node.next;
        count++;
    }
    
    return count;
}
