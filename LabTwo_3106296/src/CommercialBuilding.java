// Phuong Nghi Nguyen - 3106296
public class CommercialBuilding extends Building { // a subclass of Building class
    private String name;
    private String description, openHour, webURL;
    // a constructor to get and set address and name
    public CommercialBuilding(Address address, String name) {
        super(address);
        if (name != null) {
            this.name = name;
        // if there is no name, print out a warning
        } else {
            System.out.println("Name cannot be null.");
        }
    }
    // a constructor to get and set address, name, description, openHour and webURL
    public CommercialBuilding(Address address, String name, String description,String openHour, String webURL) {
        super(address); // call the constructor from the super class
        if (name != null) {
            this.name = name;
        // if there is no name, print out a warning
        } else {
            System.out.println("Name cannot be null.");
        }
        //set description, openHour and webURL
        this.description = description;
        this.openHour = openHour;
        this.webURL = webURL;
    }
    // a method to get all info regarding the building
    public String getInfo() {

        // return the info as a String
        // check if the description, openHour and webURL are null then print
        return "Name: " + name + (description != null ? ", Description: " + description : "") + (openHour != null ? ", Description: " + openHour : "") +
                (webURL != null ? ", Description: " + webURL : "");
    }
}