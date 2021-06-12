package 剑指offer补充.剑14_2_剪绳子2;

/**
 * 方法一：循环取余
 * Java：100% 93%
 * 复杂度：O(N) O(1)
 */
class Solution {
    public int cuttingRope(int n) {
        if (n < 4)
            return n - 1;
        if (n == 4)
            return 4;
        long cal = 1;
        while (n > 4) {
            cal *= 3;
            cal %= 1000000007;
            n -= 3;
        }
        return (int) ((cal * n) % 1000000007);
    }

    //二刷：简洁版
    public int cuttingRope2(int n) {
        if (n < 4)
            return n - 1;
        long res = 1;
        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int) ((res * n) % 1000000007);
    }
}