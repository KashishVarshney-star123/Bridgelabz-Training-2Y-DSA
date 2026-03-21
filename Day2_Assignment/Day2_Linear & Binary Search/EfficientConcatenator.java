public class EfficientConcatenator {
    public static String concatenateStrings(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Java ", "is ", "great ", "for ", "DSA."};
        String result = concatenateStrings(words);
        System.out.println("Result: " + result);
    }
}