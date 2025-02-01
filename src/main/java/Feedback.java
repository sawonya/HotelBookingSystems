class Feedback {
    private int feedbackID;
    private int customerID;
    private int hotelID;
    private int rating;
    private String comment;

    public Feedback(int feedbackID, int customerID, int hotelID, int rating, String comment) {
        this.feedbackID = feedbackID;
        this.customerID = customerID;
        this.hotelID = hotelID;
        this.rating = rating;
        this.comment = comment;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}