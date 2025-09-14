import java.util.Scanner;

// Node class for Circular Singly Linked List
class CSNode {
    int data;       // Data stored in the node
    CSNode next;    // Pointer to the next node

    // Constructor to create a new node with given data
    public CSNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Circular Singly Linked List class
class CircularSinglyLinkedList {
    private CSNode tail;  // We keep a tail pointer for easier circular list management

    // Constructor initializes an empty list
    public CircularSinglyLinkedList() {
        tail = null;
    }

    // Insert node at the beginning of the list
    public void insertAtBeginning(int data) {
        CSNode newNode = new CSNode(data); // Create new node
        if (tail == null) {
            // List is empty, new node points to itself
            tail = newNode;
            tail.next = tail;
        } else {
            // New node points to head (tail.next)
            newNode.next = tail.next;
            // Tail points to new node, making it the new head
            tail.next = newNode;
        }
    }

    // Insert node at the end of the list
    public void insertAtEnd(int data) {
        CSNode newNode = new CSNode(data); // Create new node
        if (tail == null) {
            // Empty list, new node points to itself and becomes tail
            tail = newNode;
            tail.next = tail;
        } else {
            // New node points to head
            newNode.next = tail.next;
            // Old tail points to new node
            tail.next = newNode;
            // New node becomes the new tail
            tail = newNode;
        }
    }

    // Insert node at a given index (0-based)
    public void insertAtPosition(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid index. Must be >= 0.");
            return;
        }
        if (tail == null) {
            // If list is empty, only index 0 is valid
            if (index == 0) {
                insertAtBeginning(data);
            } else {
                System.out.println("Index out of range for empty list.");
            }
            return;
        }
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        // Traverse to the node before the insertion point
        CSNode current = tail.next; // head
        int count = 0;
        while (count < index - 1 && current != tail) {
            current = current.next;
            count++;
        }

        if (count != index - 1) {
            System.out.println("Index out of range.");
            return;
        }

        CSNode newNode = new CSNode(data);
        newNode.next = current.next;
        current.next = newNode;

        // If inserted at the end, update tail
        if (current == tail) {
            tail = newNode;
        }
    }

    // Delete node at the beginning
    public void deleteAtBeginning() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (tail.next == tail) {
            // Only one node in the list
            tail = null;
        } else {
            // Tail's next points to second node, effectively removing head
            tail.next = tail.next.next;
        }
    }

    // Delete node at the end
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (tail.next == tail) {
            // Only one node
            tail = null;
            return;
        }
        // Traverse to the node before tail
        CSNode current = tail.next; // head
        while (current.next != tail) {
            current = current.next;
        }
        // current is now node before tail
        current.next = tail.next; // point to head
        tail = current;           // update tail
    }

    // Delete node at a given index (0-based)
    public void deleteAtPosition(int index) {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (index < 0) {
            System.out.println("Invalid index. Must be >= 0.");
            return;
        }
        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        CSNode current = tail.next; // head
        int count = 0;
        // Traverse to node before the one to delete
        while (count < index - 1 && current != tail) {
            current = current.next;
            count++;
        }

        if (current == tail || current.next == tail.next) {
            System.out.println("Index out of range.");
            return;
        }

        // If deleting tail node, update tail pointer
        if (current.next == tail) {
            current.next = tail.next;
            tail = current;
        } else {
            // Bypass the node to delete
            current.next = current.next.next;
        }
    }

    // Display the list elements
    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        CSNode current = tail.next; // head
        System.out.print("List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}

// Node class for Circular Doubly Linked List
class CDNode {
    int data;       // Data stored in the node
    CDNode next;    // Pointer to the next node
    CDNode prev;    // Pointer to the previous node

    // Constructor to create a new node with given data
    public CDNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Circular Doubly Linked List class
class CircularDoublyLinkedList {
    private CDNode tail;  // Tail pointer for easier management

    // Constructor initializes empty list
    public CircularDoublyLinkedList() {
        tail = null;
    }

    // Insert node at the beginning
    public void insertAtBeginning(int data) {
        CDNode newNode = new CDNode(data);
        if (tail == null) {
            // Empty list: new node points to itself in both directions
            tail = newNode;
            tail.next = tail;
            tail.prev = tail;
        } else {
            CDNode head = tail.next;
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
        }
    }

    // Insert node at the end
    public void insertAtEnd(int data) {
        CDNode newNode = new CDNode(data);
        if (tail == null) {
            // Empty list: new node points to itself
            tail = newNode;
            tail.next = tail;
            tail.prev = tail;
        } else {
            CDNode head = tail.next;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode; // new node becomes tail
        }
    }

    // Insert node at a given index (0-based)
    public void insertAtPosition(int data, int index) {
        if (index < 0) {
            System.out.println("Invalid index. Must be >= 0.");
            return;
        }
        if (tail == null) {
            // Empty list: only index 0 is valid
            if (index == 0) {
                insertAtBeginning(data);
            } else {
                System.out.println("Index out of range for empty list.");
            }
            return;
        }
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }

        CDNode current = tail.next; // head
        int count = 0;
        // Traverse to node before insertion point
        while (count < index - 1 && current != tail) {
            current = current.next;
            count++;
        }

        if (count != index - 1) {
            System.out.println("Index out of range.");
            return;
        }

        CDNode newNode = new CDNode(data);
        CDNode nextNode = current.next;

        // Insert newNode between current and nextNode
        newNode.next = nextNode;
        newNode.prev = current;
        current.next = newNode;
        nextNode.prev = newNode;

        // If inserted at the end, update tail
        if (current == tail) {
            tail = newNode;
        }
    }

    // Delete node at the beginning
    public void deleteAtBeginning() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (tail.next == tail) {
            // Only one node
            tail = null;
        } else {
            CDNode head = tail.next;
            CDNode newHead = head.next;
            tail.next = newHead;
            newHead.prev = tail;
        }
    }

    // Delete node at the end
    public void deleteAtEnd() {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (tail.next == tail) {
            // Only one node
            tail = null;
        } else {
            CDNode prevNode = tail.prev;
            CDNode head = tail.next;
            prevNode.next = head;
            head.prev = prevNode;
            tail = prevNode;
        }
    }

    // Delete node at a given index (0-based)
    public void deleteAtPosition(int index) {
        if (tail == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (index < 0) {
            System.out.println("Invalid index. Must be >= 0.");
            return;
        }
        if (index == 0) {
            deleteAtBeginning();
            return;
        }

        CDNode current = tail.next; // head
        int count = 0;
        // Traverse to node at index
        while (count < index && current != tail) {
            current = current.next;
            count++;
        }

        if (count != index) {
            System.out.println("Index out of range.");
            return;
        }

        // If deleting tail node, update tail pointer
        if (current == tail) {
            deleteAtEnd();
            return;
        }

        // Remove current node by updating links
        CDNode prevNode = current.prev;
        CDNode nextNode = current.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Display the list elements
    public void display() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        CDNode current = tail.next; // head
        System.out.print("List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}

// Main class with menu-driven program
public class CircularLinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CircularSinglyLinkedList csList = new CircularSinglyLinkedList();
        CircularDoublyLinkedList cdList = new CircularDoublyLinkedList();

        while (true) {
            System.out.println("\nSelect Linked List Type:");
            System.out.println("1. Circular Singly Linked List");
            System.out.println("2. Circular Doubly Linked List");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            int listChoice = scanner.nextInt();

            if (listChoice == 3) {
                System.out.println("Exiting program.");
                break;
            }

            if (listChoice != 1 && listChoice != 2) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            while (true) {
                System.out.println("\nSelect Operation:");
                System.out.println("1. Insert");
                System.out.println("2. Delete");
                System.out.println("3. Display");
                System.out.println("4. Change List Type / Exit to main menu");
                System.out.print("Choice: ");
                int opChoice = scanner.nextInt();

                if (opChoice == 4) {
                    break; // Exit to list type selection
                }

                switch (opChoice) {
                    case 1: // Insert
                        System.out.println("Insert at:");
                        System.out.println("1. Beginning");
                        System.out.println("2. Intermediate Position");
                        System.out.println("3. End");
                        System.out.print("Choice: ");
                        int insertChoice = scanner.nextInt();

                        System.out.print("Enter data to insert: ");
                        int data = scanner.nextInt();

                        if (listChoice == 1) { // Circular Singly Linked List
                            switch (insertChoice) {
                                case 1:
                                    csList.insertAtBeginning(data);
                                    break;
                                case 2:
                                    System.out.print("Enter index (0-based): ");
                                    int index = scanner.nextInt();
                                    csList.insertAtPosition(data, index);
                                    break;
                                case 3:
                                    csList.insertAtEnd(data);
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                            csList.display();
                        } else { // Circular Doubly Linked List
                            switch (insertChoice) {
                                case 1:
                                    cdList.insertAtBeginning(data);
                                    break;
                                case 2:
                                    System.out.print("Enter index (0-based): ");
                                    int index = scanner.nextInt();
                                    cdList.insertAtPosition(data, index);
                                    break;
                                case 3:
                                    cdList.insertAtEnd(data);
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                            cdList.display();
                        }
                        break;

                    case 2: // Delete
                        System.out.println("Delete at:");
                        System.out.println("1. Beginning");
                        System.out.println("2. Intermediate Position");
                        System.out.println("3. End");
                        System.out.print("Choice: ");
                        int deleteChoice = scanner.nextInt();

                        if (listChoice == 1) { // Circular Singly Linked List
                            switch (deleteChoice) {
                                case 1:
                                    csList.deleteAtBeginning();
                                    break;
                                case 2:
                                    System.out.print("Enter index (0-based): ");
                                    int index = scanner.nextInt();
                                    csList.deleteAtPosition(index);
                                    break;
                                case 3:
                                    csList.deleteAtEnd();
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                            csList.display();
                        } else { // Circular Doubly Linked List
                            switch (deleteChoice) {
                                case 1:
                                    cdList.deleteAtBeginning();
                                    break;
                                case 2:
                                    System.out.print("Enter index (0-based): ");
                                    int index = scanner.nextInt();
                                    cdList.deleteAtPosition(index);
                                    break;
                                case 3:
                                    cdList.deleteAtEnd();
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                            }
                            cdList.display();
                        }
                        break;

                    case 3: // Display
                        if (listChoice == 1) {
                            csList.display();
                        } else {
                            cdList.display();
                        }
                        break;

                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }

        scanner.close();
    }
}
