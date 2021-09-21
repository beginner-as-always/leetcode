package linkedlist;

public class MyLinkedList {
    private static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        Node tmp = head;

        for (int i = 0; i < index; i++)
            tmp = tmp.next;

        return tmp.data;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val, null, null);
        }
        else {
            Node newHead = new Node(val, head, null);
            head.prev = newHead;
            head = newHead;
        }

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (size == 0 && index == 0)
            addAtHead(val);

        if (index < 0 || index >= size)
            return;

        Node tmp = head;

        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }

        Node newNext = new Node(val, tmp.next, tmp);
        newNext.prev = tmp.next;
        tmp.next = newNext;

        size++;

//        System.out.println("index = " + index + ", value = " + tmp.data);
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val, null, null);
        }
        else {
            Node tmp = head;

            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new Node(val, null, tmp);
        }

        size++;
    }

    public void print() {
        Node tmp = head;

        while (tmp != null) {
            System.out.printf("%-4d|", tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("-----");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d   ", i);
        }

        System.out.println();
        System.out.println();
    }

    public void printReverted() {
        Node tmp = head;

        while (tmp.next != null)
            tmp = tmp.next;

        while (tmp != null) {
            System.out.printf("%-4d|", tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("-----");
        }
        System.out.println();
        for (int i = size - 1; i >= 0; i--) {
            System.out.printf("%2d   ", i);
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        var list = new MyLinkedList();

//        list.addAtHead(10);
//        list.addAtHead(21);
//        list.addAtHead(56);

        list.addAtTail(12);
        list.addAtTail(43);
        list.addAtTail(32);

//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));

        list.addAtIndex(1, 5);

        list.print();
        System.out.println();

        list.printReverted();
    }
}
