package 动态规划.斐波那契类型.斐波那契数列.q650_2_只有两个键的键盘;

/**
 * 方法二：数学
 * Java：100% 90%
 * 复杂度：O(根号n) O(1)
 */
class Solution2 {
    public int minSteps(int n) {
        if (n == 1) return 0;
        //(1)初始化
        int res = 0;
        int d = 2;
        //(2)遍历(n,1]，自上向下计算操作数
        while (n > 1) {
            while (n % d == 0) {
                res += d;
                n /= d;
            }
            d++;
        }
        return res;
    }
}