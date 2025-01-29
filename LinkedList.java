import java.util.Scanner;

public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertMiddle(int data, int pos) {
        // Handle invalid position (less than 1 or greater than list size)
        if (pos < 1) {
            System.out.println("Invalid position. Cannot insert before head.");
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int counter = 1;

        // Traverse to the node before the insertion position
        while (current != null && counter < pos) {
            current = current.next;
            counter++;
        }

        // Handle position beyond list size (insert at the end)
        if (current == null) {
            addNode(data);
            return;
        }

        // Insert at the beginning (position 1)
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            // Insert in the middle
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);

        int data, data1;
        System.out.println("ENTER INTEGERS TO CREATE NODES (ENTER A NON-INTEGER TO EXIT):");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                data = sc.nextInt();
                list.addNode(data);
            } else {
                String temp = sc.next();
                System.out.println("LINKED LIST CREATED");
                System.out.println("LINKED LIST BEFORE INSERTING");
                list.displayList();

                System.out.println("ENTER THE POSITION WHERE YOU WANT TO INSERT:");
                if (sc.hasNextInt()) {
                    int pos = sc.nextInt();
                    System.out.println("ENTER THE ELEMENT TO BE INSERTED:");
                    if (sc.hasNextInt()) {
                        data1 = sc.nextInt();
                        list.insertMiddle(data1, pos);
                        System.out.println("LINKED LIST AFTER INSERTING");
                        list.displayList();
                    } else {
                        System.out.println("Enter integers only");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Enter integers only");
                    System.exit(0);
                }
            }
        }
    }
}