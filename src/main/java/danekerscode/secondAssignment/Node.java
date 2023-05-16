package danekerscode.secondAssignment;

public class Node<T> {
    T value;
    public Node next;
    public Node prev;
    public Node(T value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}