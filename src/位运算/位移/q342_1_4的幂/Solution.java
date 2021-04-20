package 位运算.位移.q342_1_4的幂;

/**
 * 方法一：位运算——位移
 * Java：100% 90%
 * 复杂度：O(logW) O(1)
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        int tmp = 1;
        //(1)32位比特中，4的幂是16种情况
        for (int i = 0; i < 16; i++) {
            //(2)判断是否为4的幂
            tmp <<= 2;
            if (n == tmp)
                return true;
            //(3)tmp已经超过n了，再比较无意义，直接返回false剪枝
            if (tmp > n)
                return false;
        }
        return false;
    }
}
