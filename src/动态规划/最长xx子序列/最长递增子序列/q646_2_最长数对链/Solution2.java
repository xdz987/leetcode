package 动态规划.最长xx子序列.最长递增子序列.q646_2_最长数对链;

import java.util.Arrays;

/**
 * 方法二：DP
 * Java：
 * 复杂度：
 */
public class Solution2 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] o1, int[] o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            else
                return o1[1] - o2[1];
        });
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
