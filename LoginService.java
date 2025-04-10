package sigma_bot;

import java.util.Scanner;

public class LoginService {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== LOGIN SYSTEM =====");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. View All Users");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1 -> registerUser(userDAO, scanner);
            case 2 -> loginUser(userDAO, scanner);
            case 3 -> viewAllUsers(userDAO);
            default -> System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }

    // Method for user registration
    private static void registerUser(UserDAO userDAO, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        boolean success = userDAO.insertUser(username, password, email);
        if (success) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Failed to register. Please try again.");
        }
    }

    // Method for user login
    private static void loginUser(UserDAO userDAO, Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Validate the user's credentials
        User user = userDAO.selectAllUsers().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (user != null) {
            System.out.println("Login successful! Welcome, " + username + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    // Method to view all registered users
    private static void viewAllUsers(UserDAO userDAO) {
        System.out.println("===== ALL REGISTERED USERS =====");
        for (User user : userDAO.selectAllUsers()) {
            System.out.println("ID: " + user.getUserId() + ", Username: " + user.getUsername() + ", Email: " + user.getEmail());
        }
    }
}
