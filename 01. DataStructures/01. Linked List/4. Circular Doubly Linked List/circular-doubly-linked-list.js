// insert at first 
// print list
// insert at last
// reverse list
// find size


class Node {
    constructor(val, next, pre) {
        this.val = val;
        this.next = next;
        this.pre = pre;
    }
}

class circularDoublyLinkList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    incrementSize() {
        this.size++;
    }
    getSize() {
        return this.size;
    }
    insertInitialNode(data) {
        this.head = new Node(data, null, null);
        this.head.next = this.head;
        this.head.pre = this.head;
        this.tail = this.head;
        this.incrementSize();
    }
    
    isnertAtFirst(data) {
       if(this.size == 0) return this.insertInitialNode(data);
    
       let currunt = this.head;
        // get the tail node; 1->
       while(currunt && currunt.next !== this.head) {
           currunt = currunt.next;
       }
       this.tail = currunt;
       this.head = new Node(data, this.head, this.tail);
       currunt.next = this.head;
       this.incrementSize();    
    }

    insertAtLast(data) {
        // get the last node 
        this.tail.next = new Node(data, this.head, this.tail);
        this.tail =  this.tail.next;
        this.incrementSize();    
    }
    // 1->2->3->4
    reverseList() {
        let pre =  this.tail;
        let currunt = this.head;
        while(currunt.next !== this.head) {
            const temp = currunt.next;
            currunt.next = pre;
            pre.pre = currunt;
            pre = currunt;
            currunt = temp;
        } 
        // taking care of the last node;
        if(currunt.next == this.head) {
            currunt.next = pre;
            pre.pre = currunt;
        }
        const temp = this.head;
        this.head = this.tail;
        this.tail = temp;
    }

    printList() {
        let currunt = this.head;
        let output = '';
        while(currunt.next !== this.head) {
            output += currunt.val + '->';
            currunt = currunt.next;
        }
        if(currunt.next == this.head) {
            output += currunt.val + '->';
        }
        return output;
    }
    // it's to check pre nodes. not neccesary(I know I misspelled the word)
    printFormEnd() {
        let currunt = this.tail;
        let output = '';
        while(currunt.pre !== this.tail) {
            output += currunt.val + '->';
            currunt = currunt.pre;
        }
        if(currunt.pre == this.tail) {
            output += currunt.val + '->';
        }
        return output;
    }
}


const dcll = new circularDoublyLinkList();

dcll.isnertAtFirst(1);
dcll.isnertAtFirst(2);
dcll.isnertAtFirst(3);
dcll.isnertAtFirst(3);
dcll.insertAtLast(4);
dcll.insertAtLast(5);
console.log(dcll.printList());
dcll.reverseList();
console.log(dcll.printList());
console.log(dcll.printFormEnd());



