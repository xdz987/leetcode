package 位运算.异或运算.面1719_3_消失的两个数字;

/**
 * q136和剑56_1的拼接题
 * 方法一：位运算
 * Java：100% 70%
 * 复杂度：O(n) O(1)
 */
class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int x = 0;

        //(1)找到相同那两个数a,b的异或结果
        for (int i = 1; i <= n + 2; i++) {
            x ^= i;
        }
        for (int num : nums) {
            x ^= num;
        }
        //(2)找到最右为1的二进制位，用于拆分数组
        int flag = x & -x;

        //(3)根据x最右为1的二进制数，排除这个二进制位为0的i，这样能够排除掉a或b中的一个
        int res = 0;
        for (int i = 1; i <= n + 2; i++) {
            if ((i & flag) != 0) {
                res ^= i;
            }
        }
        for (int num : nums) {
            if ((num & flag) != 0)
                res ^= num;
        }

        //(4)利用异或自反性找到另一个数字
        return new int[]{res, res ^ x};
    }
}