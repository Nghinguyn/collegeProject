/*
 * Phuong Nghi Nguyen - 3106296
 * 15/04/2023
 */
package assignment7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.*;
import java.util.*;

public class Main4 {

	public static void main(String[] args) throws FileNotFoundException {
		// declare and initialize variables
		String url, location;
		Scanner scan = new Scanner(System.in);
		// start getting user's input
		System.out.println("Please input url of the file you want to download");
		/*
		 * The URL assignment 7 provided:
		 * https://icatcare.org/app/uploads/2018/07/Elderly-cats.png
		 */
		url = scan.nextLine();
		/*
		 * I have created 3 folders for user to choose location 
		 * Location 1: "location1"
		 * Location 2: "location2" 
		 * Location 3: "location3"
		 */
		System.out.println("Please location you want to store file, make sure it is CORRECT");
		location = scan.nextLine();

		download(url, location);
	}

	// METHOD
	public static void download(String url, String location) {

		// create a string array to store split input URL
		String[] urlArr = url.split("/");
		Scanner scan = new Scanner(System.in);

		try {
			// access the URL
			InputStream inputURL = new URL(url).openStream();
			// get path(directory) to store new file
			Path outputPath = Paths.get(location + "\\" + urlArr[urlArr.length - 1]);
			// check if the file exist first before downloading
			// if the file has already exist:
			if (Files.exists(outputPath)) {
				// print out warning
				System.out.println("The file is already exist, do you still want to save new file? (yes/no)");
				// create a while loop to get user's answer (and to avoid crash)
				boolean checking = true;
				while (checking) {
					String answer = scan.nextLine();
					// remove excess white space
					answer.replaceAll("\\s", "");
					// set conditions for yes
					if (answer.equalsIgnoreCase("yes")) {
						/*
						 * if we simply put the (1) behind the picture, the format will be changes. To
						 * solve this, I split the name again with the split method. Put "\\." instead
						 * of "." because putting "." in regex will mean delete all characters, and the
						 * program will got crashed
						 */
						String[] splittedNamelArr = urlArr[urlArr.length - 1].split("\\.");
						// assign new path (new file name)
						outputPath = Paths
								.get(location + "\\" + splittedNamelArr[0] + "(1)" + "." + splittedNamelArr[1]);
						// get and save file
						Files.copy(inputURL, outputPath, StandardCopyOption.REPLACE_EXISTING);
						// print out notification
						System.out.println("File saved");
						// break while loop
						break;
					}
					// set conditions for no
					if (answer.equalsIgnoreCase("no")) {
						// exit the program
						System.exit(0);
					} else {
						// if user type in anything different from "yes" or "no", tell user to input
						// again
						System.out.println("Please answer \"yes\" or \"no\" only");
						// continue the while loop
						continue;
					}
				}
			// if the file is not exist:
			} else {
				// get and save file
				Files.copy(inputURL, outputPath, StandardCopyOption.REPLACE_EXISTING);
				// print out notification
				System.out.println("File saved");
			}
		} catch (MalformedURLException e) {
			System.out.println("Cannot find the URL, please check your URL again");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error from opening url function");
			e.printStackTrace();
		}
	}
}
