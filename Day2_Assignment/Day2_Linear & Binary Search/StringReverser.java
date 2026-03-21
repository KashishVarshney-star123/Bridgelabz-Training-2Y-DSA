public class StringReverser {
    public static String reverseString(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        String original = "hello";
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reverseString(original));
    }
}