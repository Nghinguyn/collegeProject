// Phuong Nghi Nguyen - 3106296
package org.example;
public class DoubleLinkedList {
    // Reference to the first node in the linked list (head)
    Node head;
    // Reference to the last node in the linked list (tail)
    Node tail;

    // Constructor to initialize an empty linked list
    public DoubleLinkedList() {
        this.head = null; // Initialize head reference to null
        this.tail = null; // Initialize tail reference to null
    }

    // Method to add a new node to the beginning of the list
    public void addFirst(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // if not, update references to insert the new node at the beginning
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    // Method to add a new node to the end of the list
    public void addLast(int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // If the list is empty, set both head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // if not, update references
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    // Method to add a new node after a given node
    public void addAfter(Node node, int data) {
        // Create a new node with the given data
        Node newNode = new Node(data);
        // Update references to insert the new node after the given node
        newNode.prev = node;
        newNode.next = node.next;
        // check if the next node is null or not
        if (node.next != null) {
            node.next.prev = newNode;
        }
        node.next = newNode;
        // If the given node is the current tail, update tail reference
        if (node == tail) {
            tail = newNode;
        }
    }
    // Method to remove a node containing the given data
    public boolean remove(int data) {
        // Traverse the list to find the node with the given data
        Node current = head;
        // loop through the list
        while (current != null) {
            if (current.data == data) {
                // If found, update references to remove the node
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return true; // Node removed successfully
            }
            current = current.next;
        }
        return false; // Node not found
    }

    // Method to remove all nodes containing the given data
    public void removeAll(int data) {
        // loop through the list and remove all nodes containing the given data
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                // Remove the node if its data matches the given data
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
            }
            current = current.next;
        }
    }

    // Method to display all items in the list
    public String display() {
        // Create a StringBuilder to store the list elements
        StringBuilder sb = new StringBuilder();
        // Start from the head of the list
        Node current = head;
        // Traverse the list
        while (current != null) {
            // Append the data of the current node to the StringBuilder
            sb.append(current.data).append(" ");
            // Move to the next node
            current = current.next;
        }
        // Convert StringBuilder to String and return
        return sb.toString();
    }

    // Method to display all items in reverse order
    public String displayReversed() {
        // Create a StringBuilder to store the list elements
        StringBuilder sb = new StringBuilder();
        // starts from the tail
        Node current = tail;
        // loop through the list
        while (current != null) {
            sb.append(current.data).append(" "); // Append data to StringBuilder
            current = current.prev; // Move to the previous node
        }
    return sb.toString(); // Convert StringBuilder to String and return
    }
}
