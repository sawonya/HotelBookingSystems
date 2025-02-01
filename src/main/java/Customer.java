abstract class Customer {
    private int customerID;
    private String name;
    private String email;
    private String phone;

    public Customer(int customerID, String name, String email, String phone) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Полиморфизм:
    public abstract void viewDetails();
}
