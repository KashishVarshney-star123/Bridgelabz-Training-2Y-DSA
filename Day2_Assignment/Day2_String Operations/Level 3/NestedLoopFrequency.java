import java.util.Scanner;
public class NestedLoopFrequency {
    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            freq[i] = 1;
            if (chars[i] == '0') continue;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }
        int uniqueCount = 0;
        for (char c : chars) if (c != '0') uniqueCount++;
        String[] result = new String[uniqueCount];
        int k = 0;
        char[] original = text.toCharArray(); 
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[k++] = original[i] + " - " + freq[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();
        String[] frequencies = findFrequency(input);
        for (String s : frequencies) {
            System.out.println(s);
        }
    }
}