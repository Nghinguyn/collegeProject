// Phuong Nghi Nguyen - 3106296
public class ResidentialBuilding extends Building { // a subclass of Building class
    private String buildingNumber;
    // A Residential Building constructor
    public ResidentialBuilding(Address address, String buildingNumber) {
        // get the address from the superclass
        super(address);
        // set the address
        this.buildingNumber = buildingNumber;
    }
}

