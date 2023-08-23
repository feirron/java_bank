package model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    // Constructors
    public Customer(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Customer(int id, String name, String address, String phoneNumber, String email) {
        this(name,address,phoneNumber,email);
        this.id = id;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
}
