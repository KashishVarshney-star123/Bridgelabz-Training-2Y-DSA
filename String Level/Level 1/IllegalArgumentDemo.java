import java.util.Scanner;
public class IllegalArgumentDemo {
    public static void generateException(String str) {
        System.out.println(str.substring(5, 2));
    }
    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled!");
        } catch (Exception e) {
            System.out.println("General exception handled!");
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