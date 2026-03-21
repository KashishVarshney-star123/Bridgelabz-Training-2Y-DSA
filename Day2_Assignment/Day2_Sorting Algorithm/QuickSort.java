public class QuickSort {

    public static void sort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            sort(prices, low, pi - 1);
            sort(prices, pi + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        double[] productPrices = {1200.50, 450.00, 89.99, 3500.00, 150.75};
        sort(productPrices, 0, productPrices.length - 1);
        System.out.println("Quick Sorted Prices: " + java.util.Arrays.toString(productPrices));
    }
}
