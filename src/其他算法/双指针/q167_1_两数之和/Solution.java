package 其他算法.双指针.q167_1_两数之和;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
    }
}

/**
 * 左右指针
 * 设定一个sum值，为nums[left]+nums[right]，比较sum与target的值而调整left和right
 */
class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        //(1)初始化边界
        int left = 0;
        int right = numbers.length - 1;

        //(2)查找符合target的结果
        int sum = 0;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                //leetcode的测试用例需left和right+1
                //return new int[]{left+1,right+1};
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{left, right};
    }
}