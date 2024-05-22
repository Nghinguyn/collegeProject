/*
 * Phuong Nghi Nguyen - 3106296
 * 12/04/2023
 */
package assignment7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		// Task 2
				System.out.println(priceVerify("receipt.txt"));
			}

			
			// PRICE VERTIFY METHOD for task 2
			public static Boolean priceVerify(String fileName) {
				/*
				 * Make an array that different from the array in the first method, this array
				 * with take the second word of EVERY line. Take the value of the second word of
				 * the line => The price's amount. Add them together and compare it with the
				 * last number (the total price) on the last line.
				 */
				
				// declare and initialize variables
				Boolean priceMatching = null;
				String line = "";
				double priceSum = 0;
				String[] priceArr = null;
				// read the file
				try {
					// call the file reader to access the file
					BufferedReader readFile = new BufferedReader(new FileReader(fileName));
					// put a String to store content getting from the file
					while ((line = readFile.readLine()) != null) {
						// Trim down excess white spaces in case user type in any white spaces
						line = line.replaceAll("\\s", "");
						/*
						 * split the string with split method and put them into the array because the
						 * string will be split by ":", there will always be only TWO array's values on
						 * each line
						 */
						// Split each string line
						priceArr = line.split(":");
						// Adding the prices together, including the last line
						priceSum += Double.parseDouble(priceArr[1]);
					}
					/*
					 * Because outside of the while loop, the array's value we get is always the
					 * value from the LAST line, we can use this to check. I think it will be
					 * easier to check the total line with if statement than having to make a for
					 * loop.
					 */
					// On the last line, if the first word is "total" then we will subtract the price amount
					if (priceArr[0].equalsIgnoreCase("total")) {
						// subtract the total price
						priceSum -= Double.parseDouble(priceArr[1]);
						// Check if the sum and the total amount match
						// if it's equal
						if (priceSum == Double.parseDouble(priceArr[1])) {
							// print out the notification
							System.out.println("The given total price is equal to the combined prices of all items: " + priceSum);
							// return the boolean value
							priceMatching = true;
						}
						// if it's not equal
						else {
							// print out the notification
							System.out.print("The given total price is NOT equal to the combined prices of all items\nTotal: \"" + priceArr[1] + "\""); 
							System.out.printf("	Real sum: %.2f",priceSum);
							System.out.println();
							// return the boolean value
							priceMatching = false;
						}
					//If the first word is not "total" then print out a warning
					} else {
						// print out the notification
						System.out.println("File format incorrect no Total found");
						// return the boolean value
						priceMatching = false;
					}
					// close reading file
					readFile.close();
				}
				// catch exceptions
				catch (IOException e) {
					System.out.println("Error from task 2");
				}
				return priceMatching;
			}
}
