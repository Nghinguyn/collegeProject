// Phuong Nghi Nguyen - 3106296
package org.example;
// Node class for representing elements in the linked list
public class Node {
    // initialize objects for Node class
    // attributes to hold the data value
    int data;
    Node prev; // The reference for the previous node
    Node next; // The reference for the next node

    // Constructor to initialize the node and data
    Node(int data) {
        this.data = data;
        this.prev = null; // Initialize prev reference to null
        this.next = null; // Initialize next reference to null
    }
}