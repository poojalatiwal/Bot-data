package sigma_bot;
import java.sql.Timestamp;
public class BotMovement {

        private int movementId;
        private int gestureId;
        private Timestamp timestamp;
        private String status;

        // Constructor
        public BotMovement(int movementId, int gestureId, Timestamp timestamp, String status) {
            this.movementId = movementId;
            this.gestureId = gestureId;
            this.timestamp = timestamp;
            this.status = status;
        }

        // Getters and Setters
        public int getMovementId() {
            return movementId;
        }

        public void setMovementId(int movementId) {
            this.movementId = movementId;
        }

        public int getGestureId() {
            return gestureId;
        }

        public void setGestureId(int gestureId) {
            this.gestureId = gestureId;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        // Override toString method
        @Override
        public String toString() {
            return "BotMovement{" +
                    "movementId=" + movementId +
                    ", gestureId=" + gestureId +
                    ", timestamp=" + timestamp +
                    ", status='" + status + '\'' +
                    '}';
        }
    }


