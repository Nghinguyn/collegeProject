// Phuong Nghi Nguyen - 3106296
package org.example;
import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

public class DynamicTest {

//    // Testing methods for Question 1 Set class
//    // Create a Set instance variable for tests
//    private Set set;
//    // Test method for the add method
//    @Test
//    void testAddMethod() {
//        // Initialize the Set object
//        set = new Set();
//        // Add an element to the set
//        set.add(24);
//        // Assert that the set contains the added element
//        assertTrue(set.contains(24));
//        // Check if the set's size is 1 after adding an element
//        assertEquals(1, set.size());
//        // Add another element to the set
//        set.add(19);
//        // Check if the set's size is 2 after adding another element
//        assertEquals(2, set.size());
//    }
//    // Test method to verify the behavior of the contains method
//    @Test
//    public void testContains() {
//        Set set = new Set();
//        // Add elements to the set
//        set.add(9);
//        set.add(32);
//        set.add(263);
//        // Check if the set contains the added elements
//        assertTrue(set.contains(9));
//        assertTrue(set.contains(32));
//        assertTrue(set.contains(263));
//        // Check if the set does not contain a non-existing element
//        assertFalse(set.contains(320));
//    }
//    // Test method for the remove method
//    @Test
//    void testRemoveMethod() {
//        // Initialize the Set object
//        set = new Set();
//        // Add an element to the set
//        set.add(67);
//        // Remove the added element from the set
//        assertTrue(set.remove(67));
//        // Check if the set is no longer contains the removed element
//        assertFalse(set.contains(67));
//        // Check if the size of the set is 0 after removing an element
//        assertEquals(0, set.size());
//    }
//    // Test method for the get method
//    @Test
//    void testGetMethod() {
//        // Initialize the Set object
//        set = new Set();
//        // Add a few elements to the set
//        set.add(42);
//        set.add(1);
//        set.add(73);
//        set.add(16);
//        // Check if the get method returns the correct element from the set
//        assertEquals(73, set.get(2));
//    }
//    // Test method to verify the behavior of the toString method
//    @Test
//    public void testToString() {
//        Set set = new Set();
//        // Add elements to the set
//        set.add(5);
//        set.add(94);
//        set.add(346274);
//        // Check if the toString method returns the expected string representation
//        assertEquals("[5, 94, 346274]", set.toString());
//    }

    /*
    _______________________
    Testing methods for Question 2
    _______________________
     */

    // Test method for adding a node to the beginning of the list
    @Test
    public void testAddFirst() {
        // Create a new instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();
        // Add nodes to the list
        list.addFirst(23);
        list.addFirst(612435);
        // Check if the list print out result is as expected after adding nodes
        assertEquals("612435 23 ", list.display());
    }

    // Test method for adding a node to the end of the list
    @Test
    public void testAddLast() {
        // Create a new instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();
        // Add nodes to the list
        list.addLast(96);
        list.addLast(-23);
        // Check if the list print out result is as expected after adding nodes
        assertEquals("96 -23 ", list.display());
    }

    // Test method for adding a node after a given node
    @Test
    public void testAddAfter() {
        // Create a new instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();
        // Add nodes to the list
        list.addLast(435);
        list.addLast(26);
        // Add a node after a given node
        list.addAfter(list.head, 74);
        // Check if the list print out result is as expected after adding nodes
        assertEquals("435 74 26 ", list.display());
    }

    // Test method for removing a node by data
    @Test
    public void testRemove() {
        // Create a new instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();
        // Add nodes to the list
        list.addLast(27);
        list.addLast(32);
        list.addLast(15);
        // Remove a node by data
        list.remove(32);
        // Check if the list print out result is as expected after removing a node
        assertEquals("27 15 ", list.display());
    }

    // Test method for removing all nodes containing the given data
    @Test
    public void testRemoveAll() {
        // Create a new instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();
        // Add nodes to the list
        list.addLast(2);
        list.addLast(47);
        list.addLast(73);
        list.addLast(85);
        // add a repeated data value
        list.addLast(73);
        // Remove all nodes containing the given data
        list.removeAll(73);
        // Check if the list print out result is as expected after removing nodes
        assertEquals("2 47 85 ", list.display());
    }

    // Test method for displaying the list
    @Test
    public void testDisplay() {
        // Create a new instance of DoubleLinkedList
        DoubleLinkedList list = new DoubleLinkedList();
        // Add nodes to the list
        list.addLast(263);
        list.addLast(47);
        list.addLast(81);
        // Check if the list print out result is as expected when displayed
        assertEquals("263 47 81 ", list.display());
    }

//    // Test method for displaying the list in reverse order
//    @Test
//    public void testDisplayReversed() {
//        // Create a new instance of DoubleLinkedList
//        DoubleLinkedList list = new DoubleLinkedList();
//        // Add nodes to the list
//        list.addLast(5);
//        list.addLast(10);
//        list.addLast(15);
//        // Check if the list print out result is as expected when displayed in reverse order
//        assertEquals("15 10 5 ", list.displayReversed());
//    }

}