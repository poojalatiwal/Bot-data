package sigma_bot;
import java.util.List;

public class SelectAllUser {

        public static void main(String[] args) {
            UserDAO userDAO = new UserDAO( );
            List<User> users = userDAO.selectAllUsers();

            for (User user : users) {
                System.out.println("User ID: " + user.getUserId() +
                        ", Username: " + user.getUsername() +
                        ", Email: " + user.getEmail() +
                        ", Created At: " + user.getCreatedAt());
            }
        }
    }


