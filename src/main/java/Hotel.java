class Hotel {
    private int hotelID;
    private String name;
    private String location;
    private double rating;

    public Hotel(int hotelID, String name, String location, double rating) {
        this.hotelID = hotelID;
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }
}