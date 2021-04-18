package 位运算.综合统计.剑39q169_1_数组出现次数超半的数;

/**
 * 方法一：位运算
 * Java：23% 85%
 * 复杂度：O(n) O(1) 遍历32次为常数
 */
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res = 0;
        //(1)遍历32个二进制位，mask初始化为1，每次循环左移一位
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            //计数
            int countBit = 0;
            //(2)计数当前二进制mast位的所有num为1的数量
            for (int num : nums) {
                if ((num & mask) != 0)
                    countBit++;
                //(3)当二进制mask位的1数量>n/2时，说明是众数的二进制位，保存到res
                if (countBit > n / 2) {
                    res |= mask;
                    break;
                }
            }
        }

        return res;
    }
}