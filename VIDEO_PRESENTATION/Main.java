package VIDEO_PRESENTATION;

import java.util.Scanner;

/**
 * Main.java
 * Driver program to interact with four types of linked lists:
 * Singly, Doubly, Circular Singly, Circular Doubly.
 * Supports insertions, deletions, search, and display.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinglyLinkedList singly = new SinglyLinkedList();
        DoublyLinkedList doubly = new DoublyLinkedList();
        CircularLinkedList circularSingly = new CircularLinkedList();
        CircularDoublyLinkedList circularDoubly = new CircularDoublyLinkedList();

        while (true) {
            System.out.println("\n=== LINKED LIST PROGRAM ===");
            System.out.println("Choose the type of Linked List:");
            System.out.println("1. Singly Linked List");
            System.out.println("2. Doubly Linked List");
            System.out.println("3. Circular Singly Linked List");
            System.out.println("4. Circular Doubly Linked List");
            System.out.println("5. Exit program");
            System.out.print("Enter your choice: ");

            int listChoice = sc.nextInt();
            if (listChoice == 5) {
                System.out.println("Exiting program... Goodbye!");
                break;
            }

            boolean backToMain = false;
            while (!backToMain) {
                System.out.println("\n--- OPERATIONS MENU ---");
                System.out.println("1. Insert at Beginning");
                System.out.println("2. Insert at Specific Index");
                System.out.println("3. Insert at End");
                System.out.println("4. Delete at Beginning");
                System.out.println("5. Delete at Specific Index");
                System.out.println("6. Delete at End");
                System.out.println("7. Search for a Value");
                System.out.println("8. Display List");
                System.out.println("9. Go Back to Main Menu");
                System.out.print("Enter your choice: ");

                int op = sc.nextInt();
                int value, index, searchResult;

                switch (op) {
                    case 1: // Insert at beginning
                        System.out.print("Enter value to insert: ");
                        value = sc.nextInt();
                        switch (listChoice) {
                            case 1 -> singly.insertAtBeginning(value);
                            case 2 -> doubly.insertAtBeginning(value);
                            case 3 -> circularSingly.insertAtBeginning(value);
                            case 4 -> circularDoubly.insertAtBeginning(value);
                        }
                        break;

                    case 2: // Insert at index
                        System.out.print("Enter value to insert: ");
                        value = sc.nextInt();
                        System.out.print("Enter index (starting from 0): ");
                        index = sc.nextInt();
                        switch (listChoice) {
                            case 1 -> singly.insertAtIndex(value, index);
                            case 2 -> doubly.insertAtIndex(value, index);
                            case 3 -> circularSingly.insertAtIndex(value, index);
                            case 4 -> circularDoubly.insertAtIndex(value, index);
                        }
                        break;

                    case 3: // Insert at end
                        System.out.print("Enter value to insert: ");
                        value = sc.nextInt();
                        switch (listChoice) {
                            case 1 -> singly.insertAtEnd(value);
                            case 2 -> doubly.insertAtEnd(value);
                            case 3 -> circularSingly.insertAtEnd(value);
                            case 4 -> circularDoubly.insertAtEnd(value);
                        }
                        break;

                    case 4: // Delete at beginning
                        switch (listChoice) {
                            case 1 -> singly.deleteAtBeginning();
                            case 2 -> doubly.deleteAtBeginning();
                            case 3 -> circularSingly.deleteAtBeginning();
                            case 4 -> circularDoubly.deleteAtBeginning();
                        }
                        break;

                    case 5: // Delete at index
                        System.out.print("Enter index (starting from 0): ");
                        index = sc.nextInt();
                        switch (listChoice) {
                            case 1 -> singly.deleteAtIndex(index);
                            case 2 -> doubly.deleteAtIndex(index);
                            case 3 -> circularSingly.deleteAtIndex(index);
                            case 4 -> circularDoubly.deleteAtIndex(index);
                        }
                        break;

                    case 6: // Delete at end
                        switch (listChoice) {
                            case 1 -> singly.deleteAtEnd();
                            case 2 -> doubly.deleteAtEnd();
                            case 3 -> circularSingly.deleteAtEnd();
                            case 4 -> circularDoubly.deleteAtEnd();
                        }
                        break;

                    case 7: // Search for a value
                        System.out.print("Enter value to search for: ");
                        value = sc.nextInt();
                        switch (listChoice) {
                            case 1 -> {
                                searchResult = singly.search(value);
                                printSearchResult(searchResult);
                            }
                            case 2 -> {
                                searchResult = doubly.search(value);
                                printSearchResult(searchResult);
                            }
                            case 3 -> {
                                searchResult = circularSingly.search(value);
                                printSearchResult(searchResult);
                            }
                            case 4 -> {
                                searchResult = circularDoubly.search(value);
                                printSearchResult(searchResult);
                            }
                        }
                        break;

                    case 8: // Display list
                        switch (listChoice) {
                            case 1 -> singly.displayList();
                            case 2 -> doubly.displayForward();
                            case 3 -> circularSingly.display();
                            case 4 -> circularDoubly.displayForward();
                        }
                        break;

                    case 9: // Go back to main menu
                        backToMain = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        sc.close();
    }

    private static void printSearchResult(int index) {
        if (index == -1) {
            System.out.println("Value not found in the list.");
        } else {
            System.out.println("Value found at index: " + index);
        }
    }
}
