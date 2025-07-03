package poc.notification.channel;

import poc.notification.formatter.MessageFormt;

public interface Notification {

    void send(String recipient, String message);

      default boolean isValidRecipient(String recipient) {
      return recipient != null && !recipient.trim().isEmpty();
      }

      default void logMessage(String recipient, String message) {
         System.out.println("Sent to " + recipient + ": " + message);
    }


    static Notification getDefault() {
        return new Email();
    }


    default void sendFormatted(String recipient, String rawMessage, MessageFormt formatter) {
        if (!isValidRecipient(recipient)) {
            System.out.println("Invalid recipient.");
            return;
        }
        String formatted = formatter.format(rawMessage);
        send(recipient, formatted);
        logMessage(recipient, formatted);
    }
}