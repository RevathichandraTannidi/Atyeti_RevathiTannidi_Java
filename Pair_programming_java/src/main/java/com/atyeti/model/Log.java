package com.atyeti.model;


    import java.time.Instant;
    import java.time.LocalDateTime;

public class Log{

        private LocalDateTime timestamp;
        private String level;
        private String message;

        public Log(LocalDateTime timestamp, String level, String message) {
            this.timestamp = timestamp;
            this.level = level;
            this.message = message;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "timestamp=" + timestamp + ", level='" + level + ", message='" + message;
        }
    }

