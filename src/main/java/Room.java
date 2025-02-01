public class Room {
    private final int roomID;
    private final int hotelID;
    private final String roomNumber;
    private final String roomType;
    private final double price;
    private final boolean isAvailable;

    // Конструктор
    public Room(int roomID, int hotelID, String roomNumber, String roomType, double price, boolean isAvailable) {
        this.roomID = roomID;
        this.hotelID = hotelID;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Геттеры для полей
    public int getRoomID() {
        return roomID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getRoomNumber() { // Добавил этот метод
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
