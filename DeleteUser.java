package sigma_bot;
import java.util.Scanner;

public class DeleteUser {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter user ID to delete: ");
            int userId = sc.nextInt();

            UserDAO userDAO = new UserDAO();
            boolean flag = userDAO.deleteUser(userId);

            if (flag)
                System.out.println("User record deleted successfully.");
            else
                System.out.println("Unable to delete user record.");
        }
    }


