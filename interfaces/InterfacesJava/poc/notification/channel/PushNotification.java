package poc.notification.channel;

public class PushNotification implements Notification{
        @Override
        public void send(String recipient, String message) {
            if (!isValidRecipient(recipient)) return;

            logMessage(recipient, message);
        }
}
