package VIDEO_PRESENTATION;

/**
 * DoublyLinkedList.java
 * Implements a doubly linked list with insertions and deletions at beginning, index, and end,
 * plus a search method.
 */
public class DoublyLinkedList {

    /**
     * Node class represents each element in the doubly linked list.
     */
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * @param data value to insert
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
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
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    /**
     * Inserts a new node at the end of the list.
     * @param data value to insert
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    /**
     * Deletes the node at the specified index.
     * @param index position to delete (0-based)
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Valid range: 0 to " + (size - 1));
            return;
        }
        if (index == 0) {
            deleteAtBeginning();
            return;
        }
        if (index == size - 1) {
            deleteAtEnd();
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
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
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    /**
     * Deletes the first node with the specified key.
     * @param key value to delete
     */
    public void deleteNode(int key) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value " + key + " not found in the list.");
            return;
        }
        if (current == head) {
            deleteAtBeginning();
        } else if (current == tail) {
            deleteAtEnd();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    /**
     * Searches for the first occurrence of the key in the list.
     * @param key value to search for
     * @return index of the key if found, else -1
     */
    public int search(int key) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == key) {
                return index;
            }
            current = current.next;
            index++;
        }
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
        System.out.print("Doubly Linked List (forward): ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Displays the list elements backward.
     */
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Doubly Linked List (backward): ");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}
