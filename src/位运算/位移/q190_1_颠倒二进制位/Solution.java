package 位运算.位移.q190_1_颠倒二进制位;

/**
 * 方法一：位运算——位移
 * Java：100% 70%
 * 复杂度：O(logN) O(1) 逐1反转需要logN
 */
public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        //(1)遍历所有比特位。PS：当n=0时没必要颠倒，直接break剪枝
        for (int i = 0; i < 32 && n != 0; i++) {
            //(2)res保存：n最右比特值左移31-i位
            res |= (n & 1) << (31 - i);
            //(3)n右移1位
            n >>>= 1;
        }
        return res;
    }
}