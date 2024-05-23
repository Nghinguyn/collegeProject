// Phuong Nghi Nguyen - 3106296
public class Address extends Location {
    // create attributes
    private String eircode;
    private String streetName;
    private String city;
    // getters and setters for attributes
    public String getEircode() {
        return eircode;
    }
    public void setEircode(String eircode) {
        this.eircode = eircode;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    // method to print out building address
    public String getAddress() {
        return "Street: " + streetName + ", City: " + city + ", Eircode: " + eircode;
    }
}