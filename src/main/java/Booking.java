import java.util.Date;

class Booking {
    private int bookingID;
    private int customerID;
    private int roomID;
    private Date checkIn;
    private Date checkOut;
    private double totalPrice;

    public Booking(int bookingID, int customerID, int roomID, Date checkIn, Date checkOut, double totalPrice) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.roomID = roomID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }

    public int getBookingID() {
        return bookingID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getRoomID() {
        return roomID;
    }

    public Date getCheckIn() { // Добавил метод для исправления ошибки
        return checkIn;
    }

    public Date getCheckOut() { // Добавил метод для исправления ошибки
        return checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
