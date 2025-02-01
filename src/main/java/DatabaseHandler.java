import java.sql.*;

class DatabaseHandler {
    private static DatabaseHandler instance;
    private Connection connection;

    private static final String URL = "jdbc:postgresql://localhost:5432/my_project_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2006";

    private DatabaseHandler() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to PostgreSQL database!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public static synchronized DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void addHotel(Hotel hotel) {
        String query = "INSERT INTO hotels (id, name, location, rating) VALUES (DEFAULT, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, hotel.getName());
            statement.setString(2, hotel.getLocation());
            statement.setDouble(3, hotel.getRating());
            statement.executeUpdate();
            System.out.println("🏨 Hotel added to the database.");
        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при добавлении отеля: " + e.getMessage());
        }
    }

    public void addRoom(Room room) {
        String query = "INSERT INTO rooms (id, hotel_id, room_number, type, price) VALUES (DEFAULT, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, room.getHotelID());
            statement.setString(2, room.getRoomNumber());
            statement.setString(3, room.getRoomType());
            statement.setDouble(4, room.getPrice());
            statement.executeUpdate();
            System.out.println("🛏️ Room added to the database.");
        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при добавлении комнаты: " + e.getMessage());
        }
    }

    public void addCustomer(Customer customer) {
        // Проверка, существует ли уже этот email
        String checkQuery = "SELECT COUNT(*) FROM customers WHERE email = ?";
        String insertQuery = "INSERT INTO customers (id, name, email, phone) VALUES (DEFAULT, ?, ?, ?)";

        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
             PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {

            checkStmt.setString(1, customer.getEmail());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("⚠ Пользователь с email " + customer.getEmail() + " уже существует.");
                return;
            }

            insertStmt.setString(1, customer.getName());
            insertStmt.setString(2, customer.getEmail());
            insertStmt.setString(3, customer.getPhone());
            insertStmt.executeUpdate();
            System.out.println("👤 Customer added to the database.");

        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при добавлении клиента: " + e.getMessage());
        }
    }

    public void deleteCustomerByEmail(String email) {
        String query = "DELETE FROM customers WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("🗑 Customer deleted successfully.");
            } else {
                System.out.println("⚠ No customer found with email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при удалении клиента: " + e.getMessage());
        }
    }


    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (id, customer_id, room_id, check_in, check_out) VALUES (DEFAULT, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, booking.getCustomerID());
            statement.setInt(2, booking.getRoomID());
            statement.setDate(3, new java.sql.Date(booking.getCheckIn().getTime()));
            statement.setDate(4, new java.sql.Date(booking.getCheckOut().getTime()));
            statement.executeUpdate();
            System.out.println("📅 Booking added to the database.");
        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при добавлении бронирования: " + e.getMessage());
        }
    }

    public void addFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (id, customer_id, hotel_id, rating, comment) VALUES (DEFAULT, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, feedback.getCustomerID());
            statement.setInt(2, feedback.getHotelID());
            statement.setInt(3, feedback.getRating());
            statement.setString(4, feedback.getComment());
            statement.executeUpdate();
            System.out.println("📝 Feedback added to the database.");
        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при добавлении отзыва: " + e.getMessage());
        }
    }

    public void addDiscount(Discount discount) {
        String query = "INSERT INTO discounts (id, hotel_id, discount_percentage, valid_until) VALUES (DEFAULT, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, discount.getHotelID());
            statement.setDouble(2, discount.getPercent());
            statement.setDate(3, new java.sql.Date(discount.getValidUntil().getTime()));
            statement.executeUpdate();
            System.out.println("💰 Discount added to the database.");
        } catch (SQLException e) {
            System.out.println("⚠ Ошибка при добавлении скидки: " + e.getMessage());
        }
    }
}
