import java.util.Scanner;
public class StringExtremes {
    public static String[] manualSplit(String text) {
        int count = 1;
        for (int i = 0; i < text.length(); i++) if (text.charAt(i) == ' ') count++;
        String[] words = new String[count];
        String temp = "";
        int idx = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') temp += text.charAt(i);
            else { words[idx++] = temp; temp = ""; }
        }
        words[idx] = temp;
        return words;
    }
    public static String[][] getWordMatrix(String[] words) {
        String[][] matrix = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            matrix[i][0] = words[i];
            matrix[i][1] = String.valueOf(words[i].length());
        }
        return matrix;
    }
    public static int[] findExtremes(String[][] matrix) {
        int shortestIdx = 0, longestIdx = 0;
        for (int i = 1; i < matrix.length; i++) {
            int currentLen = Integer.parseInt(matrix[i][1]);
            if (currentLen < Integer.parseInt(matrix[shortestIdx][1])) shortestIdx = i;
            if (currentLen > Integer.parseInt(matrix[longestIdx][1])) longestIdx = i;
        }
        return new int[]{shortestIdx, longestIdx};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        String[][] matrix = getWordMatrix(manualSplit(input));
        int[] result = findExtremes(matrix);
        System.out.println("Shortest: " + matrix[result[0]][0]);
        System.out.println("Longest: " + matrix[result[1]][0]);
    }
}