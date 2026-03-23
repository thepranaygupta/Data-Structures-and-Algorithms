// Problem: Iterative function to show Linear Search in Linked List
// Author: Dileep Kumar C
// GitHub: https://github.com/Dileep-kumarc
// Reference: https://github.com/thepranaygupta/Data-Structures-and-Algorithms

package linkedlist;

public class LinearSearch_LL {

    // ==================== NODE CLASS ====================
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ==================== LINKED LIST CLASS ====================
    static class LinkedList {
        Node head;

        // Constructor
        public LinkedList() {
            head = null;
        }

        // Method to insert node at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Method to display the linked list
        public void display() {
            if (head == null) {
                System.out.println("List is Empty");
                return;
            }
            Node temp = head;
            System.out.print("Linked List: ");
            while (temp != null) {
                System.out.print(temp.data);
                if (temp.next != null) System.out.print(" -> ");
                temp = temp.next;
            }
            System.out.println(" -> NULL");
        }

        // ==================== LINEAR SEARCH ====================
        // Time Complexity  : O(N)
        // Space Complexity : O(1)
        // Returns the position (1-indexed) if key is found, else returns -1

        public int linearSearch(int key) {
            Node temp = head;
            int position = 1;

            while (temp != null) {
                if (temp.data == key) {
                    return position; // Key found, return position
                }
                temp = temp.next;
                position++;
            }
            return -1; // Key not found
        }
    }

    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        // Inserting elements
        list.insertAtEnd(3);
        list.insertAtEnd(5);
        list.insertAtEnd(7);
        list.insertAtEnd(10);
        list.insertAtEnd(25);
        list.insertAtEnd(8);
        list.insertAtEnd(32);
        list.insertAtEnd(2);

        // Display the list
        list.display();

        // Test Case 1: Search for key = 32 (exists)
        int key1 = 32;
        int result1 = list.linearSearch(key1);
        if (result1 != -1)
            System.out.println("Key " + key1 + " found at position: " + result1);
        else
            System.out.println("Key " + key1 + " not found in the list.");

        // Test Case 2: Search for key = 99 (does not exist)
        int key2 = 99;
        int result2 = list.linearSearch(key2);
        if (result2 != -1)
            System.out.println("Key " + key2 + " found at position: " + result2);
        else
            System.out.println("Key " + key2 + " not found in the list.");

        // Test Case 3: Search for key = 3 (first element)
        int key3 = 3;
        int result3 = list.linearSearch(key3);
        if (result3 != -1)
            System.out.println("Key " + key3 + " found at position: " + result3);
        else
            System.out.println("Key " + key3 + " not found in the list.");
    }
}

/*
 * OUTPUT:
 * -------
 * Linked List: 3 -> 5 -> 7 -> 10 -> 25 -> 8 -> 32 -> 2 -> NULL
 * Key 32 found at position: 7
 * Key 99 not found in the list.
 * Key 3 found at position: 1
 *
 * HOW IT WORKS:
 * -------------
 * 1. We start from the head node
 * 2. We compare each node's data with the key
 * 3. If match found → return position
 * 4. If we reach end without match → return -1
 */
