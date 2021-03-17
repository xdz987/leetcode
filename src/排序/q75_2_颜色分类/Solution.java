package 排序.q75_2_颜色分类;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/**
 * 三指针：指针left控制着0，指针right控制着2，指针i遍历判断为0还是2从而进行与left或right交换
 */
class SortColors {

    //三指针
    public void sortColors(int[] nums) {
        if (nums.length < 2)
            return;
        //(1)初始化，left指向0，right指向1，i用于遍历
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        //(2)当nums[i]等于2放到最右，等于1放到最左
        while (i <= right) {
            if (nums[i] == 2) {
                swap(nums, i, right--);
            } else if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else {
                i++;
            }
        }
    }

    //交换
    private void swap(int[] nums, int i1, int i2) {
        if (i1 != i2) {
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }
    }

    //三指针2 同样思路
    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
                //当为1则不需要交换
                if (nums[i] != 1)
                    i--;
            }
        }
    }
}