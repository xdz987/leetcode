package 动态规划.背包问题.完全背包.q139_2_单词拆分;

import java.util.List;

/**
 * 方式二：dp+遍历单词
 * Java：78% 100%
 */
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(String word:wordDict){
                int len = word.length();
                if(!comp(s,i-len,word,len)) continue;
                dp[i] = dp[i-len] || dp[i];
            }
        }
        return dp[n];
    }

    private boolean comp(String s,int start,String word,int len){
        if(start<0){
            return false;
        }
        for(int i=0;i<len;i++){
            if(s.charAt(start+i) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
