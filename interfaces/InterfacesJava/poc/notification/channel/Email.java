package poc.notification.channel;

public class Email implements Notification{
    @Override
    public void send(String recipient, String message) {
        if (!isValidRecipient(recipient)) return;

        logMessage(recipient, message);
    }
}
