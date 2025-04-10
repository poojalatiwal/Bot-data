package sigma_bot;
import java.util.Scanner;

public class SelectGesture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter Gesture ID: ");
        int gestureId = sc.nextInt();

        GestureDAO gestureDAO = new GestureDAO();
        Gesture gesture = gestureDAO.selectGesture(gestureId);


        if (gesture != null) {
            System.out.println("Gesture Details:");
            System.out.println("Gesture ID: " + gesture.getGestureId());
            System.out.println("Gesture Name: " + gesture.getGestureName());
            System.out.println("Command: " + gesture.getCommand());
            System.out.println("Created By: " + gesture.getCreatedBy());
            System.out.println("Created At: " + gesture.getCreatedAt());
        } else {
            System.out.println("No gesture found with ID: " + gestureId);
        }

        sc.close();
    }
}
