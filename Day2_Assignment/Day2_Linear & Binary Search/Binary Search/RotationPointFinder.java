public class RotationPointFinder {
    public static int findRotationPointIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } 
            else {
                right = mid;
            }
        }
        return left; 
    }

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 1, 2};
        int index = findRotationPointIndex(rotatedArray);
        System.out.println("The rotation point is at index: " + index);
        System.out.println("The smallest element is: " + rotatedArray[index]);
    }
}