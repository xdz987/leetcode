package 剑指offer补充.剑62_1_圆圈最后数字;

/**
 * 方法二：数学
 */
class Solution2 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}