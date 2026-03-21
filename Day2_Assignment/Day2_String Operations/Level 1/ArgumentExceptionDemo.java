public class ArgumentExceptionDemo {
    public static void triggerError(String text) {
        text.substring(5, 2);
    }
    public static void handleArgumentError(String text) {
        try {
            text.substring(10, 5);
        } catch (StringIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Caught: The start index cannot be larger than the end index.");
        } catch (RuntimeException e) {
            System.out.println("Caught a generic Runtime Exception.");
        }
    }
    public static void main(String[] args) {
        String data = "Hello";
        handleArgumentError(data);
    }
}