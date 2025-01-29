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
    public void insertMiddle(int data,int pos) 
    {    
        //Create a new node    
        Node newNode = new Node(data);    
       //temporary node points to head node
        Node temp=head;
        if(pos==1)
        {
newNode.next=temp;
        head=newNode;
        }
        else
        {
        for(int i=1;i<(pos-1);i++ ) 
        {    
            temp = temp.next;    
        }    
newNode.next=temp.next;
temp.next=newNode;
        }
System.out.println("Element Inserted");
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