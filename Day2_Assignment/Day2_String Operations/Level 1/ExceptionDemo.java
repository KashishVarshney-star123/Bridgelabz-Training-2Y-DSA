public class ExceptionDemo {
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }
    public static void handleException() {
        try {
            String text = null;
            System.out.println(text.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("Caught an Exception: You cannot call methods on a null string!");
        }
    }

    public static void main(String[] args) {
        handleException();
    }
}