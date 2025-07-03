package poc.notification;

import poc.notification.channel.Notification;
import poc.notification.channel.PushNotification;
import poc.notification.channel.Sms;
import poc.notification.formatter.MessageFormt;

public class Main {
    public static void main(String[] args) {
        Notification email = Notification.getDefault();
          Notification sms = new Sms();

        MessageFormt urgent = msg -> "the msg is urgent " + msg;
          MessageFormt friendly = msg -> "hi somi how are you " + msg;

        String recipient = "revathi.tannidi@atyeti,com";
           String message = "message are pushed via email.";
           String msg1="message are pushed via sms";
         email.send(recipient, message);
              sms.sendFormatted("8796960709", msg1, urgent);

          Notification push = new PushNotification();
        push.sendFormatted("someswari", "hi, how,what..", friendly);
    }
}
