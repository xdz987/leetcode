package 剑指offer补充.剑49_2_丑数;

/**
 * 方法一：DP+找规律
 * java：99% 76%
 * 复杂度：O(N) o(N)
 */
class Solution {
    public int nthUglyNumber(int n) {
        //a,b,c分别对应着2,3,5三种情况
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //第一个丑数
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            //(1)取得第i个丑数
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));

            //(2)更新下标a,b,c，使得下一次计算能够获得下一个丑数
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}