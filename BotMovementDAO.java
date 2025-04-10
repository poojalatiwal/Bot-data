package sigma_bot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BotMovementDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SIGMA";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "pooja@123";

    public boolean insertBotMovement(int gestureId, String status) {
        boolean result = true;
        String sql = "INSERT INTO BotMovements (gesture_id, status) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, gestureId);
            pstmt.setString(2, status);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

    public BotMovement selectBotMovement(int movementId) {
        BotMovement botMovement = null;
        String sql = "SELECT * FROM BotMovements WHERE movement_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, movementId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    botMovement = new BotMovement(rs.getInt("movement_id"),
                            rs.getInt("gesture_id"),
                            rs.getTimestamp("timestamp"),
                            rs.getString("status"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return botMovement;
    }

    public List<BotMovement> selectAllBotMovements() {
        List<BotMovement> botMovements = new ArrayList<>();
        String sql = "SELECT * FROM BotMovements";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BotMovement botMovement = new BotMovement(rs.getInt("movement_id"),
                        rs.getInt("gesture_id"),
                        rs.getTimestamp("timestamp"),
                        rs.getString("status"));
                botMovements.add(botMovement);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return botMovements;
    }

    public boolean updateBotMovement(int movementId, String status) {
        boolean result = true;
        String sql = "UPDATE BotMovements SET status = ? WHERE movement_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, movementId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

    public boolean deleteBotMovement(int movementId) {
        boolean result = true;
        String sql = "DELETE FROM BotMovements WHERE movement_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, movementId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }
}
