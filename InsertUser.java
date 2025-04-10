package sigma_bot;
import java.util.Scanner;

public class InsertUser {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();

            UserDAO userDAO = new UserDAO();
            boolean flag = userDAO.insertUser(username, password, email);

            if (flag)
                System.out.println("User record inserted successfully.");
            else
                System.out.println("Failed to insert user record.");
        }
    }


