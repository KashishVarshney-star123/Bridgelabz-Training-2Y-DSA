public class PerformanceTest {
    public static void main(String[] args) {
        int iterations = 1000000;
        String text = "hello";
        long startTime = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer Time:  " + (endTime - startTime) / 1_000_000 + " ms");
        startTime = System.nanoTime();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sBuilder.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}