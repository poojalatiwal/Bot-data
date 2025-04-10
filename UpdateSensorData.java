package sigma_bot;

import java.util.Scanner;

public class UpdateSensorData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Sensor ID: ");
            int sensorId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Distance: ");
            float distance = sc.nextFloat();

            if (distance < 0) {
                System.out.println("Distance cannot be negative!");
                return;
            }

            SensorDataDAO sensorDataDAO = new SensorDataDAO();

            boolean flag = sensorDataDAO.updateSensorData(sensorId, distance);


            if (flag) {
                System.out.println("Sensor Data Record Updated Successfully");
            } else {
                System.out.println("Failed to Update Sensor Data Record");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
