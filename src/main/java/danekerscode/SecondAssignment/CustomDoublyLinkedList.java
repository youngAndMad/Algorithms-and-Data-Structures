package danekerscode.SecondAssignment;

import java.util.Collection;
import java.util.NoSuchElementException;

public class CustomDoublyLinkedList<T> {

    public int size = 0;
    Node head = null;
    Node tail = null;

    public void addFirst(T val) {
        Node nodeToInsert = new Node(val, head, null);
        if (head != null) {
            head.prev = nodeToInsert;
        }
        head = nodeToInsert;
        if (tail == null) {
            tail = nodeToInsert;
        }
        size++;
        System.out.println("element added:" + val.toString());
    }

    public void addLast(T val) {
        Node temp = new Node(val, null, tail);
        if (tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if (head == null) {
            head = temp;
        }
        size++;
        System.out.println("element added:" + val);
    }

    public void add(T val) {
        addLast(val);
    }

    public void add(Collection<T> collection) {
        collection.forEach(this::add);
    }

    public void pollFirst() {
        if (size == 0) {
            throw new NoSuchElementException("oops, your list is empty");
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("element deleted:" + temp.value.toString());
    }

    public void pollLast() {
        if (size == 0) {
            throw new NoSuchElementException("oops, your list is empty");
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("element deleted:" + temp.value);
    }

    public void println() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value.toString() + ", ");
            temp = temp.next;
        }
    }

    public void get(int index) {
        if (index >= size) {
            throw new NoSuchElementException("index more than current size: " + size);
        }
        Node node = head;
        int curr = 0;
        while (curr < index) {
            node = node.next;
            curr++;
        }
        System.out.println(node.value.toString());
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

}
