package sigma_bot;
import java.util.List;

public class SelectAllBotMovement {

        public static void main(String[] args) {
            BotMovementDAO botMovementDAO = new BotMovementDAO();

            // Fetch all bot movements
            List<BotMovement> botMovements = botMovementDAO.selectAllBotMovements();

            // Print the fetched records
            System.out.println("Bot Movement Records:");
            for (BotMovement movement : botMovements) {
                System.out.println("Movement ID: " + movement.getMovementId() +
                        ", Gesture ID: " + movement.getGestureId() +
                        ", Timestamp: " + movement.getTimestamp() +
                        ", Status: " + movement.getStatus());
            }
        }
    }


