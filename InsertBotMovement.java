package sigma_bot;
import java.util.Scanner;

public class InsertBotMovement {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter gesture ID: ");
            int gestureId = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter status: ");
            String status = sc.nextLine();

            BotMovementDAO botMovementDAO = new BotMovementDAO();
            boolean flag = botMovementDAO.insertBotMovement(gestureId, status);

            if (flag)
                System.out.println("Bot movement record inserted successfully.");
            else
                System.out.println("Failed to insert bot movement record.");
        }
    }


