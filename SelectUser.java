package sigma_bot;
import java.util.Scanner;

public class SelectUser {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter User ID: ");
            int userId = sc.nextInt();

            UserDAO userDAO = new UserDAO();
            User user = userDAO.selectUser(userId);

            if (user != null) {
                System.out.println("User ID: " + user.getUserId() +
                        ", Username: " + user.getUsername() +
                        ", Email: " + user.getEmail() +
                        ", Created At: " + user.getCreatedAt());
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        }
    }


