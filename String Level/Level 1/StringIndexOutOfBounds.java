import java.util.Scanner;
public class StringIndexOutOfBounds{
    public static void generateException(String str) {
        System.out.println(str.charAt(str.length()));
    }
    public static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception handled: Invalid index!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        try {
            generateException(str);
        } catch (Exception e) {
            System.out.println("Exception occurred!");
        }
        handleException(str);
    }
}