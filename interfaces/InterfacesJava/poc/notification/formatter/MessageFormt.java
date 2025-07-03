package poc.notification.formatter;

@FunctionalInterface
public interface MessageFormt {
    String format(String content);
}
