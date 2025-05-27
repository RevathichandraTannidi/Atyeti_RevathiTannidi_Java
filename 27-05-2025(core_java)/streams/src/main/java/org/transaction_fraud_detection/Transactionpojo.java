package org.transaction_fraud_detection;

import java.time.LocalDateTime;

public class Transactionpojo {
      String transactionId;
      String userId;
      double amount;
       static LocalDateTime timestamp;
              String location;

    public Transactionpojo(String transactionId, String userId, double amount, LocalDateTime timestamp, String location) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.location = location;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Transactionpojo{" +
                "transactionId='" + transactionId + '\'' +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                '}';
    }
}
