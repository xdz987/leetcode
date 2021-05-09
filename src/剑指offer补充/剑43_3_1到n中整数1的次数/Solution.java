package 剑指offer补充.剑43_3_1到n中整数1的次数;

/**
 * 方法一：数位统计
 * Java：100% 64%
 * 复杂度：O(logN) O(1)
 */
class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1;
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}