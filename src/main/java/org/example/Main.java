import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler db = DatabaseHandler.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Hotel Booking System =====");
            System.out.println("1. Add Hotel");
            System.out.println("2. Add Room");
            System.out.println("3. Add Customer");
            System.out.println("4. Add Booking");
            System.out.println("5. Add Feedback");
            System.out.println("6. Add Discount");
            System.out.println("7. Delete Customer by Email");
            System.out.println("8. Admin Actions");
            System.out.println("9. Exit");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название отеля: ");
                    String hotelName = scanner.nextLine();
                    System.out.print("Введите местоположение отеля: ");
                    String location = scanner.nextLine();
                    System.out.print("Введите рейтинг отеля (0-5): ");
                    double rating = scanner.nextDouble();
                    db.addHotel(new Hotel(0, hotelName, location, rating));
                    break;

                case 2:
                    System.out.print("Введите ID отеля: ");
                    int hotelID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите номер комнаты: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Введите тип комнаты: ");
                    String roomType = scanner.nextLine();
                    System.out.print("Введите цену за ночь: ");
                    double price = scanner.nextDouble();
                    db.addRoom(new Room(0, hotelID, roomNumber, roomType, price, true));
                    break;

                case 3:
                    System.out.print("Введите имя клиента: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Введите email клиента: ");
                    String email = scanner.nextLine();
                    System.out.print("Введите телефон клиента: ");
                    String phone = scanner.nextLine();
                    db.addCustomer(new RegularCustomer(0, customerName, email, phone));
                    break;

                case 4:
                    System.out.print("Введите ID клиента: ");
                    int customerID = scanner.nextInt();
                    System.out.print("Введите ID комнаты: ");
                    int roomID = scanner.nextInt();
                    System.out.print("Введите стоимость: ");
                    double totalPrice = scanner.nextDouble();
                    db.addBooking(new Booking(0, customerID, roomID, new Date(), new Date(), totalPrice));
                    break;

                case 5:
                    System.out.print("Введите ID клиента: ");
                    int feedbackCustomerID = scanner.nextInt();
                    System.out.print("Введите ID отеля: ");
                    int feedbackHotelID = scanner.nextInt();
                    System.out.print("Введите рейтинг (1-5): ");
                    int feedbackRating = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите комментарий: ");
                    String comment = scanner.nextLine();
                    db.addFeedback(new Feedback(0, feedbackCustomerID, feedbackHotelID, feedbackRating, comment));
                    break;

                case 6:
                    System.out.print("Введите ID отеля: ");
                    int discountHotelID = scanner.nextInt();
                    System.out.print("Введите скидку в %: ");
                    double discountPercentage = scanner.nextDouble();
                    db.addDiscount(new Discount(0, discountHotelID, discountPercentage, new Date(System.currentTimeMillis() + 86400000L)));
                    break;

                case 7:
                    System.out.print("Введите email клиента для удаления: ");
                    String deleteEmail = scanner.nextLine();
                    db.deleteCustomerByEmail(deleteEmail);
                    break;

                case 8:
                    Admin admin = new Admin(1, "Alice", "alice@example.com", "1234567890", "Manager");
                    admin.viewDetails();
                    System.out.print("Введите действие (manage/update): ");
                    String adminAction = scanner.nextLine();
                    admin.manageHotel(new Hotel(1, "Grand Hotel", "New York", 4.5), adminAction);
                    admin.manageBookings();
                    break;

                case 9:
                    System.out.println("✅ Выход из программы...");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠ Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
