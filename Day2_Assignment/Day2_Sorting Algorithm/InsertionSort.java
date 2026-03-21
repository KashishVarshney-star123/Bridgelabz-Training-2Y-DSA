public class InsertionSort {
    public static void sortIDs(int[] ids) {
        int n = ids.length;
        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }
            ids[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] employeeIDs = {105, 102, 110, 101, 104};
        sortIDs(employeeIDs);
        System.out.println("Sorted Employee IDs: " + java.util.Arrays.toString(employeeIDs));
    }
}
