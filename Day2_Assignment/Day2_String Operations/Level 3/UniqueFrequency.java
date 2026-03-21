import java.util.Scanner;
public class UniqueFrequency {
    public static char[] getUniqueChars(String text) {
        String unique = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == ch) { exists = true; break; }
            }
            if (!exists) unique += ch;
        }
        return unique.toCharArray();
    }
    public static String[][] getUniqueFrequencyReport(String text) {
        int[] freqMap = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freqMap[text.charAt(i)]++;
        }
        char[] uniques = getUniqueChars(text);
        String[][] result = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            result[i][0] = String.valueOf(uniques[i]);
            result[i][1] = String.valueOf(freqMap[uniques[i]]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[][] report = getUniqueFrequencyReport(input);
        System.out.println("\nUnique Character Frequencies:");
        for (String[] row : report) {
            System.out.println("'" + row[0] + "': " + row[1]);
        }
    }
}