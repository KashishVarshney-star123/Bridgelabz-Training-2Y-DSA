import java.util.Scanner;
public class SubstringProgram {
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    public static boolean compareStrings(String s1, String s2) {
        return s1.equals(s2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String custom = customSubstring(str, start, end);
        String builtin = str.substring(start, end);
        System.out.println("Custom Substring: " + custom);
        System.out.println("Built-in Substring: " + builtin);
        System.out.println("Are equal: " + compareStrings(custom, builtin));
    }
}