import java.util.Scanner;

public class CharTypeTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String input = sc.nextLine();
        String[][] report = new String[input.length()][2];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            report[i][0] = String.valueOf(c);
            report[i][1] = VowelConsonantCounter.checkChar(c);
        }
        System.out.println("\nCHAR\tTYPE");
        System.out.println("------------");
        for (String[] row : report) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
    private static class VowelConsonantCounter {
        private static String checkChar(char c) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        public VowelConsonantCounter() {
        }
    }
}