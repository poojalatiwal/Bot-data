package sigma_bot;

import java.util.Scanner;

public class UpdateBotMovement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Prompt for Movement ID
            System.out.print("Enter Movement ID: ");
            int movementId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Status (e.g., ACTIVE, INACTIVE): ");
            String status = sc.nextLine();

            if (status.isEmpty()) {
                System.out.println("Status cannot be empty!");
                return;
            }

            BotMovementDAO botMovementDAO = new BotMovementDAO();

            boolean flag = botMovementDAO.updateBotMovement(movementId, status);

            if (flag) {
                System.out.println("Bot Movement Record Updated Successfully");
            } else {
                System.out.println("Failed to Update Bot Movement Record");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
