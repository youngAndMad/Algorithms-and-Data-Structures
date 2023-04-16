package danekerscode.SecondAssignment;

public class SingleLinkedList {

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

    }


    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node reversed = reverse(head);
        Node current = reversed;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }

    }

    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node reversedList = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }
}
