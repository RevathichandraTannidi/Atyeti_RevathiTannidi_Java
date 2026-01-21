package Exception;

public class MainString {
    public static void main(String[] args) {
        System.out.println(method3());
    }
    public static StringBuilder method3() {
        StringBuilder sb = new StringBuilder("Hello");
        try {
            return sb;
        } finally {
            sb.append(" World");
        }
    }
}
