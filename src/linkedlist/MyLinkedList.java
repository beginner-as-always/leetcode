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

    public void set(int index, int val) {
        if (index < 0 || index >= size)
            return;

        Node tmp = head;

        for (int i = 0; i < index; i++)
            tmp = tmp.next;

        tmp.data = val;
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
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

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

    public void deleteAtHead() {
        if (head == null)
            return;

        head = head.next;

        if (head != null && head.prev != null)
            head.prev = null;

        size--;
    }

    public void deleteAtTail() {
        if (head == null)
            return;

        Node tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.prev.next = null;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        if (index == 0) {
            deleteAtHead();
            return;
        }

        if (index == size - 1) {
            deleteAtTail();
            return;
        }

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

        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3, 0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        System.out.println(list.get(4));
        list.addAtHead(4);
        list.addAtIndex(5, 0);
        list.addAtHead(6);
    }
}
