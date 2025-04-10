package sigma_bot;
import java.util.Scanner;

public class UpdateGesture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Gesture ID: ");
        int gestureId = sc.nextInt();
        sc.nextLine(); // Consume the newline left by nextInt()

        System.out.print("Enter New Gesture Name: ");
        String gestureName = sc.nextLine();

        System.out.print("Enter New Gesture Description: ");
        String gestureDescription = sc.nextLine();

        GestureDAO gestureDAO = new GestureDAO();
        boolean flag = gestureDAO.updateGesture(gestureId, gestureName, gestureDescription);

        if (flag)
            System.out.println("Record Updated Successfully");
        else
            System.out.println("Failed to Update Record");
    }
}


