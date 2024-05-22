/*
 * Phuong Nghi Nguyen - 3106296
 * 12/04/2023
 */
package assignment7;

import java.util.Scanner;
import java.io.*;

public class Main1 {

	public static void main(String[] args) {
		// Task 1
		 reverse("Word");

	}

	// REVERSE METHOD for task 1
	public static String reverse(String fileName) {
		// declare and initialize variables
		String line = "";
		String modifiedLine = "";
		/*
		 * What to do: Open the file 1 get content from file 1 reverse it in java with
		 * for loop write the reversed version to file 2
		 */
		try {
			// call the file reader to access the file
			BufferedReader readFile = new BufferedReader(new FileReader(fileName + ".csv"));
			// put a String to store content getting from the file
			while ((line = readFile.readLine()) != null) {
				// split the string with split method and put them into the array
				String[] wordArr = line.split(",");
				// start writing the content into the reverse file
				try {
					BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName + "_reversed.csv"));
					// Reverse the array with a for loop, this for loop will reverse LINE BY LINE
					for (int i = wordArr.length - 1; i >= 0; i--) {
						// Create a string to store it, add in the comma that the split method has
						// deleted
						modifiedLine += wordArr[i] + ",";
					}
					// Add \n to go to new line after each line
					modifiedLine += "\n";
					// Write it into the reversed file
					writeFile.write(modifiedLine);
					// close the writing file
					writeFile.close();
					// catch exceptions
				} catch (IOException e) {
					System.out.println("Error writing file");
				}
			}
			// close reading file
			readFile.close();
			// System.out.println(line2);
		}
		// catch exceptions
		catch (IOException e) {
			System.out.println("Error 2");
		}
		return fileName;
	}

}
