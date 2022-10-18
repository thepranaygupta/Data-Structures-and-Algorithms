class MyCircularQueue {
public:
    MyCircularQueue(int k){ arraysize=k; cq.resize(k); }
    bool enQueue(int value) {
        if (isFull()) return false;
        if(isEmpty()){ head=tail=0; cq[tail] = value;  size++; return true; }
        tail++;
         tail %= arraysize;
        cq[tail] = value;
        size++;
        return true;
    }
    bool deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % arraysize;
        size--;
        return true;
    }
    int Front() {
        return isEmpty() ? -1 : cq[head];
    }
    int Rear() {
        return isEmpty() ? -1 : cq[tail];
    }
    bool isEmpty() {
        return size == 0;
    }
    bool isFull() {
        return size == arraysize;
    }
private:
    int head=0, tail=0, size=0, arraysize=0;
    vector<int> cq;
};