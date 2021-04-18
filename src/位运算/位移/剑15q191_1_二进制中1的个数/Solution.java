package 位运算.位移.剑15q191_1_二进制中1的个数;

/**
 * 方法一：逐个位移
 * Java：97% 97%
 * 复杂度：O(N) O(1)
 */
public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            //>>>无符号右移，忽略符号位，空位都以0补齐
            n >>>= 1;
        }
        return res;
    }
}