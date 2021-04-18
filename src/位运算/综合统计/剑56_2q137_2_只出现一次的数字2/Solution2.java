package 位运算.综合统计.剑56_2q137_2_只出现一次的数字2;

/**
 * 方法一：有限自动状态机
 * Java：100% 60%
 * 复杂度：O(n) O(1)
 */
class Solution2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}