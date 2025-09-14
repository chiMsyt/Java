package Prelim;
// Import Scanner class to take user input
import java.util.Scanner;

import CircularSinglyLinkedList;
import DoublyLinkedList;
import SinglyLinkedList;
import SinglyLinkedList.Node;

// -------------------------------------------------
// SINGLY LINKED LIST
// -------------------------------------------------
class SinglyLinkedList {

    // Node class (represents one box in the list)
    class Node {
        int data;     // value inside the node
        Node next;    // pointer to the next node

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null; // start of the list

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);   // create a new node
        newNode.next = head;             // new node points to old head
        head = newNode;                  // move head to new node
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);   // create new node
        if (head == null) {              // if list is empty
            head = newNode;              // new node becomes head
            return;
        }
        Node current = head;             // start at head
        while (current.next != null) {   // go until last node
            current = current.next;
        }
        current.next = newNode;          // last node points to new node
    }

    // Insert at a position
    public void insertAtPosition(int data, int index) {
        if (index < 0) {                         // invalid index
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {                        // index 0 means beginning
            insertAtBeginning(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;              // move step by step
        }
        if (current == null) {                   // index too large
            System.out.println("Index out of range");
            return;
        }
        Node newNode = new Node(data);           // create new node
        newNode.next = current.next;             // new node points to next
        current.next = newNode;                  // previous points to new node
    }

    // Delete at beginning
    public void deleteAtBeginning() {
        if (head == null) {                      // if empty
            System.out.println("List empty");
            return;
        }
        head = head.next;                        // move head forward
    }

    // Delete at end
    public void deleteAtEnd() {
        if (head == null) {                      // empty list
            System.out.println("List empty");
            return;
        }
        if (head.next == null) {                 // only one node
            head = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {      // go to second-last
            current = current.next;
        }
        current.next = null;                     // remove last node
    }

    // Delete at position
    public void deleteAtPosition(int index) {
        if (head == null || index < 0) {
            System.out.println("Invalid operation");
            return;
        }
        if (index == 0) {                        // delete first
            deleteAtBeginning();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Index out of range");
            return;
        }
        current.next = current.next.next;        // skip over node
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List empty");
            return;
        }
        Node current = head;
        System.out.print("List: ");
        while (current != null) {                // print all nodes
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// -------------------------------------------------
// DOUBLY LINKED LIST
// -------------------------------------------------
class DoublyLinkedList {

    class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    Node head = null;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;    // link forward
            head.prev = newNode;    // link back
        }
        head = newNode;             // update head
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {         // empty list
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void insertAtPosition(int data, int index) {
        if (index < 0) { System.out.println("Invalid index"); return; }
        if (index == 0) { insertAtBeginning(data); return; }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) { System.out.println("Index out of range"); return; }

        Node newNode = new Node(data);
        newNode.next = current.next;
        if (current.next != null) current.next.prev = newNode;
        current.next = newNode;
        newNode.prev = current;
    }

    public void deleteAtBeginning() {
        if (head == null) { System.out.println("List empty"); return; }
        head = head.next;
        if (head != null) head.prev = null;
    }

    public void deleteAtEnd() {
        if (head == null) { System.out.println("List empty"); return; }
        if (head.next == null) { head = null; return; }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
    }

    public void deleteAtPosition(int index) {
        if (head == null || index < 0) { System.out.println("Invalid operation"); return; }
        if (index == 0) { deleteAtBeginning(); return; }

        Node current = head;
        for (int i = 0; i < index && current != null; i++) {
            current = current.next;
        }
        if (current == null) { System.out.println("Index out of range"); return; }

        if (current.next != null) current.next.prev = current.prev;
        if (current.prev != null) current.prev.next = current.next;
    }

    public void display() {
        if (head == null) { System.out.println("List empty"); return; }
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// -------------------------------------------------
// CIRCULAR SINGLY LINKED LIST
// -------------------------------------------------
class CircularSinglyLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    Node tail = null;  // track last node

    public boolean isEmpty() { return tail == null; }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    public void insertAtEnd(int data) {
        insertAtBeginning(data);
        tail = tail.next;
    }

    public void insertAtPosition(int data, int index) {
        if (index < 0) { System.out.println("Invalid index"); return; }
        if (isEmpty() && index > 0) { System.out.println("Index out of range"); return; }
        if (index == 0) { insertAtBeginning(data); return; }

        Node current = tail.next;
        for (int i = 0; i < index - 1; i++) {
            if (current == tail) { System.out.println("Index out of range"); return; }
            current = current.next;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        if (current == tail) tail = newNode;
    }

    public void deleteAtBeginning() {
        if (isEmpty()) { System.out.println("List empty"); return; }
        if (tail.next == tail) { tail = null; } else { tail.next = tail.next.next; }
    }

    public void deleteAtEnd() {
        if (isEmpty()) { System.out.println("List empty"); return; }
        if (tail.next == tail) { tail = null; return; }
        Node current = tail.next;
        while (current.next != tail) { current = current.next; }
        current.next = tail.next;
        tail = current;
    }

    public void deleteAtPosition(int index) {
        if (isEmpty() || index < 0) { System.out.println("Invalid operation"); return; }
        if (index == 0) { deleteAtBeginning(); return; }

        Node current = tail.next;
        for (int i = 0; i < index - 1; i++) {
            if (current == tail) { System.out.println("Index out of range"); return; }
            current = current.next;
        }
        if (current.next == tail) { deleteAtEnd(); }
        else { current.next = current.next.next; }
    }

    public void display() {
        if (isEmpty()) { System.out.println("List empty"); return; }
        Node current = tail.next;
        System.out.print("List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
}

// -------------------------------------------------
// CIRCULAR DOUBLY LINKED LIST
// -------------------------------------------------
class CircularDoublyLinkedList {
    class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    Node head = null;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        if (head == null) { insertAtBeginning(data); return; }
        Node newNode = new Node(data);
        Node tail = head.prev;
        newNode.next = head;
        newNode.prev = tail;
        tail.next = newNode;
        head.prev = newNode;
    }

    public void insertAtPosition(int data, int index) {
        if (index < 0) { System.out.println("Invalid index"); return; }
        if (index == 0 || head == null) { insertAtBeginning(data); return; }

        Node current = head;
        for (int i = 0; i < index - 1 && current.next != head; i++) {
            current = current.next;
        }
        if (current.next == head && index > 0) { insertAtEnd(data); return; }

        Node newNode = new Node(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
    }

    public void deleteAtBeginning() {
        if (head == null) { System.out.println("List empty"); return; }
        if (head.next == head) { head = null; return; }
        Node tail = head.prev;
        head = head.next;
        head.prev = tail;
        tail.next = head;
    }

    public void deleteAtEnd() {
        if (head == null) { System.out.println("List empty"); return; }
        if (head.next == head) { head = null; return; }
        Node tail = head.prev;
        Node newTail = tail.prev;
        newTail.next = head;
        head.prev = newTail;
    }

    public void deleteAtPosition(int index) {
        if (head == null || index < 0) { System.out.println("Invalid operation"); return; }
        if (index == 0) { deleteAtBeginning(); return; }

        Node current = head;
        for (int i = 0; i < index && current.next != head; i++) {
            current = current.next;
        }
        if (current == head) { System.out.println("Index out of range"); return; }

        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public void display() {
        if (head == null) { System.out.println("List empty"); return; }
        Node current = head;
        System.out.print("List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

// -------------------------------------------------
// MAIN PROGRAM
// -------------------------------------------------
public class AllLinkedListsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create all 4 lists
        SinglyLinkedList sll = new SinglyLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        while (true) {
            // Choose list
            System.out.println("\nChoose Linked List:");
            System.out.println("1. Singly");
            System.out.println("2. Doubly");
            System.out.println("3. Circular Singly");
            System.out.println("4. Circular Doubly");
            System.out.println("5. Exit");
            int type = sc.nextInt();
            if (type == 5) break;

            Object list = null;
            switch (type) {
                case 1: list = sll; break;
                case 2: list = dll; break;
                case 3: list = csll; break;
                case 4: list = cdll; break;
                default: System.out.println("Invalid choice"); continue;
            }

            // Menu
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Insert at: 1.Beginning 2.Position 3.End");
                    int pos = sc.nextInt();
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    if (pos == 1) {
                        if (list instanceof SinglyLinkedList) sll.insertAtBeginning(data);
                        if (list instanceof DoublyLinkedList) dll.insertAtBeginning(data);
                        if (list instanceof CircularSinglyLinkedList) csll.insertAtBeginning(data);
                        if (list instanceof CircularDoublyLinkedList) cdll.insertAtBeginning(data);
                    } else if (pos == 2) {
                        System.out.print("Enter index: ");
                        int idx = sc.nextInt();
                        if (list instanceof SinglyLinkedList) sll.insertAtPosition(data, idx);
                        if (list instanceof DoublyLinkedList) dll.insertAtPosition(data, idx);
                        if (list instanceof CircularSinglyLinkedList) csll.insertAtPosition(data, idx);
                        if (list instanceof CircularDoublyLinkedList) cdll.insertAtPosition(data, idx);
                    } else if (pos == 3) {
                        if (list instanceof SinglyLinkedList) sll.insertAtEnd(data);
                        if (list instanceof DoublyLinkedList) dll.insertAtEnd(data);
                        if (list instanceof CircularSinglyLinkedList) csll.insertAtEnd(data);
                        if (list instanceof CircularDoublyLinkedList) cdll.insertAtEnd(data);
                    }
                    break;

                case 2:
                    System.out.println("Delete at: 1.Beginning 2.Position 3.End");
                    int delPos = sc.nextInt();
                    if (delPos == 1) {
                        if (list instanceof SinglyLinkedList) sll.deleteAtBeginning();
                        if (list instanceof DoublyLinkedList) dll.deleteAtBeginning();
                        if (list instanceof CircularSinglyLinkedList) csll.deleteAtBeginning();
                        if (list instanceof CircularDoublyLinkedList) cdll.deleteAtBeginning();
                    } else if (delPos == 2) {
                        System.out.print("Enter index: ");
                        int idx = sc.nextInt();
                        if (list instanceof SinglyLinkedList) sll.deleteAtPosition(idx);
                        if (list instanceof DoublyLinkedList) dll.deleteAtPosition(idx);
                        if (list instanceof CircularSinglyLinkedList) csll.deleteAtPosition(idx);
                        if (list instanceof CircularDoublyLinkedList) cdll.deleteAtPosition(idx);
                    } else if (delPos == 3) {
                        if (list instanceof SinglyLinkedList) sll.deleteAtEnd();
                        if (list instanceof DoublyLinkedList) dll.deleteAtEnd();
                        if (list instanceof CircularSinglyLinkedList) csll.deleteAtEnd();
                        if (list instanceof CircularDoublyLinkedList) cdll.deleteAtEnd();
                    }
                    break;

                case 3:
                    if (list instanceof SinglyLinkedList) sll.display();
                    if (list instanceof DoublyLinkedList) dll.display();
                    if (list instanceof CircularSinglyLinkedList) csll.display();
                    if (list instanceof CircularDoublyLinkedList) cdll.display();
                    break;
            }
        }

        sc.close();
    }
}
