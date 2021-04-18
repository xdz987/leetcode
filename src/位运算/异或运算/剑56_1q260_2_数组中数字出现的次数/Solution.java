package 位运算.异或运算.剑56_1q260_2_数组中数字出现的次数;

/**
 * 方法一：位运算
 * Java：100% 50%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int[] singleNumbers(int[] nums) {
        //(1)找到目标a,b的异或x
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }

        //(2)找到最右为1的二进制位，用于拆分数组
        int flag = x & -x;

        //(3)根据x最右为1的二进制数，排除这个二进制位为0的num，这样能够排除掉a或b中的一个
        int a = 0;
        for (int num : nums) {
            if ((num & flag) != 0) {
                a ^= num;
            }
        }

        //(4)利用异或自反性找到另一个数字
        int b = a ^ x;
        return new int[]{a, b};
    }
}
