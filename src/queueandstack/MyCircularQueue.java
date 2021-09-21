package queueandstack;

import java.util.Arrays;

public class MyCircularQueue {
    private final int[] queue;
    private final int size;
    private int head;
    private int tail;

    public MyCircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        Arrays.fill(queue, -1);
        head = -1;
        tail = -1;
    }

    public boolean enqueue(int value) {
        if (isFull())
            return false;

        if (isEmpty()) head++;

        tail = ++tail % size;
        queue[tail] = value;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty())
            return false;

        queue[head] = -1;
        head = ++head % size;

        if ((tail + 1) % size == head) {
            head = -1;
            tail = -1;
        }

        return true;
    }

    public int front() {
        return queue[head];
    }

    public int rear() {
        return queue[tail];
    }

    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public void print() {
        System.out.println(Arrays.toString(queue) + "\nhead: " + head + "\ntail: " + tail);
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(5);

        if (queue.enqueue(10)) System.out.println("enqueue(): 10");
        if (queue.enqueue(23)) System.out.println("enqueue(): 23");
        if (queue.enqueue(42)) System.out.println("enqueue(): 42");
        if (queue.enqueue(56)) System.out.println("enqueue(): 56");
        if (queue.enqueue(33)) System.out.println("enqueue(): 33");

        System.out.println();

        if (queue.dequeue()) System.out.println("dequeue()");
        if (queue.dequeue()) System.out.println("dequeue()");
        if (queue.dequeue()) System.out.println("dequeue()");

        System.out.println();

        if (queue.enqueue(21)) System.out.println("enqueue(): 21");
        if (queue.enqueue(67)) System.out.println("enqueue(): 67");
        if (queue.enqueue(99)) System.out.println("enqueue(): 99");

        System.out.println();

        if (queue.dequeue()) System.out.println("dequeue()");
        if (queue.dequeue()) System.out.println("dequeue()");
        if (queue.dequeue()) System.out.println("dequeue()");
        if (queue.dequeue()) System.out.println("dequeue()");
        if (queue.dequeue()) System.out.println("dequeue()");

        System.out.println();

        if (queue.enqueue(21)) System.out.println("enqueue(): 21");

        System.out.println();

        queue.print();
        System.out.println("Empty: " + queue.isEmpty());
        System.out.println("Full:  " + queue.isFull());
    }
}
