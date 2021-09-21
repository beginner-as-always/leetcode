package arrayandstring;

import java.util.Arrays;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] input = { 2, 3, 1, 2, 4, 3 };

        System.out.println("Target: " + target);
        System.out.println("Input array: " + Arrays.toString(input));
        System.out.println("Minimum size subarray: " + minSubArrayLen(target, input));
    }

    static int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;

        int left = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }

        return min == nums.length + 1 ? 0 : min;
    }
}
