package 其他算法.双指针.q283_1_移动零;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}

/**
 * 实际不需要移动0，只需要移动非0元素至左边，再将右边填充为0即可
 * 双指针
 */
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        //(1)将非0元素向左靠拢，采用直接覆盖的方法
        int notZeroI = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[notZeroI++] = nums[i];
            }
        }
        //(2)填充0元素
        while (notZeroI < nums.length) {
            nums[notZeroI++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}