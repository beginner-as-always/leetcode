package arrayandstring;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };

        System.out.println("Input:  " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("Output: " + Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {
        if (nums.length < 2)
            return;

        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[left];
                nums[left++] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
