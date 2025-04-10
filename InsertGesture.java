package sigma_bot;

import java.util.Scanner;

public class InsertGesture {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter gesture name: ");
            String gestureName = sc.nextLine();
            System.out.print("Enter command: ");
            String command = sc.nextLine();
            System.out.print("Enter creator's user ID: ");
            int createdBy = sc.nextInt();

            GestureDAO gestureDAO = new GestureDAO();
            boolean flag = gestureDAO.insertGesture(gestureName, command, createdBy);

            if (flag)
                System.out.println("Gesture record inserted successfully.");
            else
                System.out.println("Failed to insert gesture record.");
        }
    }



