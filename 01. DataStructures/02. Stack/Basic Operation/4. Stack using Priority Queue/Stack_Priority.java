import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Stack_Priority {

    PriorityQueue<StackElement> queue = new PriorityQueue<>(10, new Comparator<StackElement>() {
        @Override
        public int compare(StackElement d1, StackElement d2) {
            return d2.key - d1.key;
        }
    });

    int order = 1;

    public void push(int val){
        StackElement element = new StackElement(order++,val);
        queue.add(element);
    }

    public Integer pop(){
        if(queue.isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }
        return queue.poll().data;
    }

    public static void main(String args[]){
        Stack_Priority data = new Stack_Priority();
        System.out.println("Data entering in the stack\n");
        System.out.println("Pushing data 10 ");
        data.push(10);
        System.out.println("Pushing data 20 ");
        data.push(20);
        System.out.println("Pushing data 30 ");
        data.push(30);
        System.out.println("Pushing data 40 ");
        data.push(40);
        System.out.println("Pushing data 50 ");
        data.push(50);
        System.out.println("Pushing data 60 ");
        data.push(60);
        System.out.println("Pushing data 70 ");
        data.push(70);
        System.out.println("Pushing data 80 ");
        data.push(80);
        System.out.println("Pushing data 90 ");
        data.push(90);
        System.out.println("Pushing data 100 ");
        data.push(100);
        System.out.println("Pushing data 200 ");
        data.push(200);
        System.out.println("\nPoping the data out from stack\n");
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
        System.out.println("Data pop " + data.pop());
       }

}

class StackElement {
  int key;
  int data;

  public StackElement(int key, int data) {
    this.key = key;
    this.data = data;
  }

}
