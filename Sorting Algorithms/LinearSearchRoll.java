public class LinearSearchRoll {
    public static void main(String[] args) {
        int[] rollNumbers = {101, 105, 110, 125, 130, 142};
        int target = 125;
        int result = linearSearch(rollNumbers, target);
        if (result != -1) {
            System.out.println("Roll number " + target + " found at index: " + result);
        } else {
            System.out.println("Roll number " + target + " not found in the list.");
        }
    }
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1;
    }
}