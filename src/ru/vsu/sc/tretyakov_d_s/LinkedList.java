package ru.vsu.sc.tretyakov_d_s;

public class LinkedList<T> {

    public static class LinkedListException extends Exception {
        public LinkedListException(String message) {
            super(message);
        }
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T value, Node next) {
            this.data = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws LinkedListException {
        if (size == 0) {
            throw new LinkedListException("Empty list");
        }
    }

    private Node getNode(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public int size() {
        return size;
    }

    public T get(int index) throws LinkedListException {
        checkEmptyError();
        return getNode(index).data;
    }

    public void set(T data, int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.data = data;
    }

}
