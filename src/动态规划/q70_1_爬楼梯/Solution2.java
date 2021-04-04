package 动态规划.q70_1_爬楼梯;

/**
 * 方法二：Fibonaci
 */
public class Solution2 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int ppre = 1;
        int pre = 2;
        int res = 0;
        for (int weight = 3; weight <= n; weight++) {
            res = ppre + pre;
            ppre = pre;
            pre = res;
        }
        return res;
    }
}
