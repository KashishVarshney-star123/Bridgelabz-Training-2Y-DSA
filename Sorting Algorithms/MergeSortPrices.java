import java.util.Arrays;
public class MergeSortPrices {
    public static void main(String[] args) {
        double[] prices = {29.99, 15.50, 45.00, 10.99, 22.75};
        System.out.println("Original Prices: " + Arrays.toString(prices));
        mergeSort(prices, 0, prices.length - 1);
        System.out.println("Sorted Prices: " + Arrays.toString(prices));
    }
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(double[] arr, int l, int m, int r) {
        double[] leftSide = Arrays.copyOfRange(arr, l, m + 1);
        double[] rightSide = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < leftSide.length && j < rightSide.length) {
            if (leftSide[i] <= rightSide[j]) arr[k++] = leftSide[i++];
            else arr[k++] = rightSide[j++];
        }
        while (i < leftSide.length) arr[k++] = leftSide[i++];
        while (j < rightSide.length) arr[k++] = rightSide[j++];
    }
}
