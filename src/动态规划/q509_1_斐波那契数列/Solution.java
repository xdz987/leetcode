package 动态规划.q509_1_斐波那契数列;

/**
 * 动态规划 + 状态压缩
 */
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int pre = 1, ppre = 1, res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre + ppre;
            ppre = pre;
            pre = res;
        }
        return res;
    }
}