package 动态规划.最长xx子序列.最长公共子序列.q115_3_不同的子序列;

/**
 * 方法一：DP
 * Java：35% 5%/95%
 * 复杂度：O(NM) O(NM)/O(M) O(M)为状态压缩
 */
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        if (s.length() == t.length()) return s.equals(t) ? 1 : 0;
        //(1)初始化dp数组
        /*
            初始化边界：
            1. 当成子串小到为空串""时，主串删除所有字符得到子序列组合为1个，所以dp[0~n][0]=1
            2. 当主串和子串都为空时，组合数为1，所以dp[0][0]=1
            3. 当主串为空""，子串不为空时，组合数一定Wie0，所以dp[1~n][j]=0
         */
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++)
            dp[i][0] = 1;
        //(2)遍历主串
        for (int i = 1; i <= s.length(); i++) {
            //(3)遍历子串
            for (int j = 1; j <= t.length(); j++) {
                //(3.1)当字符相等时
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //截止至子串的上一个字符([0,j-1])组合数＋遍历至主串的第i-1个字符时的截止至子串当前字符([0,j])的组合数
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                //(3.2)当字符不相等时
                else {
                    //延续上一个匹配结果，即遍历至主串的第i-1个字符时的截止至子串当前字符([0,j])的组合数
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //(4)返回子串组合数
        return dp[s.length()][t.length()];
    }

    //状态压缩
    public int numDistinct2(String s, String t) {
        if (s.length() < t.length()) return 0;
        if (s.length() == t.length()) return s.equals(t) ? 1 : 0;
        int[] dp = new int[t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            int lastPre = 1;
            for (int j = 1; j <= t.length(); j++) {
                int last = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += lastPre;
                }
                lastPre = last;
            }
        }
        return dp[t.length()];
    }

}