import java.util.Date;

class Discount {
    private int discountID;
    private int hotelID;
    private double percent;
    private Date validUntil;

    public Discount(int discountID, int hotelID, double percent, Date validUntil) {
        this.discountID = discountID;
        this.hotelID = hotelID;
        this.percent = percent;
        this.validUntil = validUntil;
    }

    public int getDiscountID() {
        return discountID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public double getPercent() {
        return percent;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public boolean isValid() {
        return new Date().before(validUntil);
    }
}
