import java.util.Scanner;
public class ArrayIndexOutOfBoundsDemo {
    public static void generateException(String[] arr) {
        System.out.println(arr[arr.length]);
    }
    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception handled: Invalid array index!");
        } catch (Exception e) {
            System.out.println("General exception handled!");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        try {
            generateException(arr);
        } catch (Exception e) {
            System.out.println("Exception occurred!");
        }
        handleException(arr);
    }
}