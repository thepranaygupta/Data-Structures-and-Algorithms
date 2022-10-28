
class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
    }
}


public class Circular_LL {
    
        public static void print(Node<Integer> head){
    
            Node<Integer> temp = head;
    
            do{
                System.out.println(temp.data);
                temp = temp.next;
    
            }while (temp!=head);
    
        }
    

        public static void main(String[] args) {
            Node<Integer> n1 = new Node<>(10);
            Node<Integer> n2 = new Node<>(20);
            Node<Integer> n3 = new Node<>(30);
            Node<Integer> n4 = new Node<>(40);
    
            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n1;
    

            print(n1);
    
        }
    
    
}
