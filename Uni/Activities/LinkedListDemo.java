import java.util.Scanner; // Import Scanner for user input

// Node class to represent each element in the circular linked list
class Node {
    int data;        // Data stored in the node
    Node next;       // Pointer to the next node in the list

    // Constructor: initializes the node with data
    Node(int data) { 
        this.data = data; 
    }
}

// Class for Circular Singly Linked List
class CircularSinglyLinkedList {
    private Node tail; // Tail pointer, keeps track of the last node

    // Check if the list is empty
    public boolean isEmpty() {
        return tail == null;
    }

    // Insert node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data); // Create new node
        if (isEmpty()) {
            tail = newNode;         // Tail becomes the new node
            tail.next = tail;       // Node points to itself (circular link)
        } else {
            newNode.next = tail.next; // New node points to head
            tail.next = newNode;      // Tail points to new node (new head)
        }
    }

    // Insert node at the end of the list
    public void insertAtEnd(int data) {
        insertAtBeginning(data); // Reuse insertAtBeginning logic
        tail = tail.next;        // Move tail pointer to the new node
    }

    // Insert node at a specific position (0-based index)
    public void insertAtPosition(int data, int index) {
        if (index < 0) { // Negative index check
            System.out.println("Invalid index");
            return;
        }
        if (isEmpty() && index > 0) { // Empty list but index not 0
            System.out.println("Index out of range");
            return;
        }
        if (index == 0) { // Insert at beginning
            insertAtBeginning(data);
            return;
        }

        Node current = tail.next; // Start from head
        for (int i = 0; i < index - 1; i++) { // Traverse to node before target index
            if (current == tail) { // Reached end but index still too large
                System.out.println("Index out of range");
                return;
            }
            current = current.next;
        }

        // Insert new node
        Node newNode = new Node(data);
        newNode.next = current.next; 
        current.next = newNode;

        // If inserted at end, update tail
        if (current == tail) tail = newNode;
    }

    // Delete node at the beginning
    public void deleteAtBeginning() {
        if (isEmpty()) { // No nodes
            System.out.println("List empty");
            return;
        }
        if (tail.next == tail) { // Only one node
            tail = null;
        } else {
            tail.next = tail.next.next; // Remove head by skipping it
        }
    }

    // Delete node at the end
    public void deleteAtEnd() {
        if (isEmpty()) { // Empty list
            System.out.println("List empty");
            return;
        }
        if (tail.next == tail) { // Only one node
            tail = null;
            return;
        }

        // Traverse to node before tail
        Node current = tail.next; // Start from head
        while (current.next != tail) {
            current = current.next;
        }

        // Update links to remove tail
        current.next = tail.next; 
        tail = current; // New tail
    }

    // Delete node at a specific position (0-based index)
    public void deleteAtPosition(int index) {
        if (isEmpty() || index < 0) { // Invalid operation
            System.out.println("Invalid operation");
            return;
        }
        if (index == 0) { // Delete first node
            deleteAtBeginning();
            return;
        }

        Node current = tail.next; // Start from head
        for (int i = 0; i < index - 1; i++) { // Traverse to node before target
            if (current == tail) { // Reached tail early
                System.out.println("Index out of range");
                return;
            }
            current = current.next;
        }

        if (current.next == tail) { // Deleting tail node
            deleteAtEnd();
        } else if (current.next == tail.next) { // Invalid (past end)
            System.out.println("Index out of range");
        } else { // Bypass node to delete
            current.next = current.next.next;
        }
    }

    // Display the list elements
    public void display() {
        if (isEmpty()) { // Empty list
            System.out.println("List empty");
            return;
        }

        Node current = tail.next; // Start from head
        System.out.print("List: ");
        do {
            System.out.print(current.data + " "); // Print data
            current = current.next;               // Move to next node
        } while (current != tail.next); // Loop until back at head
        System.out.println();
    }
}

// Main driver class with menu
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for input
        CircularSinglyLinkedList list = new CircularSinglyLinkedList(); // Create list

        while (true) {
            // Main menu
            System.out.println("\n1.Insert 2.Delete 3.Display 4.Exit");
            int choice = sc.nextInt(); // User choice
            if (choice == 4) break;    // Exit condition

            switch (choice) {
                case 1: // Insert operations
                    System.out.println("Insert at: 1.Beginning 2.Position 3.End");
                    int pos = sc.nextInt(); // Choose insertion type
                    System.out.print("Enter data: ");
                    int data = sc.nextInt(); // Value to insert
                    if (pos == 1) list.insertAtBeginning(data);
                    else if (pos == 2) {
                        System.out.print("Enter index: ");
                        int idx = sc.nextInt();
                        list.insertAtPosition(data, idx);
                    } else if (pos == 3) list.insertAtEnd(data);
                    else System.out.println("Invalid position");
                    break;

                case 2: // Delete operations
                    System.out.println("Delete at: 1.Beginning 2.Position 3.End");
                    int delPos = sc.nextInt(); // Choose deletion type
                    if (delPos == 1) list.deleteAtBeginning();
                    else if (delPos == 2) {
                        System.out.print("Enter index: ");
                        int idx = sc.nextInt();
                        list.deleteAtPosition(idx);
                    } else if (delPos == 3) list.deleteAtEnd();
                    else System.out.println("Invalid position");
                    break;

                case 3: // Display list
                    list.display();
                    break;

                default: // Invalid menu choice
                    System.out.println("Invalid choice");
            }
        }
        sc.close(); // Close Scanner
    }
}
