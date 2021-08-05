import java.util.*;

public class Dequeue_CircularArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Queue.");
        int size = sc.nextInt();
        CircularDQueue d = new CircularDQueue(size);

        boolean flag = true;
        int val = 0;
        while (flag) {

            System.out.println("1. addFirst()");
            System.out.println("2. addLast()");
            System.out.println("3. Current size of Dequeue");
            System.out.println("4. removeFirst()");
            System.out.println("5. removeLast()");
            System.out.println("6. getFirst()");
            System.out.println("7. getLast()");
            System.out.println("8. viewDQ()");
            System.out.println("9. exit");

            System.out.println("Enter Choice");
            int choice = sc.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Enter value");
                    val = sc.nextInt();
                    d.addFirst(val);
                    break;


                case 2:
                    System.out.println("Enter value");
                    val = sc.nextInt();
                    d.addLast(val);
                    break;


                case 3:
                    System.out.println(d.count());
                    break;

                case 4:
                    System.out.println(d.removeFirst());
                    break;

                case 5:
                    System.out.println(d.removeLast());
                    break;

                case 6:
                    System.out.println(d.getFirst());
                    break;

                case 7:
                    System.out.println(d.getLast());
                    break;

                case 8:
                    d.viewDQ();
                    break;

                case 9:
                    flag = false;
                    break;

                default:
                    System.out.println("invalid choice");
            } //switch
            System.out.println();
        } //while

    }

}

class CircularDQueue {
    private int front;
    private int rear;
    private int n;
    private int cnt;
    private int arr[];

    public CircularDQueue(int size) {
        this.n = size;
        arr = new int[n];
        front = -1;
        rear = -1;
        cnt = 0;
    }

    public boolean isEmpty() {
        return (rear == -1 && front == -1);
    }
    public boolean isFull() {
        return ((rear + 1) % n == front);
    }
    public int count() {
        return cnt;
    }

    public int getFirst() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -999;
        }
        return arr[front];
    }
    public int getLast() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -999;
        }
        return arr[rear];
    }

    public void addFirst(int val) {
        if (isFull()) {
            System.out.println("Queue  is full");
            return;
        } else if (isEmpty()) {
            front = rear = 0;
        } else if (front == 0) {
            front = n - 1;
        } else {
            front--;
            System.out.println(front);
        }
        arr[front] = val;
        cnt++;
    }
    public void addLast(int val) {
        if (isFull()) {
            System.out.println("Queue  is full");
            return;
        } else if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % n;
        }
        arr[rear] = val;
        cnt++;
    }
    public int removeFirst() {
        int x = 0;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -999;
        } else if (rear == front) {
            x = arr[front];
            front = rear = -1;
            cnt--;
            return x;
        } else {
            x = arr[front];
            front = (front + 1) % n;
            cnt--;
            return x;
        }
    }

    public int removeLast() {
        int x = 0;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -999;
        } else if (rear == front) {
            x = arr[front];
            front = rear = -1;
            cnt--;
            return x;
        } else if (rear == 0) {
            x = arr[rear];
            rear = n - 1;
            cnt--;
            return x;
        } else {
            x = arr[rear];
            rear--;
            cnt--;
            return x;
        }

    }
    public void viewDQ() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        while (i != rear) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % n;
        }
        System.out.print(arr[i] + " ");
    }

}
