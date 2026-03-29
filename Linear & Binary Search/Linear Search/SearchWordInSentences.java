public class SearchWordInSentences {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {
            "Java is powerful",
            "Data structures are important",
            "Linear search is simple",
            "Practice makes perfect"
        };
        String word = "search";
        String result = findSentence(sentences, word);
        System.out.println(result);
    }
}