import java.util.Scanner;
public class TrimSpaces {
    public static int[] findBounds(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }
    public static String customTrim(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] bounds = findBounds(text);
        String custom = customTrim(text, bounds[0], bounds[1]);
        String builtin = text.trim();
        System.out.println("Custom Trim: " + custom);
        System.out.println("Built-in Trim: " + builtin);
    }
}