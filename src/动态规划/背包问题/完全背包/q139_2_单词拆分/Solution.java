package 动态规划.背包问题.完全背包.q139_2_单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 方法一：DP——完全背包
 * Java：90% 87%
 * 复杂度：O(N^2) O(N)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //使用Set提高字典的查找速度
        Set<String> wordDictSet = new HashSet<>(wordDict);
        //(1)初始化dp表，边界值当s为空串时为true
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        //(2)遍历s的每个终点，相当于背包容量
        for (int i = 1; i <= n; i++) {
            //(3)遍历每个单词，单词无限，相当于商品无限
            for (String word : wordDict) {
                int len = word.length();
                //(4)状态选择：当当前word可放入背包时（字典中可查到）。选择原结果与保存word相连的位置(即i-len)为中位true的结果
                if (len <= i && wordDictSet.contains(s.substring(i - len, i))) {
                    //初始化dp[i]为false，这里是取true，所以也可忽略
                    dp[i] = dp[i] || dp[i - len];
                    if (dp[i]) break;
                }
            }
        }
        return dp[n];
    }
}