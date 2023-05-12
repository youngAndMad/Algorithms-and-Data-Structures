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
        print(current);
        System.out.println(counter);
    }

    static int counter;

    static void print(Node current){
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    static Node reverse(Node head) {
        ++counter;

        if (head == null || head.next == null) {
            return head;
        }

        Node reversedList = reverse(head.next);
        print(reversedList);
        head.next.next = head;
        head.next = null;

        return reversedList;

    }
}
