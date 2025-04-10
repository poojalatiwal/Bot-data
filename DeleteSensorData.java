package sigma_bot;
import java.util.Scanner;

public class DeleteSensorData {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter sensor data ID to delete: ");
            int sensorId = sc.nextInt();

            SensorDataDAO sensorDataDAO = new SensorDataDAO();
            boolean flag = sensorDataDAO.deleteSensorData(sensorId);

            if (flag)
                System.out.println("Sensor data record deleted successfully.");
            else
                System.out.println("Unable to delete sensor data record.");
        }
    }


