/*
 * Phuong Nghi Nguyen - 3106296
 * 14/04/2023
 */
package assignment7;

import java.io.*;
import java.text.*;
import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		
		// METHOD 1
		logAmount(/*Input the update amount here*/ 98);
		
		// METHOD 2
		extracted(/*Input the date(MM-dd) here*/"02-16");
	}

	public static void extracted(String startDate) {
		// declare and initialize variables
		String line = "";
		String modifiedLine = "";
		String[] lineArr = null;
		/*
		 *  read the file and compare the dateString in the 
		 */
		try {
			// call the file reader to access the file
			BufferedReader readFile = new BufferedReader(new FileReader("Amount Update.csv"));
			// put a String to store content getting from the file
			while ((line = readFile.readLine()) != null) {
				// split the string with split method and put them into the array
				lineArr = line.split(",");
				// check the date array with the start date
				if (lineArr[1].equals(startDate)) {
					// subtract the total price
					System.out.println(lineArr[0] + "," + lineArr[2]);
				}
			}
			// close reading the file
			readFile.close();
			// catch exceptions
			} catch (IOException e) {
				System.out.println("Error from method 1 reading file");
			}
	}

	public static void logAmount(int amount) {
		// declare and initialize variables
		String line = "";
		String modifiedLine = "";
		String[] arrByLine = null;
		/*
		 * What to do for method 1: Set up the date (MM-dd) and time (H:mm) format
		 * Access the file to write and read to check the amount Write it into the file
		 */

		// Initializing date format mm/dd using SimpleDateFormat class
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");

		// Displaying the formats
		Date now = new Date();
		// Create a string to store the date with the format
		String date = dateFormat.format(now);

		// Initializing date format mm/dd using SimpleDateFormat class
		SimpleDateFormat timeFormat = new SimpleDateFormat("H:mm");

		// Create a string to store the time with the format
		String time = timeFormat.format(new Date());

		// read the file
		try {
			// call the file reader to access the file
			BufferedReader readFile = new BufferedReader(new FileReader("Amount Update.csv"));
			// put a String to store content getting from the file
			while ((line = readFile.readLine()) != null) {
				// split the string with split method and put them into the array
				arrByLine = line.split(",");
				/*
				 * split the string with split method and put them into the array because the
				 * string will be split by ",", there will always be only FOUR array's values
				 * (amount, date, time and update) on each line
				 */
				// create a string to save all the previous data read from the file
				modifiedLine += line + "\n";
			}
			// create a variable to store the last update amount
			int lastUpdateAmount = Integer.parseInt(arrByLine[0]);
			/*
			 * use if condition to check if the amount has been updated or not, this program
			 * will only check if the newly input amount and the latest updated amount are
			 * different or not. If they are different, save the new amount into the update
			 */
			if (lastUpdateAmount == amount) {
				System.out.println("The same amount as the last update, please change the amount to make an update");
			} else {
				// write the file content
				try {
					BufferedWriter writeFile = new BufferedWriter(new FileWriter("Amount Update.csv"));
					// write all the previous data info
					writeFile.write(modifiedLine);
					// update the new amount
					writeFile.write(amount + "," + date + "," + time + ",UPDATED");
					writeFile.close();
				}
				// catch exceptions
				catch (IOException e) {
					System.out.println("Error from method 1 writing file");
				}
			}
			// close reading the file
			readFile.close();
			// catch exceptions
		} catch (IOException e) {
			System.out.println("Error from method 1 reading file");
		}
	}

}
