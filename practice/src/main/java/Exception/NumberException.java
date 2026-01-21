package Exception;

public class NumberException {
    public static int parse(String s)
    {
        try
        {
           return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
}
