import java.util.Scanner;

public class WordLengthMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();
        String[] words = input.split(" ");
        String[][] wordData = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];
            wordData[i][1] = String.valueOf(words[i].length());
        }
        System.out.println("\nWORD\t\tLENGTH");
        System.out.println("-----------------------");
        for (int i = 0; i < wordData.length; i++) {
            int len = Integer.parseInt(wordData[i][1]);
            System.out.println(wordData[i][0] + "\t\t" + len);
        }
    }
}