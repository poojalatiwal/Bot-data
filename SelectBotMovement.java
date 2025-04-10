package sigma_bot;
import java.util.Scanner;

public class SelectBotMovement {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Movement ID: ");
            int movementId = sc.nextInt();

            BotMovementDAO botMovementDAO = new BotMovementDAO();
            BotMovement botMovement = botMovementDAO.selectBotMovement(movementId);

            if (botMovement != null) {
                System.out.println("Movement ID: " + botMovement.getMovementId() +
                        ", Gesture ID: " + botMovement.getGestureId() +
                        ", Timestamp: " + botMovement.getTimestamp() +
                        ", Status: " + botMovement.getStatus());
            } else {
                System.out.println("No bot movement found with ID: " + movementId);
            }
        }
    }


