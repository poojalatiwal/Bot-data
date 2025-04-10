package sigma_bot;
import java.util.Scanner;

public class InsertSensorData {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter distance: ");
            float distance = sc.nextFloat();
            System.out.print("Enter user ID: ");
            int userId = sc.nextInt();

            SensorDataDAO sensorDataDAO = new SensorDataDAO();
            boolean flag = sensorDataDAO.insertSensorData(distance, userId);

            if (flag)
                System.out.println("Sensor data record inserted successfully.");
            else
                System.out.println("Failed to insert sensor data record.");
        }
    }


