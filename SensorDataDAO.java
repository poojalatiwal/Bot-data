package sigma_bot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SensorDataDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/SIGMA";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "pooja@123";


    public boolean insertSensorData(float distance, int userId) {
        boolean result = true;
        String sql = "INSERT INTO SensorData (distance, user_id) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setFloat(1, distance);
            pstmt.setInt(2, userId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }


    public SensorData selectSensorData(int sensorId) {
        SensorData sensorData = null;
        String sql = "SELECT * FROM SensorData WHERE sensor_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, sensorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    sensorData = new SensorData(
                            rs.getInt("sensor_id"),
                            rs.getFloat("distance"),
                            rs.getTimestamp("timestamp"),
                            rs.getInt("user_id")
                    );
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sensorData;
    }


    public List<SensorData> selectAllSensorData() {
        List<SensorData> sensorDataList = new ArrayList<>();
        String sql = "SELECT * FROM SensorData";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SensorData sensorData = new SensorData(
                        rs.getInt("sensor_id"),
                        rs.getFloat("distance"),
                        rs.getTimestamp("timestamp"),
                        rs.getInt("user_id")
                );
                sensorDataList.add(sensorData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return sensorDataList;
    }



    public boolean updateSensorData(int sensorId, float distance) {
        boolean result = true;
        String sql = "UPDATE SensorData SET distance = ? WHERE sensor_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setFloat(1, distance);
            pstmt.setInt(2, sensorId);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }

    public boolean deleteSensorData(int sensorId) {
        boolean result = true;
        String sql = "DELETE FROM SensorData WHERE sensor_id = ?";

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, sensorId);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        }
        return result;
    }
}
