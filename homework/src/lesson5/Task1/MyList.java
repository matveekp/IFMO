package lesson5.Task1;

import java.util.Arrays;

public class MyList implements Stack, Queue, List  {

    private Node head;
    private int size;


    @Override
    public void add(Object value) {

        if (head == null) {
            this.head = new Node(value);
        }

        else {
            Node temp = head;
            while (temp.getNext()!= null) {
                temp = temp.getNext();
            }
            temp.setNext( new Node(value));
        }
        size++;

    }

    @Override
    public Object get(int index) {

        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            }
            else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void remove(int index) {

        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex + 1 == index) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            }
            else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }


    @Override
    public void enqueue(Object value) {

        if (head == null) {
            this.head = new Node(value);
        }
        else {
            Node temp = head;
            while (temp.getNext()!= null) {
                temp = temp.getNext();
            }
            temp.setNext( new Node(value));
        }
        size++;
    }

    @Override
    public Object dequeu() {

        Node temp = head;

        head = temp.getNext();
        size--;

        return temp.getValue();
    }

    @Override
    public void push(Object value) {

        if (head == null) {
            this.head = new Node(value);
        }
        else {
            Node temp = head;
            while (temp.getNext()!= null) {
                temp = temp.getNext();
            }
            temp.setNext( new Node(value));
        }
        size++;
    }

    @Override
    public Object pop() {

        Node temp = head;

        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(null);
        size--;

        return temp.getValue();
    }




    @Override
    public String toString() {

        Object[] result = new Object[size];

        int idx = 0;
        Node temp = head;

        while (temp != null) {
            result[idx] = temp.getValue();
            temp = temp.getNext();
            idx++;
        }

        return Arrays.toString(result);
    }

    private static class Node {

        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
