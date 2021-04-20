package 位运算.位移.q693_1_交替位二进制数;

/**
 * 方法一：位运算——位移
 * Java：100% 88%
 * 复杂度：O(logN) O(1)
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        //(1)初始化flag等于最右bit取反
        int flag = (n & 1) ^ 1;
        //(2)遍历32位，当n==0说明到最左边bit
        for (int i = 0; i < 32 && n != 0; i++) {
            //(3.1)取得最右bit
            int bit = n & 1;
            //(3.2)相等说明不交替
            if (bit == flag) {
                return false;
            }
            //(3.3)更新flag
            flag = bit;
            //(3.4)n右移1位
            n >>>= 1;
        }
        return true;
    }
}