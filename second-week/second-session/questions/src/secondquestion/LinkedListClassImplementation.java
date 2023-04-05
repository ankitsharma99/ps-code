package secondquestion;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListClassImplementation {

    public static void printLinkedList(Node head) {
        Node cur = head;
        while(cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Node head = insertNode(null, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);
        head = insertNode(head, 5);
        head = insertNode(head, 6);

        printLinkedList(head);

        System.out.println();

        head = deleteNode(head, 1);
        head = deleteNode(head, 4);
        head = deleteNode(head, 5);
        printLinkedList(head);
    }

    private static Node deleteNode(Node head, int val) {
        Node cur = head;
        // first node
        if(cur != null && cur.val == val) {
            head = cur.next;
            System.out.println(val + " is deleted successfully");
            return head;
        }

        Node prev = null;
        // node present somewhere else
        while(cur != null && cur.val != val) {
            prev = cur;
            cur = cur.next;
        }

        if(cur != null) {       // node not found

            prev.next = cur.next;
            System.out.println(val + " is deleted successfully");
        }
        else {
            System.out.println("Value not found");
        }
        return head;
    }

    private static Node insertNode(Node head, int val) {
        Node node = new Node(val);

        if(head == null) {
            head = node;
        }
        else {
            Node cur = head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        return head;
    }
}
