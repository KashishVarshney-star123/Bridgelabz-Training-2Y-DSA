import java.util.HashSet;
public class DuplicateRemover {
    public static String removeDuplicates(String input) {
        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!seen.contains(currentChar)) {
                result.append(currentChar);
                seen.add(currentChar);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Original: " + input);
        System.out.println("Unique:   " + removeDuplicates(input));
    }
}