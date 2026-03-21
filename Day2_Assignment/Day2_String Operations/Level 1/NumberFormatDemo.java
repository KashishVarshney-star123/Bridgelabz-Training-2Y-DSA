import java.util.Scanner;

public class NumberFormatDemo {
    public static void triggerError(String text) {
        int num = Integer.parseInt(text);
        System.out.println("Parsed number: " + num);
    }
    public static void handleFormatError(String text) {
        try {
            int num = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Caught: The input '" + text + "' is not a valid integer.");
        } catch (Exception e) {
            System.out.println("Generic error caught.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter something that isn't a number: ");
        String input = sc.next();
        handleFormatError(input);
    }
}