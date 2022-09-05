// insert at last 
// reverse list
// print list
// insert at first
// insert at position
//  delete at first
// delete at last
//delete at position

//update list
// count list size


class Node {
   constructor(val, next) {
      this.val = val;
      this.next = next;
   }
}

class circularLinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    mysize() {
        return this.size;
    }
    insertAtFirstNode(data) {
        this.head = new Node(data);
        this.head.next = this.head;
        this.size++;
    }
    insertAtLast(data) {

        if(!this.head) {
            this.insertAtFirstNode(data);
            return;
        }
        let currunt = this.head;

        while(currunt.next !== this.head) {
            currunt =  currunt.next;
        } 
        currunt.next = new Node(data);
        currunt.next.next = this.head;
        this.size++;
    }

    insertAtFirst(data) {
    //getting the last node 
    let currunt = this.head;
    while(currunt && currunt.next !== this.head) {
        currunt = currunt.next;
    }
    this.head = new Node(data, this.head);
    if(currunt) {
        currunt.next = this.head;
    } else {
        this.head.next = this.head;
    }
    this.size++;
    }

    insertAtPosition1Based(data, pos) {
        if(pos > this.size || pos < 1) return 'enter valid position';
        if(pos == 1) return this.insertAtFirst(data);
        if(pos == this.size + 1) return this.insertAtLast(data);
        let count = 1;
        let currunt = this.head;
        while(currunt.next !== this.head && count < (pos - 1)) {
            currunt = currunt.next;
            count++;
        }
        currunt.next = new Node(data, currunt.next);
        this.size++;
    }
        
    deleteAtFirst() {
       // get the tail node;
       if(this.size == 1) return this.head = null;
       let currunt = this.head;
       while(currunt && currunt.next !== this.head) {
           currunt = currunt.next;
       }
       this.head = this.head.next;
       currunt.next = this.head;       
       this.size--;
    }
    deleteAtLast() {
       if(this.size == 1) return this.head = null;
       let currunt = this.head;
       let count = 1;
       while(count < this.size - 1) {
           currunt = currunt.next;
           count++;
       }
       currunt.next = this.head;
       this.size--;
    }

    deleteAtPosition(pos) {
        if(pos == 1) return this.deleteAtFirst();
        if(pos == this.size) return this.deleteAtLast();
        
        let currunt = this.head;
        let count = 1;
        while(count < pos - 1) {
            currunt = currunt.next;
            count++;
        }
            // 2->3 2->1->3->4 6
        currunt.next = currunt.next.next;
        this.size--;
    }

    printList() {
        if(!this.head) return 'nothing in the list';
        let output = '';
        let currunt = this.head;
        // this is for the first node only.
        output += currunt.val + "->";
        currunt = currunt.next;

        while(currunt !== this.head) {
            output += currunt.val + '->';
            currunt = currunt.next;
        }

        return output;
    }
    // reverse list
    reverseCList() {
        let currunt = this.head;
        let pre = null;
        while(currunt.next !== this.head) {
            const temp = currunt.next;
            currunt.next = pre;
            pre = currunt;
            currunt = temp;
        }
        // main code for circular 
        let temp = currunt.next;
        currunt.next = pre;
        temp.next = currunt;
        // changing the ref of head node
        this.head  = currunt;
    }
}

const cll = new circularLinkedList();

cll.insertAtFirst(6);
cll.insertAtFirst(3);
cll.insertAtFirst(1);
cll.insertAtFirst(29);
cll.insertAtFirst(9);
cll.insertAtFirst(3);
console.log(cll.printList());
// cll.deleteAtPosition(1);
// cll.insertAtLast(2);
// cll.insertAtLast(3);
// cll.insertAtLast(4);
// cll.insertAtLast(5);
// cll.insertAtFirst(6);
// cll.reverseCList();
console.log(cll.printList());
