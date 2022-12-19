//create a linked list class that add data at first position, 
//at last position, at given position, get data from last, get data from first, and get data from the give position

class node {
    constructor(data, next = null) {
        this.data = data;
        this.next = next; 
    }
}


 class linkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }

    // insert the elment at the first positoin 
    insertFirst(data) {
        this.head = new node(data, this.head);
        this.size++;
    }
    insertLast(data) {
       let currunt = this.head;

        while(currunt.next) {
            currunt = currunt.next;
        }
        currunt.next = new node(data);
        this.size++;
    }
    // print all the element in linked list from the last element
    printDataFromTheEnd() {
        let linkedStr = 'null';
        let currunt = this.head
        while(currunt) {
            linkedStr +=  "->" + currunt.data; 
            currunt = currunt.next;
        }
        return linkedStr;
    }
    // print data from the first element
    printDataFromTheStart() {
        let currunt = this.head;
        let reversL =  this.reverseLink(currunt);
        let linkedStr = '';
        while(reversL) {
            linkedStr += reversL.data + "->" ; 
            reversL = reversL.next;
        }
        return linkedStr + 'null';
    }
    // insert data at specific position. it is zero based index.
    insertAt(data, index) {
        if(index < 0 || index > this.size) {
            return 'index must be between linked list size';
        }

        let currunt = this.head;
        index = this.size - index;
        console.log(index);
        while(index > 0) {
            currunt = currunt.next;
            index--;
        }
        currunt.next = new node(data, currunt.next);
        this.size++;
        return this.printDataFromTheStart();
    }
    getAt(index) {
        let currunt = this.head;
        if(index < 0 || index > this.size) {
            return 'index must be between linked list size';
        }
        let reverseL = this.reverseLink(currunt)
        while(index > 1) {
            reverseL = reverseL.next;
            index--;
        }
        return reverseL.data;
    }
    // remove at 
    removeAt(index) {
        if(index < 0 || index > this.size) {
            return 'index must be between linked list size';
        }
        
        let currunt = this.head;
        index = this.size - index;
        while(index > 1) {
            currunt = currunt.next;
            index--;
        }
        let temp = currunt.next;
        currunt.next = currunt.next.next;
        temp = null;
        this.size--;
    }
    // reverse the link list 
    reverseLink(head) {
        let temp = null;
        while(head) {
        let tempHead = head.next;
         head.next = temp;
         temp = head;
         head = tempHead;   
        }
        return temp;
    }

    // delete the list 
    deleteList() {
        while(this.head) {
            // 1->2->3->4->5->6
            let temp = this.head;
            this.head = this.head.next;
            temp = null;
        }
        return this.head;
    }
}

const ll = new linkedList();

ll.insertFirst(100);
ll.insertFirst(200);
ll.insertFirst(300);
ll.insertFirst(400);
ll.insertFirst(500);
ll.insertFirst(600);
ll.insertFirst(700);
// ll.removeAt(3);
console.log(ll.insertAt(555, 5));

// console.log(ll.printDataFromTheStart());
// console.log(ll.removeAt(2));
// console.log(ll.printDataFromTheEnd());

