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
        size++;

        if (head == null) {
            head = new Node(val, null, null);
            return;
        }

        Node newHead = new Node(val, head, null);
        head.prev = newHead;
        head = newHead;
    }

    public void addAtIndex(int index, int val) {
        if (size == 0 && index == 0) {
            addAtHead(val);
            return;
        }

        if (index < 0 || index >= size)
            return;

        Node tmp = head;

        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }

        Node newNext = new Node(val, tmp.next, tmp);
        tmp.next.prev = newNext;
        tmp.next = newNext;

        size++;
    }

    public void addAtTail(int val) {
        size++;

        if (head == null) {
            head = new Node(val, null, null);
            return;
        }

        Node tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = new Node(val, null, tmp);
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        Node tmp = head;

        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;

        size--;
    }

    public void print() {
        Node tmp = head;

        while (tmp != null) {
            System.out.printf("%-4d", tmp.data);
            tmp = tmp.next;
        }

        System.out.println();
    }

    public void printReverted() {
        Node tmp = head;

        while (tmp.next != null)
            tmp = tmp.next;

        while (tmp != null) {
            System.out.printf("%-4d", tmp.data);
            tmp = tmp.prev;
        }

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
        list.printReverted();

        list.deleteAtIndex(2);

        list.print();
        list.printReverted();
    }
}
