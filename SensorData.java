package sigma_bot;
import java.sql.Timestamp;

public class SensorData {

        private int sensorId;
        private float distance;
        private Timestamp timestamp;
        private int userId;

        // Constructor
        public SensorData(int sensorId, float distance, Timestamp timestamp, int userId) {
            this.sensorId = sensorId;
            this.distance = distance;
            this.timestamp = timestamp;
            this.userId = userId;
        }

        // Getters and Setters
        public int getSensorId() {
            return sensorId;
        }

        public void setSensorId(int sensorId) {
            this.sensorId = sensorId;
        }

        public float getDistance() {
            return distance;
        }

        public void setDistance(float distance) {
            this.distance = distance;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        // Override toString method
        @Override
        public String toString() {
            return "SensorData{" +
                    "sensorId=" + sensorId +
                    ", distance=" + distance +
                    ", timestamp=" + timestamp +
                    ", userId=" + userId +
                    '}';
        }
    }



