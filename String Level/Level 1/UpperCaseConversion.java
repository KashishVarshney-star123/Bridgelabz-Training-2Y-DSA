import java.util.Scanner;
public class UpperCaseConversion {
    public static String toUpperCustom(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }
            result += ch;
        }
        return result;
    }
    public static boolean compareStrings(String s1, String s2) {
        return s1.equals(s2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String custom = toUpperCustom(text);
        String builtin = text.toUpperCase();
        System.out.println("Custom: " + custom);
        System.out.println("Built-in: " + builtin);
        System.out.println("Are equal: " + compareStrings(custom, builtin));
    }
}