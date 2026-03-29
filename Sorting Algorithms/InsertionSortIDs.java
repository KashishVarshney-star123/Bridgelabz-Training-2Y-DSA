import java.util.Arrays;
public class InsertionSortIDs {
    public static void main(String[] args) {
        int[] ids = {105, 101, 110, 103, 102};
        System.out.println("Original IDs: " + Arrays.toString(ids));
        insertionSort(ids);
        System.out.println("Sorted IDs: " + Arrays.toString(ids));
    }
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
