import java.util.Arrays;
import java.util.Scanner;

public class ManualSplit {
    public static String[] mySplit(String text) {
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }
        String[] words = new String[spaceCount + 1];
        int wordIndex = 0;
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                currentWord.append(text.charAt(i));
            } else {
                words[wordIndex++] = currentWord.toString();
                currentWord.setLength(0);
            }
        }
        words[wordIndex] = currentWord.toString();
        return words;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();
        String[] manual = mySplit(input);
        String[] builtIn = input.split(" ");
        System.out.println("Match: " + Arrays.equals(manual, builtIn));
    }
}
