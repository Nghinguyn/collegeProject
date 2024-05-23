// Phuong Nghi Nguyen - 3106296
package org.example;
import org.example.List;

import java.util.Arrays;
public class Set implements List {
    // Declare array to store elements
    private int[] array;
    // Maximum capacity of the array
    private int capacity;
    // Current number of elements in the array
    private int size;

    // Constructor initializes the array with default capacity and sets size to 0
    public Set() {
        capacity = 10;
        array = new int[capacity];
        size = 0;
    }

    // Method to return the current number of elements in the array
    @Override
    public int size() {
        return size;
    }

    // Method to add an element to the array if it doesn't already exist
    @Override
    public void add(int x) {
        // Check if the element is not already present in the array
        if (!contains(x)) {
            // If the array is full, double its capacity
            if (size == capacity) {
                capacity *= 2;
                array = Arrays.copyOf(array, capacity);
            }
            // Add the new element to the array and increment the size
            array[size++] = x;
        }
    }

    // Method to retrieve an element from a specified index in the array
    @Override
    public int get(int index) {
        // Throw exception if the index is out of bounds
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Return the element at the specified index
        return array[index];
    }

    // Method to check if the array contains a specific element
    @Override
    public boolean contains(int x) {
        // Loop through the array to search for the element
        for (int i = 0; i < size; i++) {
            // if one of the array element is the searching index, return true
            if (array[i] == x) {
                return true;
            }
        }
        // Return false if the element is not found
        return false;
    }

    // Method to remove a specific element from the array
    @Override
    public boolean remove(int x) {
        // Iterate through the array to find the element
        for (int i = 0; i < size; i++) {
            if (array[i] == x) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                // Decrease the size and return true
                size--;
                return true;
            }
        }
        // Return false if the element is not found
        return false;
    }

    // Method to convert the array to a string representation
    @Override
    public String toString() {
        // Use StringBuilder to efficiently build the string
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // Append each element to the string
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            // Add comma and space if not the last element
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        // Return the final complete string
        return sb.toString();
    }
}
