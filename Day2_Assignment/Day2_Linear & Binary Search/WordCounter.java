import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        String filePath = "data.txt";
        String targetWord = "Java";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    String cleanWord = word.replaceAll("[^a-zA-Z]", "");
                    if (cleanWord.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word '" + targetWord + "' appeared " + count + " times.");
        } 
        catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}