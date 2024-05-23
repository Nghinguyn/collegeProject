// Phuong Nghi Nguyen - 3106296
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
    // distance method to calculate the distance between two locations as the crow flies
    public static double distance(Location first, Location second) {
        double latitude1 = first.getLatitude();
        double longitude1 = first.getLongitude();
        double latitude2 = second.getLatitude();
        double longitude2 = second.getLongitude();

        // use the Haversine formula to calculate the  crow flies distance
        double earthRadius = 6371; // Radius of the Earth (km)
        // find the distance between the latitude and longtitude of the 2 buildings
        double disLatitude = Math.toRadians(latitude2 - latitude1);
        double disLongitude = Math.toRadians(longitude2 - longitude1);
        // applying the Haversine formula
        double a = Math.sin(disLatitude / 2) * Math.sin(disLatitude / 2) +
                Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) *
                        Math.sin(disLongitude / 2) * Math.sin(disLongitude / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        // calculate the distance
        double distance = earthRadius * c;
        return distance;
    }

    // the main method
    public static void main(String[] args) {

        // Create instances of commercial and residential buildings in Dublin
        // address 1
        Address address1 = new Address();
        address1.setLatitude(53.3340781);
        address1.setLongitude(-6.2382223);
        address1.setEircode("D09 XH66");
        address1.setStreetName("Haddington Rd");
        address1.setCity("Dublin");

        ResidentialBuilding residential1 = new ResidentialBuilding(address1, "Building Number1");
        // address 2
        Address address2 = new Address();
        address2.setLatitude(53.2956831);
        address2.setLongitude(-6.2332555);
        address2.setEircode("D14 PY56 ");
        address2.setStreetName("14 Lower Kilmacud Rd");
        address2.setCity("Dublin 20");
        // add new commercial buildind instance
        CommercialBuilding commercial1 = new CommercialBuilding(address2, "The Goat Bar & Grill", null, null, null);

        Address address3 = new Address();
        address3.setLatitude(53.3349994);
        address3.setLongitude(-6.2668376);
        address3.setEircode("D04 A3T6");
        address3.setStreetName("68 Pembroke Rd");
        address3.setCity("Dublin");
        // add new commercial buildind instance
        CommercialBuilding commercial2 = new CommercialBuilding(address3, "Morris Clinic", null, null, null);

        // Create a list of residential buildings.
        List<Building> residentBuildings = new ArrayList<>();
        residentBuildings.add(residential1);
        residentBuildings.add(commercial1);
        residentBuildings.add(commercial2);

        // Implement the user interaction logic (menu options) with while loop and switch cases
        Scanner scanner = new Scanner(System.in);
        // use the while loop to start the program
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Find a building with Eircode");
            System.out.println("2. Get a building Eircode using coordinates");
            System.out.println("3. Find the distance between two buildings");
            System.out.println("4. Exit");
            // get the user's option
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character.
            // start
            switch (choice) {
                // find the building using eircode
                case 1:
                    // ask the user to input an eircode
                    System.out.print("Enter an Eircode: ");
                    // take user's input
                    String searchEircode = scanner.nextLine();
                    // create a buidling instance to hold, set it to null
                    Building foundBuilding = null;
                    // use for loop to search for the building with the corresponding eircode
                    for (Building building : residentBuildings) {
                        // if the input eircode match and eircode from one of the building
                        if (building.getAddress().getEircode().equals(searchEircode)) {
                            foundBuilding = building; // assign the building info to the building instance
                            break;
                        }
                    }
                    // check the building if it is found
                    if (foundBuilding != null) {
                        // print out building's info
                        System.out.println("Building Info:");
                        if (foundBuilding instanceof ResidentialBuilding) {
                            System.out.println("Residential Building:");
                        } else if (foundBuilding instanceof CommercialBuilding) {
                            System.out.println("Commercial Building:");
                        }
                        // print building's address
                        System.out.println(foundBuilding.getAddress().getAddress());
                    // if the building is not found, print out a notice
                    } else {
                        System.out.println("Building not found with the given Eircode.");
                    }
                    break;
                // get building Eircode by coordinate
                case 2:
                    // ask the user to input latitude
                    System.out.print("Enter latitude: ");
                    // take user's input
                    double userLatitude = scanner.nextDouble();
                    // ask the user to input longitude
                    System.out.print("Enter longitude: ");
                    // take user's input
                    double userLongitude = scanner.nextDouble();
                    // set building back to null
                    foundBuilding = null;
                    // use for loop to search for the building with the corresponding latitude and longitude
                    for (Building residential : residentBuildings) {
                        // get address of the building
                        Location buildingLocation = residential.getAddress();
                        //compare if it matches user's inputs or not
                        if (buildingLocation.getLatitude() == userLatitude && buildingLocation.getLongitude() == userLongitude) {
                            foundBuilding = residential;
                            break;
                        }
                    }
                    // if found the building, print out a notice
                    if (foundBuilding != null) {
                        System.out.println("Found the building, the Eircode is: " + foundBuilding.getAddress().getEircode());
                    // if the building is not found, print out a notice
                    } else {
                        System.out.println("Cannot find the building based on the provided latitude and longitude.");
                    }
                    break;
                // calculate distance between two buildings using Eircode
                case 3:
                    // ask the user to input an eircode
                    System.out.print("Enter the first building's Eircode: ");
                    // take user's input
                    String eircode1 = scanner.nextLine();
                    // ask the user to input an eircode
                    System.out.print("Enter the second building's Eircode: ");
                    // take user's input
                    String eircode2 = scanner.nextLine();
                    // create instances to hold building value
                    Building building1 = null;
                    Building building2 = null;
                    // use for loop to search for the building with the corresponding latitude and longitude
                    for (Building residential : residentBuildings) {
                        //compare if the eircode in the list matches user's inputs or not
                        if (residential.getAddress().getEircode().equals(eircode1)) {
                            // if it matches, the put the resident detail into it
                            building1 = residential;
                        }
                        // do the same with the second building
                        if (residential.getAddress().getEircode().equals(eircode2)) {
                            building2 = residential;
                        }
                    }
                    // if both building is found
                    if (building1 != null && building2 != null) {
                        // call the distance calculating method
                        double distance = distance(building1.getAddress(), building2.getAddress());
                        // print out the result
                        System.out.println("Distance between buildings is " + distance + " km");
                    } else {
                        System.out.println("Buildings with the provided Eircodes not found.");
                    }
                    break;
                // When user want to exit the program
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                // the default respond for errors or exceptions
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}