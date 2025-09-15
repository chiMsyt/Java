package VIDEO_PRESENTATION;

/**
 * SinglyLinkedList.java
 * Implements a singly linked list with insertions and deletions at beginning, index, and end,
 * plus a search method.
 */
public class SinglyLinkedList {

    /**
     * Node class represents each element in the singly linked list.
     */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
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
        head = head.next;
        if (head == null) {
            tail = null;
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
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        if (index == size - 1) {
            tail = current;
        }
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
            size--;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;
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
     * Displays the list elements.
     */
    public void displayList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Singly Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
