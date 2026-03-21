public class CountingSort {
    public static void sortAges(int[] ages) {
        int n = ages.length;
        int max = 18;
        int min = 10;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[ages[i] - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        System.arraycopy(output, 0, ages, 0, n);
    }
    public static void main(String[] args) {
        int[] studentAges = {15, 10, 12, 18, 10, 15, 14};
        sortAges(studentAges);
        System.out.println("Sorted Ages: " + java.util.Arrays.toString(studentAges));
    }
}