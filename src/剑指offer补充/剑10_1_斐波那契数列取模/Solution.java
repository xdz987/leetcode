package 剑指offer补充.剑10_1_斐波那契数列取模;

/**
 * 方法一：线性遍历
 * Java：100% 98%
 * O(N) O(1)
 */
class Solution {
    public int numWays(int n) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        int ppre = 1;
        int pre = 2;
        int cur = 3;
        for (int i = 4; i <= n; i++) {
            ppre = pre;
            pre = cur;
            if (cur >= 45)
                cur = (pre + ppre) % 1000000007;
            else
                cur = pre + ppre;
        }
        return cur;
    }
}