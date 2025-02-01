import java.util.Date;
import java.sql.*;
import java.util.*;

class Notification {
    private int notificationID;
    private String message;
    private int customerID;
    private Date sentDate;

    public Notification(int notificationID, String message, int customerID, Date sentDate) {
        this.notificationID = notificationID;
        this.message = message;
        this.customerID = customerID;
        this.sentDate = sentDate;
    }

    public void sendNotification() {
        System.out.println("Notification sent to customer ID " + customerID + ": " + message);
    }

    public int getNotificationID() {
        return notificationID;
    }

    public String getMessage() {
        return message;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Date getSentDate() {
        return sentDate;
    }
}

