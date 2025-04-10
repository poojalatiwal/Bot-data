package sigma_bot;
import java.util.Scanner;

public class UpdateUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); // Consume the newline left by nextInt()

        System.out.print("Enter New Username: ");
        String username = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        UserDAO userDAO = new UserDAO();
        boolean flag = userDAO.updateUser(userId, username, email);

        if (flag)
            System.out.println("Record Updated Successfully");
        else
            System.out.println("Failed to Update Record");
    }
}
