public class FirstAndLast{
    public static int[] findFirstAndLast(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findOccurrence(nums, target, true);
        result[1] = findOccurrence(nums, target, false);
        return result;
    }

    private static int findOccurrence(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int resultIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                resultIndex = mid;
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = findFirstAndLast(nums, target);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }
}