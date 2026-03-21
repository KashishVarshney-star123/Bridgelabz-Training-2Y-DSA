import java.util.Scanner;
public class UppercaseConverter {
    public static String toManualUpper(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        String manual = toManualUpper(input);
        String builtIn = input.toUpperCase();
        System.out.println("Manual: " + manual);
        System.out.println("Match Built-in: " + manual.equals(builtIn));
    }
}