class RegularCustomer extends Customer {
    public RegularCustomer(int customerID, String name, String email, String phone) {
        super(customerID, name, email, phone);
    }

    @Override
    public void viewDetails() {
        System.out.println("👤 Customer: " + getName() + " (" + getEmail() + ")");
    }
}