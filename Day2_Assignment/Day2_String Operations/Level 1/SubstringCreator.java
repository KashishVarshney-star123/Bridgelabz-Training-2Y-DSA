import java.util.Scanner;

public class SubstringCreator {
    public static String manualSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text, start index, and end index: ");
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String manual = manualSubstring(text, start, end);
        String builtIn = text.substring(start, end);
        System.out.println("Manual: " + manual + " | Built-in: " + builtIn);
        System.out.println("Results Match: " + manual.equals(builtIn));
    }
}