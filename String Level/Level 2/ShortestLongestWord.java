import java.util.Scanner;
public class ShortestLongestWord {
    public static String[] splitCustom(String str) {
        return str.split(" ");
    }
    public static String[] findMinMax(String[] words) {
        String min = words[0];
        String max = words[0];
        for (String word : words) {
            if (word.length() < min.length()) {
                min = word;
            }
            if (word.length() > max.length()) {
                max = word;
            }
        }
        return new String[]{min, max};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitCustom(text);
        String[] result = findMinMax(words);
        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
    }
}