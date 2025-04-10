package sigma_bot;
import java.util.Scanner;

public class SelectSensorData {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Sensor ID: ");
            int sensorId = sc.nextInt();

            SensorDataDAO sensorDataDAO = new SensorDataDAO();
            SensorData sensorData = sensorDataDAO.selectSensorData(sensorId);

            if (sensorData != null) {
                System.out.println("Sensor ID: " + sensorData.getSensorId() +
                        ", Distance: " + sensorData.getDistance() +
                        ", Timestamp: " + sensorData.getTimestamp() +
                        ", User ID: " + sensorData.getUserId());
            } else {
                System.out.println("No sensor data found with ID: " + sensorId);
            }
        }
    }


