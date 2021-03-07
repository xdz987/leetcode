package 数组与矩阵.双指针.q485_1_最大连续1的个数;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0};
        FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
        System.out.println(findMaxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
}

/**
 * 循环遍历，动态变化：最大连续1的临时变量，当前连续1的计数变量
 */
class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        //(1)初始化
        int maxLen = 0;
        int count = 0;
        //(2)动态保存最大连续1的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > maxLen) {
                    maxLen = count;
                }
            } else {
                count = 0;
            }
        }
        return maxLen;
    }
}