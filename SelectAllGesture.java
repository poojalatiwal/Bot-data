package sigma_bot;
import java.util.List;

public class SelectAllGesture {

        public static void main(String[] args) {
            GestureDAO gestureDAO = new GestureDAO();
            List<Gesture> gestures = gestureDAO.selectAllGestures();

            for (Gesture gesture : gestures) {
                System.out.println("Gesture ID: " + gesture.getGestureId() +
                        ", Gesture Name: " + gesture.getGestureName() +
                        ", Command: " + gesture.getCommand() +
                        ", Created By: " + gesture.getCreatedBy() +
                        ", Created At: " + gesture.getCreatedAt());
            }
        }
    }



