const reverseList = (head) => {
    
    if(head == null) return null;
    
    let pre = null;
    while(head !== null) {
        const temp = head.next;
        head.next = pre;
        pre = head;
        head = temp;
    }
    
    return pre;
}
