public class MergeSort {
    public static void sort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(prices, left, mid);
            sort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        double[] L = new double[n1];
        double[] R = new double[n2];
        for (int i = 0; i < n1; ++i) L[i] = prices[left + i];
        for (int j = 0; j < n2; ++j) R[j] = prices[mid + 1 + j];
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                prices[k] = L[i];
                i++;
            } else {
                prices[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            prices[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            prices[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        double[] bookPrices = {599.99, 120.50, 450.00, 99.99, 210.00};
        System.out.println("Original Prices: " + java.util.Arrays.toString(bookPrices));
        sort(bookPrices, 0, bookPrices.length - 1);
        System.out.println("Sorted Prices:   " + java.util.Arrays.toString(bookPrices));
    }
}