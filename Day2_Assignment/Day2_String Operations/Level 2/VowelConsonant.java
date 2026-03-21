import java.util.Scanner;
public class VowelConsonant {
    public static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        int[] counts = new int[2];
        for (int i = 0; i < text.length(); i++) {
            String type = checkChar(text.charAt(i));
            if (type.equals("Vowel")) counts[0]++;
            else if (type.equals("Consonant")) counts[1]++;
        }
        System.out.println("Vowels: " + counts[0] + ", Consonants: " + counts[1]);
    }
}