public class SentenceSearch {
    public static String findFirstSentence(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.contains(targetWord)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] data = {
            "The weather is nice today.",
            "Java is great for DSA.",
            "Linear search is simple."
        };
        String result = findFirstSentence(data, "Java");
        System.out.println("Result: " + result);
    }
}