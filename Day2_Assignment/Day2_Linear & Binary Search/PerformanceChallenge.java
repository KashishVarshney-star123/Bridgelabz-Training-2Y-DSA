import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceChallenge {
    public static void main(String[] args) throws IOException {
        final int ITERATIONS = 1_000_000;
        final String TEST_FILE = "large_test_file.txt";
        System.out.println("--- String Concatenation Performance ---");
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ITERATIONS; i++) sb.append("hello");
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < ITERATIONS; i++) sbf.append("hello");
        System.out.println("StringBuffer:  " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("\n--- File Reading & Word Count Performance ---");
        compareFileReader(TEST_FILE);
        compareInputStreamReader(TEST_FILE);
    }

    private static void compareFileReader(String filePath) {
        long start = System.currentTimeMillis();
        long wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            System.out.println("FileReader (Words: " + wordCount + "): " + (System.currentTimeMillis() - start) + "ms");
        } catch (IOException e) {
            System.out.println("FileReader Error: File not found or unreadable.");
        }
    }

    private static void compareInputStreamReader(String filePath) {
        long start = System.currentTimeMillis();
        long wordCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            System.out.println("InputStreamReader (Words: " + wordCount + "): " + (System.currentTimeMillis() - start) + "ms");
        } catch (IOException e) {
            System.out.println("InputStreamReader Error: File not found or unreadable.");
        }
    }
}