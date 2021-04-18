package 位运算.与运算.q231_1_2的幂;

/**
 * 方案一：巧用x&(x-1)
 * Java：100% 80%
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
