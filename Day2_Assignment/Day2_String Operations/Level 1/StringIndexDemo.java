import java.util.Scanner;

public class StringIndexDemo {
    public static void triggerError(String text) {
        System.out.println("Accessing invalid index...");
        char c = text.charAt(text.length() + 1);
    }
    public static void handleIndexError(String text) {
        try {
            char c = text.charAt(100); 
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught: Index is outside the String's range.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String text = sc.next();
        handleIndexError(text);
    }
}