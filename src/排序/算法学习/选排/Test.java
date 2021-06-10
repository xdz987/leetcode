package 排序.算法学习.选排;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 4, 6, 1, 9, 3};
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }

}
