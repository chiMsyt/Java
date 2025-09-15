package VIDEO_PRESENTATION;

/**
 * CircularLinkedList.java
 * Implements a circular singly linked list with insertions and deletions at beginning, index, and end,
 * plus a search method.
 */
public class CircularLinkedList {

    /**
     * Node class represents each element in the circular singly linked list.
     */
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    private int size;

    public CircularLinkedList() {
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
            newNode.next = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
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
            newNode.next = newNode;
        } else {
            tail.next = newNode;
            newNode.next = head;
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
            tail.next = head;
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
        current.next = head;
        tail = current;
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
        Node prev = tail;
        boolean found = false;
        int count = 0;
        do {
            if (current.data == key) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
            count++;
        } while (current != head);

        if (!found) {
            System.out.println("Value " + key + " not found in the list.");
            return;
        }

        if (current == head) {
            deleteAtBeginning();
        } else if (current == tail) {
            deleteAtEnd();
        } else {
            prev.next = current.next;
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
     * Displays the list elements.
     */
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Circular Singly Linked List: ");
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}
