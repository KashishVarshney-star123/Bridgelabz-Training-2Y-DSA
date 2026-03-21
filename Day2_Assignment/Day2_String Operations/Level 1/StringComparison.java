import java.util.Scanner;

public class StringComparison {
    public static boolean manualEquals(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two words: ");
        String str1 = sc.next();
        String str2 = sc.next();
        boolean manualResult = manualEquals(str1, str2);
        boolean builtInResult = str1.equals(str2);
        System.out.println("Manual Match: " + manualResult);
        System.out.println("Built-in Match: " + builtInResult);
    }
}