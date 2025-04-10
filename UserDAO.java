package sigma_bot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SIGMA";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "pooja@123";

    public boolean insertUser(String username, String password, String email) {
        boolean result = true;
        String sql = "INSERT INTO Users (username, password, email) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);

            pstmt.executeUpdate();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

    public User selectUser(int userId) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"), // Added password field
                        rs.getTimestamp("created_at")
                );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"), // Added password field
                        rs.getTimestamp("created_at")
                );
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(int userId, String username, String email) {
        boolean result = true;
        String sql = "UPDATE Users SET username = ?, email = ? WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setInt(3, userId);

            pstmt.executeUpdate();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

    public boolean deleteUser(int userId) {
        boolean result = true;
        String sql = "DELETE FROM Users WHERE user_id = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }
}
