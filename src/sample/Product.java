package sample;


public class Product {

    private String name;
    private String lastName;
    private String address;

    public Product() {
        this.name = "";
        this.lastName = "";
        this.address = "";
    }

    public Product(String name, String lastName, String address) {

        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
