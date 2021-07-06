package 剑指offer补充.剑16_2_数值的整数次方;

/**
 * 方法一：快速幂
 * Java：98% 95%
 * 复杂度：O(logN) O(1)
 */
class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) return 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }
}