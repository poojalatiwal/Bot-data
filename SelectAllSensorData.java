package sigma_bot;
import java.util.List;

public class SelectAllSensorData {

        public static void main(String[] args) {
            SensorDataDAO sensorDataDAO = new SensorDataDAO();

            // Fetch all sensor data records
            List<SensorData> sensorDataList = sensorDataDAO.selectAllSensorData();

            // Print the fetched records
            System.out.println("Sensor Data Records:");
            for (SensorData data : sensorDataList) {
                System.out.println("Sensor ID: " + data.getSensorId() +
                        ", Distance: " + data.getDistance() +
                        ", Timestamp: " + data.getTimestamp() +
                        ", User ID: " + data.getUserId());
            }
        }
    }


