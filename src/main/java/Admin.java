class Admin extends Customer {
    private String role;

    public Admin(int customerID, String name, String email, String phone, String role) {
        super(customerID, name, email, phone);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Полиморфизм
    @Override
    public void viewDetails() {
        System.out.println("🔹 Admin [" + role + "]: " + getName() + " (" + getEmail() + ")");
    }

    public void manageHotel(Hotel hotel) {
        System.out.println("🏨 Managing hotel: " + hotel.getName());
    }

    public void manageHotel(Hotel hotel, String action) {
        System.out.println("🏨 Admin is " + action + " the hotel: " + hotel.getName());
    }

    public void manageBookings() {
        System.out.println("📅 Admin is managing hotel bookings...");
    }

    public void manageBookings(int bookingID) {
        System.out.println("📅 Admin is reviewing booking ID: " + bookingID);
    }
}