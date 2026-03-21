import java.util.Scanner;
public class LowercaseConverter {
    public static String toManualLower(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        String manual = toManualLower(input);
        String builtIn = input.toLowerCase();
        System.out.println("Manual: " + manual);
        System.out.println("Match Built-in: " + manual.equals(builtIn));
    }
}