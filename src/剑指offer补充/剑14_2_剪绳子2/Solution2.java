package 剑指offer补充.剑14_2_剪绳子2;

/**
 * 方法二：数学
 */
class Solution2 {
    public int cuttingRope(int n) {
        if (n < 4)
            return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}