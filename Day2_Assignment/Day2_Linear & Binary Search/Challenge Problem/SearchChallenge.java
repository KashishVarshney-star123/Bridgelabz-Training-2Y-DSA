import java.util.Arrays;

public class SearchChallenge {
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 2];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return 1;
    }

    public static int binarySearchTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {3, 4, -1, 1};
        int target = 4;
        int missing = findFirstMissingPositive(data);
        System.out.println("First Missing Positive: " + missing);
        int targetIndex = binarySearchTarget(data, target);
        System.out.println("Index of " + target + " in sorted array: " + targetIndex);
    }
}