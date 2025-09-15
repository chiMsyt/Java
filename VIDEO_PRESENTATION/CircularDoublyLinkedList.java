package VIDEO_PRESENTATION;

/**
 * CircularDoublyLinkedList.java
 * Implements a circular doubly linked list with insertions and deletions at beginning, index, and end,
 * plus a search method.
 */
public class CircularDoublyLinkedList {

    /**
     * Node class represents each element in the circular doubly linked list.
     */
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }

    Node head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * @param data value to insert
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = newNode.prev = newNode;
        } else {
            Node tail = head.prev;
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Inserts a new node at the specified index.
     * @param data value to insert
     * @param index position to insert at (0-based)
     */
    public void insertAtIndex(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index. Valid range: 0 to " + size);
            return;
        }
        if (index == 0) {
            insertAtBeginning(data);
            return;
        }
        if (index == size) {
            insertAtEnd(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node prevNode = current.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = current;
        current.prev = newNode;
        size++;
    }

    /**
     * Inserts a new node at the end of the list.
     * @param data value to insert
     */
    public void insertAtEnd(int data) {
        if (head == null) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node tail = head.prev;

        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
        size++;
    }

    /**
     * Deletes the node at the beginning of the list.
     */
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.next == head) { // Only one node
            head = null;
            size--;
            return;
        }
        Node tail = head.prev;
        head = head.next;
        tail.next = head;
        head.prev = tail;
        size--;
    }

    /**
     * Deletes the node at the specified index.
     * @param index position to delete (0-based)
     */
    public void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Valid range: 0 to " + (size - 1));
            return;
        }
        if (index == 0) {
            deleteAtBeginning();
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node prevNode = current.prev;
        Node nextNode = current.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        // If deleting tail, no need to update head pointer
        size--;
    }

    /**
     * Deletes the node at the end of the list.
     */
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (head.next == head) { // Only one node
            head = null;
            size--;
            return;
        }
        Node tail = head.prev;
        Node newTail = tail.prev;

        newTail.next = head;
        head.prev = newTail;
        size--;
    }

    /**
     * Deletes the first node with the specified key.
     * @param key value to delete
     */
    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        Node current = head;
        boolean found = false;
        do {
            if (current.data == key) {
                found = true;
                break;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Value " + key + " not found in the list.");
            return;
        }

        if (current == head) {
            deleteAtBeginning();
        } else if (current == head.prev) {
            deleteAtEnd();
        } else {
            Node prevNode = current.prev;
            Node nextNode = current.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }

    /**
     * Searches for the first occurrence of the key in the list.
     * @param key value to search for
     * @return index of the key if found, else -1
     */
    public int search(int key) {
        if (head == null) {
            return -1;
        }
        Node current = head;
        int index = 0;
        do {
            if (current.data == key) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != head);
        return -1;
    }

    /**
     * Displays the list elements forward.
     */
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Circular Doubly Linked List (forward): ");
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    /**
     * Displays the list elements backward.
     */
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Circular Doubly Linked List (backward): ");
        Node tail = head.prev;
        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }
}
