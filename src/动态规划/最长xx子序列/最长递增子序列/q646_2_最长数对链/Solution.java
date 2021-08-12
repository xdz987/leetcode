package 动态规划.最长xx子序列.最长递增子序列.q646_2_最长数对链;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 方法一：贪心
 * Java：88% 74%
 * 复杂度：O(N^2) O(1)
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        int n = pairs.length;
        int[] pre = pairs[0];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (pairs[i][0] > pre[1]) {
                res++;
                pre = pairs[i];
            }
        }
        return res;
    }
}