package sigma_bot;
import java.util.Scanner;

public class DeleteGesture {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter gesture ID to delete: ");
            int gestureId = sc.nextInt();

            GestureDAO gestureDAO = new GestureDAO();
            boolean flag = gestureDAO.deleteGesture(gestureId);

            if (flag)
                System.out.println("Gesture record deleted successfully.");
            else
                System.out.println("Unable to delete gesture record.");
        }
    }


