package sigma_bot;
import java.util.Scanner;
public class DeleteBotMovement {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter bot movement ID to delete: ");
            int movementId = sc.nextInt();

            BotMovementDAO botMovementDAO = new BotMovementDAO();
            boolean flag = botMovementDAO.deleteBotMovement(movementId);

            if (flag)
                System.out.println("Bot movement record deleted successfully.");
            else
                System.out.println("Unable to delete bot movement record.");
        }
    }


