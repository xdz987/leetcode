package 动态规划.背包问题._01背包.q474_2_一和零;

/**
 * 方法一：DP——0/1背包
 * Java：81% 74%
 * 复杂度：O(strsLen*N*M) O((N+1)*(M+1))
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //状态压缩前为：
        //int[][][] dp = new int[strs.length+1][m + 1][n + 1]
        int[][] dp = new int[m + 1][n + 1];
        //(1)外层循环遍历每个(商品)
        for (String str : strs) {
            int[] cal = calcZeroAndOne(str);
            int zeroCount = cal[0];
            int oneCount = cal[1];
            //(2)如果背包放得下该商品。则累加目标数量
            //这里采用逆序是因为进行了状态压缩且商品是唯一的，所以逆序dp[i][j]才是上一行(即上一商品)
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCount][j - oneCount] + 1);
                }
            }
            //第(2)步跟下面的思路一模一样，只是多了个格子罢了
//            for (int i = m; i >= zeroCount; i--) {
//                dp[i] = Math.max(dp[i], dp[i - zeroCount] + 1);
//            }
        }
        return dp[m][n];
    }

    private int[] calcZeroAndOne(String str) {
        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }
}