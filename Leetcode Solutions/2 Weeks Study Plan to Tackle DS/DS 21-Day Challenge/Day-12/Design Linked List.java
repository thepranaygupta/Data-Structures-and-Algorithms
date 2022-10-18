class MyLinkedList {
    class Node{
        Node next = null;
        int val = 0;
        public Node(int val){
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public int get(int index) {
        if(index < 0 || index >= this.size) return -1;
        Node curr = this.head;
        while(index-- > 0){
            curr = curr.next;
        }
        return curr.val;
    }
    public Node getNodeAt(int index){
        Node curr = head;
        while(index-- > 0){
            curr = curr.next;
        }
        return curr;
    }
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }
        else{
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(this.size == 0){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.next = node;
            node.next = null;
            this.tail = node;
        }
        this.size++;
    }
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > this.size) return;
        
        if(index == 0){
            addAtHead(val);
        }
        else if(index == this.size){
            addAtTail(val);   
        }
        else{
            Node prev = getNodeAt(index-1);
            Node forw = prev.next;
            Node curr = new Node(val);
            prev.next = curr;
            curr.next = forw;
            this.size++;
        }
    }
    public void deleteFirst(){
        if(this.size == 0) return;
        else if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        else{
            Node curr = this.head;
            Node forw = curr.next;
            curr.next = null;
            this.head = forw;
        }
        this.size--;
    }
    
    public void deleteLast(){
        if(this.size == 0) return;
        else if(this.size == 1){
            this.head = null;
            this.tail = null;
        }
        else{
            Node secondLast = getNodeAt(this.size-2);
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
    }
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.size) return;
        
        if(index == 0){
            deleteFirst();
        }
        else if(index == this.size-1){
            deleteLast();   
        }
        else{
            Node prev = getNodeAt(index-1);
            Node curr = prev.next;
            Node forw = prev.next.next;
            prev.next = forw;
            curr.next = null;
            this.size--;
        }
    }
}