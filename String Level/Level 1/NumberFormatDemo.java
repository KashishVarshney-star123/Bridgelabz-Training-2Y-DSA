import java.util.Scanner;
public class NumberFormatDemo {
    public static void generateException(String input) {
        int num = Integer.parseInt(input);
        System.out.println(num);
    }
    public static void handleException(String input) {
        try {
            int num = Integer.parseInt(input);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled!");
        } catch (Exception e) {
            System.out.println("General exception handled!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception occurred!");
        }
        handleException(input);
    }
}