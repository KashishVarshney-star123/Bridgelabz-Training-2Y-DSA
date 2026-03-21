import java.util.Scanner;
public class CharFrequency {
    public static String[][] getFrequency(String text) {
        int[] count = new int[256];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i)]++;
        }
        String[][] report = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            report[i][0] = String.valueOf(ch);
            report[i][1] = String.valueOf(count[ch]);
        }
        return report;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        String[][] result = getFrequency(input);
        System.out.println("\nChar | Frequency");
        for (String[] row : result) {
            System.out.println(row[0] + "    | " + row[1]);
        }
    }
}