package sigma_bot;
import java.sql.Timestamp;

public class Gesture {
      private int gestureId;
        private String gestureName;
        private String command;
        private int createdBy;
        private Timestamp createdAt;

        // Constructor
        public Gesture(int gestureId, String gestureName, String command, int createdBy, Timestamp createdAt) {
            this.gestureId = gestureId;
            this.gestureName = gestureName;
            this.command = command;
            this.createdBy = createdBy;
            this.createdAt = createdAt;
        }

        // Getters and Setters
        public int getGestureId() {
            return gestureId;
        }

        public void setGestureId(int gestureId) {
            this.gestureId = gestureId;
        }

        public String getGestureName() {
            return gestureName;
        }

        public void setGestureName(String gestureName) {
            this.gestureName = gestureName;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public int getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public Timestamp getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Timestamp createdAt) {
            this.createdAt = createdAt;
        }

        // Override toString method
        @Override
        public String toString() {
            return "Gesture{" +
                    "gestureId=" + gestureId +
                    ", gestureName='" + gestureName + '\'' +
                    ", command='" + command + '\'' +
                    ", createdBy=" + createdBy +
                    ", createdAt=" + createdAt +
                    '}';
        }
    }


