import java.util.Scanner;
public class WordWithLength {
    public static String[] splitCustom(String str) {
        return str.split(" ");
    }
    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitCustom(text);
        String[][] result = wordWithLength(words);
        System.out.println("Word\tLength");
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i][0] + "\t" + result[i][1]);
        }
    }
}