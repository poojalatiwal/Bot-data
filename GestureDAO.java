package sigma_bot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestureDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SIGMA";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "pooja@123";


    public boolean insertGesture(String gestureName, String command, int createdBy) {
        boolean result = true;
        String sql = "INSERT INTO Gestures (gesture_name, command, created_by) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, gestureName);
            pstmt.setString(2, command);
            pstmt.setInt(3, createdBy);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }


    public Gesture selectGesture(int gestureId) {
        Gesture gesture = null;
        String sql = "SELECT * FROM Gestures WHERE gesture_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, gestureId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    gesture = new Gesture(
                            rs.getInt("gesture_id"),
                            rs.getString("gesture_name"),
                            rs.getString("command"),
                            rs.getInt("created_by"),
                            rs.getTimestamp("created_at")
                    );
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gesture;
    }


    public List<Gesture> selectAllGestures() {
        List<Gesture> gestures = new ArrayList<>();
        String sql = "SELECT * FROM Gestures";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gesture gesture = new Gesture(
                        rs.getInt("gesture_id"),
                        rs.getString("gesture_name"),
                        rs.getString("command"),
                        rs.getInt("created_by"),
                        rs.getTimestamp("created_at")
                );
                gestures.add(gesture);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gestures;
    }


    public boolean updateGesture(int gestureId, String gestureName, String command) {
        boolean result = true;
        String sql = "UPDATE Gestures SET gesture_name = ?, command = ? WHERE gesture_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, gestureName);
            pstmt.setString(2, command);
            pstmt.setInt(3, gestureId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }


    public boolean deleteGesture(int gestureId) {
        boolean result = true;
        String sql = "DELETE FROM Gestures WHERE gesture_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, gestureId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }
}
