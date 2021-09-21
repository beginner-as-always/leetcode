package arrayandstring;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1 };

        System.out.println("Input:  " + Arrays.toString(nums));
        System.out.println("Output: " + removeDuplicates(nums) + ", " + Arrays.toString(nums));
    }

    static int removeDuplicates(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; ) {
            nums[k++] = nums[i];

            int n = nums[i];
            while (i < nums.length && nums[i] == n)
                i++;
        }

        return k;
    }
}
